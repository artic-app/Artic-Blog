package anway.somani.artic_blog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class AcceptBlogTitle extends AppCompatActivity {

    Button acceptedBlogTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accept_blog_title);

        acceptedBlogTitle = (Button) findViewById(R.id.accepted_blog_title);
        acceptedBlogTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcceptBlogTitle.this, BlogContentWrite.class);
                startActivity(intent);
            }
        });

    }
}
