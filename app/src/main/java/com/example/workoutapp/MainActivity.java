package com.example.workoutapp;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.workoutapp.ui.home.HomeFragment;
import com.example.workoutapp.ui.login.LoginFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(navListener);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); //Create recycler view in linearlayout

        myAdapter = new MyAdapter(this, getMyList());

        mRecyclerView.setAdapter(myAdapter);
        //boolean firstTimeUser = true;

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);
    }

    private ArrayList<WorkoutModel> getMyList(){
        ArrayList<WorkoutModel> models = new ArrayList<>();

        WorkoutModel m = new WorkoutModel();
        m.setTitle("Squat");
        m.setDescription("Ass to grass");
        m.setImg(R.drawable.benchpress);                    //Add images in drawable folder
        m.setTitle("Bench Press");
        m.setDescription("A chest to impress");
        m.setImg(R.drawable.benchpress);                    //Add images in drawable folder

        m.setTitle("Bicep Curls");
        m.setDescription("Curls for the girls");
        m.setImg(R.drawable.benchpress);                    //Add images in drawable folder

        return models;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch(menuItem.getItemId()){
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navigation_dashboard:
                    selectedFragment = new WorkoutFragment();
                    break;
                case R.id.navigation_notifications:
                    selectedFragment = new SettingFragment();
                    break;
                case R.id.loginScreen:
                    selectedFragment = new LoginFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).commit();
            return true;
        }
    };
}
