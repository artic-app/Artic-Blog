package anway.somani.artic_blog;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_preference:
                    PreferenceFragment fragment_preference = new PreferenceFragment();
                    fragmentTransaction.add(R.id.container, fragment_preference);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_home:
                    HomeFragment fragment_home = new HomeFragment();
                    fragmentTransaction.add(R.id.container, fragment_home);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_myblogs:
                    MyBlogFragment fragment_myblog = new MyBlogFragment();
                    fragmentTransaction.add(R.id.container, fragment_myblog);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_profile:
                    ProfileFragment fragment_profile = new ProfileFragment();
                    fragmentTransaction.add(R.id.container, fragment_profile);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_settings:
                    SettingsFragment fragment_settings = new SettingsFragment();
                    fragmentTransaction.add(R.id.container, fragment_settings);
                    fragmentTransaction.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
