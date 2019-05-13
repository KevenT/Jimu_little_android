package com.example.keven.toptabbar;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity2 extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private TabLayout.Tab four;
    public View rootView;
    public LayoutInflater mInflater;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        getSupportActionBar().hide();//隐藏掉整个ActionBar
//        setContentView(R.layout.activity_main);
//
//        //初始化视图
//        initViews();
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mInflater=inflater;
        rootView = inflater.inflate(R.layout.activity_main, container, false);
//        initView(rootView);
//        initEvent();
//        onShow();
        return rootView;
    }


    private void initViews(View view) {

        //使用适配器将ViewPager与Fragment绑定在一起
//        mViewPager= (ViewPager) view.findViewById(R.id.viewPager);
//        myFragmentPagerAdapter = new MyFragmentPagerAdapter(view.getSupportFragmentManager());
//        mViewPager.setAdapter(myFragmentPagerAdapter);

        //将TabLayout与ViewPager绑定在一起
        mTabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);

        //指定Tab的位置
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);
        three = mTabLayout.getTabAt(2);
        four = mTabLayout.getTabAt(3);

        //设置Tab的图标
//        one.setIcon(R.mipmap.ic_launcher);
//        two.setIcon(R.mipmap.ic_launcher);
//        three.setIcon(R.mipmap.ic_launcher);
//        four.setIcon(R.mipmap.ic_launcher);


    }
}