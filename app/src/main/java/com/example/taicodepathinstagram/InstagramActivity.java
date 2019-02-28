package com.example.taicodepathinstagram;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.taicodepathinstagram.fragments.ComposeFragment;
import com.example.taicodepathinstagram.fragments.PostsFragment;
import com.example.taicodepathinstagram.fragments.ProfileFragment;

public class InstagramActivity extends AppCompatActivity {


    private final String TAG = "InstagramActivity";


    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);
        final FragmentManager fragmentManager = getSupportFragmentManager();

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.actionHome:
                      //TODO: swap fragment here
                       fragment= new PostsFragment();
                      // Toast.makeText(InstagramActivity.this,"home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.actionCompose:
                        fragment= new ComposeFragment();
                       // Toast.makeText(InstagramActivity.this,"home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.actionProfile:
                    default:
                        //swap fragment here
                        fragment= new ProfileFragment();
                        //Toast.makeText(InstagramActivity.this,"home", Toast.LENGTH_SHORT).show();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.container ,fragment).commit();
                return true;
            }
        });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.actionHome);
    }
}
