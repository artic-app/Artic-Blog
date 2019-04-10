package anway.somani.artic_blog;

import android.content.Intent;
import android.os.Bundle;
import android.view.FocusFinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import androidx.appcompat.app.AppCompatActivity;

public class BlogContentWrite extends AppCompatActivity {

    private Button submit_content,cancel_content,local;
    private EditText content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_content);

        submit_content = (Button) findViewById(R.id.content_submit_btn);
        content = (EditText) findViewById(R.id.content_body);
        cancel_content = (Button) findViewById(R.id.cancel_content_save);
        local = (Button) findViewById(R.id.local_save);

        local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BlogContentWrite.this,bloguploadedview.class));
            }
        });

        cancel_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BlogContentWrite.this,MainActivity.class));
                Toast.makeText(getApplicationContext(),"Canceled Save",Toast.LENGTH_SHORT).show();
            }
        });

        submit_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* String con;
                con = content.getText().toString();

                if(con.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter Content to publish",Toast.LENGTH_LONG).show();
                }else {
                    String foldername,title;
                    FirebaseStorage fs = FirebaseStorage.getInstance("gs://artic-blog.appspot.com/");
                    StorageReference sr = fs.getReference();
                    foldername = FirebaseAuth.getInstance().getCurrentUser().toString();

                    StorageReference imageRef = sr.child(foldername/);
                }*/
                startActivity(new Intent(BlogContentWrite.this,bloguploadedview.class));
            }
        });

        finish();
    }
}
