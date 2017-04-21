package com.example.admin.assignment3.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.assignment3.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOuter1 extends Fragment {

    private ViewPager vpStatus;
    private FragmentOuter1.InnerPagerAdapter pagerAdapter;
    private TabLayout tb;
    private int fragmentID;
    private Bundle fragmentId;
    private Bundle fragmentId1;
    private InnerFragment innerFragment;

    /**
     * constructor
     */
    public FragmentOuter1() {

    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_outer1, container, false);
        // Inflate the layout for this fragment

        fragmentId = new Bundle();
        fragmentId1 = new Bundle();
        fragmentID = getArguments().getInt("fragmentID");
        Toast.makeText(getActivity(), fragmentID + "", Toast.LENGTH_SHORT).show();
        vpStatus = (ViewPager) view.findViewById(R.id.vp_status);
        pagerAdapter = new FragmentOuter1.InnerPagerAdapter(getChildFragmentManager());
        pagerAdapter.addTitle();
        innerFragment = new InnerFragment();

        fragmentId.putInt("fragmentId", 1);
        innerFragment.setArguments(fragmentId);
        pagerAdapter.addItems(innerFragment);

        innerFragment = new InnerFragment();
        fragmentId1.putInt("fragmentId", 2);
        innerFragment.setArguments(fragmentId1);
        pagerAdapter.addItems(innerFragment);

        vpStatus.setAdapter(pagerAdapter);
        tb = (TabLayout) view.findViewById(R.id.tab_heading1);
        tb.setupWithViewPager(vpStatus);

        return view;
    }


    /**
     * Class
     */
    private class InnerPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments = new ArrayList<Fragment>();
        private List<String> titles = new ArrayList<String>();

        /**
         *
         * @param fm manager
         */
        public InnerPagerAdapter(final FragmentManager fm) {
            super(fm);
        }

        /**
         *
         * @param fragment fragmnet
         */
        public void addItems(final Fragment fragment) {
            fragments.add(fragment);

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
            if (fragmentID == 1) {
//                if(position == 0) {
//                    linearLayout.setBackgroundColor(getResources().getColor(R.color.colorA, null));
//                } else {
//                    linearLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent, null));
//                }
                return titles.get(position);
            } else {
//                if(position == 0) {
//                    linearLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary, null));
//                } else {
//                    linearLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark, null));
//                }
                return titles.get(position + 2);
            }
        }

        /**
         * addTitles
         */
        private void addTitle() {
            titles.add("Pending");
            titles.add("Accepted");
            titles.add("Completed");
            titles.add("Cancelled");
        }
    }
}