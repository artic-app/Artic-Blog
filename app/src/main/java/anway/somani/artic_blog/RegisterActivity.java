package anway.somani.artic_blog;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText name, password, mobile, emailid;
    private Button signup_submit, signup_cancel;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        auth = FirebaseAuth.getInstance();

        signup_submit = (Button) findViewById(R.id.Submit);
        signup_cancel = (Button) findViewById(R.id.signup_cancel);
        password = (EditText) findViewById(R.id.pass_input);
        mobile = (EditText) findViewById(R.id.signup_mobile);
        name = (EditText) findViewById(R.id.signup_name);
        emailid = (EditText) findViewById(R.id.email_signup);


        signup_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String signup_email = emailid.getText().toString().trim();
                String signup_passwd = password.getText().toString();
                String signup_phone = mobile.getText().toString();
                String signup_name = name.getText().toString();
                if (TextUtils.isEmpty(signup_email)) {
                    Toast.makeText(getApplicationContext(), "Enter Email Address", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(signup_passwd)) {
                    Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_LONG).show();
                    return;
                }
                if (signup_passwd.length() < 8) {
                    Toast.makeText(getApplicationContext(), "Password Too Short", Toast.LENGTH_LONG).show();
                }
                if (TextUtils.isEmpty(signup_name)) {
                    Toast.makeText(getApplicationContext(), "Enter Username ", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.createUserWithEmailAndPassword(signup_email,signup_passwd)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(getApplicationContext(),"Sign Up Successfull ;)",Toast.LENGTH_SHORT).show();

                                if (!task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(),"Registration failed",Toast.LENGTH_SHORT).show();
                                }else {
                                    startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                                    finish();
                                }
                            }
                        });
            }
        });//Ends on click Listener
        signup_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}

