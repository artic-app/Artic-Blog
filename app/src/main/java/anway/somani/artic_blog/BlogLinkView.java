package anway.somani.artic_blog;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

public class BlogLinkView extends AppCompatActivity {

    WebView blogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_blog);

        String url = "http://wikipedia.com/";
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));

    }
}
