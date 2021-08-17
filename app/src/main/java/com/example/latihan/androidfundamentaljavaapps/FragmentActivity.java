package com.example.latihan.androidfundamentaljavaapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.example.latihan.androidfundamentaljavaapps.fragment.HomeFragment;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager mfFragmentManager = getSupportFragmentManager();
        HomeFragment mhHomeFragment = new HomeFragment();
        Fragment fragment = mfFragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());

        if (!(fragment instanceof  HomeFragment)){
            Log.d("MyFlexibleFragment", "Fragment Name"+HomeFragment.class.getCanonicalName());
            mfFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, mhHomeFragment, HomeFragment.class.getCanonicalName())
                    .commit();
        }
    }
}