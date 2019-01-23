package com.example.qyy.mydatabinding.navigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.qyy.mydatabinding.R;

import androidx.navigation.fragment.NavHostFragment;

public class NavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        Log.v("OOOOO","onCreate");
    }

    /**
     * app:defaultNavHost="true" navigation将接管系统的back键
     *
     * @return
     */
    @Override
    public boolean onSupportNavigateUp() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.nav_fragment);
        return NavHostFragment.findNavController(fragment).navigateUp();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("OOOOO","onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("OOOOO","onDestroy");
    }
}
