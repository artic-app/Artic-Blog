package anway.somani.artic_blog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    private Button reset_pass_submit,cancel;
    private EditText email_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        email_text = (EditText)findViewById(R.id.reset_email);
        reset_pass_submit = (Button)findViewById(R.id.reset_conf);
        cancel = (Button)findViewById(R.id.cancel_btn);

        reset_pass_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailid = email_text.getText().toString();
                if (emailid.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter Email Address",Toast.LENGTH_SHORT).show();
                }else {
                    FirebaseAuth.getInstance().sendPasswordResetEmail(emailid);
                    if (FirebaseAuth.getInstance().sendPasswordResetEmail(emailid).isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Email Sent", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPasswordActivity.this,LoginActivity.class));
                finish();
            }
        });
    }
}
