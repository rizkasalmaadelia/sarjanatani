package com.rizkasalma.test4;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;



public class Home extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            HomeFragment fragment;
            ArtikelFragment fragment2;
            ProfileFragment fragment3;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,
                            fragment, fragment.getClass().getSimpleName()).commit();
                    return true;
                case R.id.navigation_dashboard:
                    fragment2 = new ArtikelFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,
                            fragment2, fragment2.getClass().getSimpleName()).commit();
                    return true;
                case R.id.navigation_notifications:
                    fragment3 = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,
                            fragment3, fragment3.getClass().getSimpleName()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null) {
            navigation.setSelectedItemId(R.id.navigation_home);
        }


    }

}
