package com.example.nutrilab;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private BottomNavigationView bottomNav;
    private HomeFragment homeFragment = new HomeFragment();
    private HistoryFragment historyFragment = new HistoryFragment();
    private UserFragment userFragment = new UserFragment();

    private void initUI(){
        frameLayout = findViewById(R.id.container_fragment);
        bottomNav = findViewById(R.id.bottom_navigation);
    }

    private void goToFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, fragment).commit();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        goToFragment(homeFragment);

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.menu_home) {
                    goToFragment(homeFragment);
                    return true;
                } else if (id == R.id.menu_history) {
                    goToFragment(historyFragment);
                    return true;
                } else if (id == R.id.menu_user) {
                    goToFragment(userFragment);
                    return true;
                }
                return false;
            }
        });
    }
}
