package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by guilhermecardoso on 9/23/15.
 */
public abstract class SingleFragmentActivity extends FragmentActivity {

    protected abstract Fragment creareFragment();

    @Override
    public void onCreate(Bundle savedinstanceState){
        super.onCreate(savedinstanceState);

        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = creareFragment();
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
    }
}
