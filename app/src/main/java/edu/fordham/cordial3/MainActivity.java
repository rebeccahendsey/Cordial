package edu.fordham.cordial3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText address;
    EditText email;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        register = findViewById(R.id.registration);

        // Check if the information entered is valid
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDataEntered();
            }
        });
    }
    boolean isEmail(EditText text){
        CharSequence email = text.getText().toString();
        return(!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    void checkDataEntered(){
        if(isEmail(email) == false){
            email.setError("Invalid email. Try again.");
        }
        if(isEmpty(firstName)){
            Toast t = Toast.makeText(this, "Required field!", Toast.LENGTH_SHORT);
            t.show();
        }
        if(isEmpty(lastName)){
            lastName.setError("Required field!");
        }
    }
}