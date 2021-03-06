package anway.somani.artic_blog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NewBlogActivity extends AppCompatActivity {

    Button nextScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newblog);

        nextScreen = (Button) findViewById(R.id.nextScreen);
        nextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewBlogActivity.this, AcceptBlogTitle.class);
                startActivity(intent);
            }
        });
    }
}
