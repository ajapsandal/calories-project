package com.example.android.nekitkach;

import android.os.Bundle;
import android.view.View;

import com.example.android.nekitkach.ui.main.VPAdapter;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android.nekitkach.ui.main.SectionsPagerAdapter;
import com.example.android.nekitkach.databinding.ActivityMainMenuBinding;

public class MainMenu extends AppCompatActivity {
    private ActivityMainMenuBinding binding;
    private User theUser;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentManager fragmentManager;
    private FirstTab firstTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        tabLayout = findViewById(R.id.menuTabs);
        viewPager = findViewById(R.id.viewPager);
        tabLayout.setupWithViewPager(viewPager);
        theUser = (User) getIntent().getSerializableExtra("user");

        FragmentManager fr = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putInt("calories", theUser.getCaloriesPerDay());
        firstTab = new FirstTab();
        firstTab.setArguments(bundle);


        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(firstTab,"Данные");
        vpAdapter.addFragment(new SecondTab(),"Рацион");
        viewPager.setAdapter(vpAdapter);

    }





}