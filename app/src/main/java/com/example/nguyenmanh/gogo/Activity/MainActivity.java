package com.example.nguyenmanh.gogo.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nguyenmanh.gogo.Adapter.MainViewPagerAdapter;
import com.example.nguyenmanh.gogo.Fragment.Fragment_Tim_Kiem;
import com.example.nguyenmanh.gogo.Fragment.Fragment_Trang_Chu;
import com.example.nguyenmanh.gogo.Fragment.fragment_lienhe;
import com.example.nguyenmanh.gogo.R;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();
    }

    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_Trang_Chu(),"trang chu");
        mainViewPagerAdapter.addFragment(new Fragment_Tim_Kiem(),"tim kiếm");
        mainViewPagerAdapter.addFragment(new fragment_lienhe(),"liên hệ");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void anhxa() {
        tabLayout = findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPager);
    }
}
