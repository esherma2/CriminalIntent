package com.bignerdranch.android.criminalintent;

import android.support.v4.app.Fragment;
import android.widget.CompoundButton;

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new CrimeListFragment();



        //invoke onCheckChanged method
    }
}
