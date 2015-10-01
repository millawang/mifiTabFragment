package com.fia.mia.mifitabfragment.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.fia.mia.mifitabfragment.R;
import com.fia.mia.mifitabfragment.activity.fragment.ContentFragment;
import com.fia.mia.mifitabfragment.activity.fragment.testTabFragment;


public class MainActivity extends FragmentActivity {

    ContentFragment mContentFragment;
    testTabFragment mTabFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContentFragment = new ContentFragment();
        mTabFragment = new testTabFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.tab_layout, mTabFragment).commitAllowingStateLoss();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_layout, mContentFragment).commitAllowingStateLoss();
    }

    public void setContentText(String text){

        mContentFragment.setContent(text);

    }


}
