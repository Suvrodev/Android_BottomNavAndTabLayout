package com.example.bottomnavandtablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class ShareFragment extends Fragment {


    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_share, container, false);
        tabLayout=view.findViewById(R.id.tablayout_id);
        viewPager=view.findViewById(R.id.view_Pager_id);

        viewPager.setAdapter(new MyPAgeAdapter(getParentFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return view;
    }

    class MyPAgeAdapter extends FragmentPagerAdapter {

        String[] Text={"Bangladesh","India","USA"};

        public MyPAgeAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if(position==0){
                return new BangladeshFragment();
            }else if(position==1){
                return new IndiaFragment();
            }else if(position==2){
                return new UsaFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return Text.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return Text[position];
        }
    }
}