package com.asashka.instagrama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.asashka.instagrama.home.HomeFragment;
import com.asashka.instagrama.model.Post;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<Post> posts;
    BottomNavigationView bottomNavigationView;
    FragmentContainerView fragmentContainerView;
    public List<Post> post = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.main_bottom_nav);
        fragmentContainerView = findViewById(R.id.main_container);
        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {

            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_container, new HomeFragment())
                                .commit();
                        break;
                    case R.id.menu_search:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_container, new SearchFragment())
                                .commit();
                        break;
                    case R.id.menu_like:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_container, new LikeFragment())
                                .commit();
                        break;
                    case R.id.menu_gallery:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_container, new GalleryFragment())
                                .commit();
                        break;
                    case R.id.menu_profile:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_container, new ProfileFragment())
                                .commit();
                        break;
                }
                return;
            }
        });
    }
}

