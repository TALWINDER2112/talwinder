package com.example.admin.assignment3.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.assignment3.Fragment.FragmentOuter1;
import com.example.admin.assignment3.R;

import java.util.ArrayList;
import java.util.List;

/**
 * class
 */
public class ScreenCActivity extends AppCompatActivity {

    private ViewPager vpJobs;
    private OuterPagerAdapter pagerAdapter;
    private TabLayout tb;
    private Bundle fragmentId;
    private Bundle fragmentId1;
    private FragmentOuter1 fragment;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_c);
        fragmentId = new Bundle();
        fragmentId1 = new Bundle();
        vpJobs = (ViewPager) findViewById(R.id.vp_jobs);
        pagerAdapter = new OuterPagerAdapter(getSupportFragmentManager());

        fragmentId.putInt("fragmentID", 1);
        fragment = new FragmentOuter1();
        fragment.setArguments(fragmentId);
        pagerAdapter.addItems(fragment, "Upcoming");



        fragmentId1.putInt("fragmentID", 2);
        fragment = new FragmentOuter1();
        fragment.setArguments(fragmentId1);
        pagerAdapter.addItems(fragment, "Past");

        vpJobs.setAdapter(pagerAdapter);
        tb = (TabLayout) findViewById(R.id.tab_heading);
        tb.setupWithViewPager(vpJobs);

    }

    /**
     * class
     */
    private class OuterPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments = new ArrayList<Fragment>();
        private List<String> titles = new ArrayList<String>();

        /**
         *
         * @param fm fm
         */
        public OuterPagerAdapter(final FragmentManager fm) {
            super(fm);
        }

        /**
         *
         * @param fragmen fm
         * @param title tt
         */
        public void addItems(final Fragment fragmen, final String title) {
            fragments.add(fragmen);
            titles.add(title);

        }

        @Override
        public Fragment getItem(final int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(final int position) {
            super.getPageTitle(position);
            return titles.get(position);
        }
    }
}
