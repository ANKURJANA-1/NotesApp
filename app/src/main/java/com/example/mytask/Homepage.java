package com.example.mytask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Homepage extends AppCompatActivity {


    private TabLayout header;
    private ViewPager viewPager;
    private Helper helper;
    private TabItem notes,task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        header = (TabLayout) findViewById(R.id.header);
        viewPager = findViewById(R.id.page_container);
        notes=findViewById(R.id.notes);
        task=findViewById(R.id.tasks);


        helper=new Helper(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(helper);

        header.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(header));

    }
}