package com.example.keven.toptabbar;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private TabLayout.Tab four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();//隐藏掉整个ActionBar
        setContentView(R.layout.activity_main);

        //初始化视图
        initViews();
    }

    private void initViews() {

        //使用适配器将ViewPager与Fragment绑定在一起
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myFragmentPagerAdapter);

        //将TabLayout与ViewPager绑定在一起
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
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

        updateTabTextView(mTabLayout.getTabAt(mTabLayout.getSelectedTabPosition()), true);


        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());

                updateTabTextView(tab, true);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                updateTabTextView(tab, false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void updateTabTextView(TabLayout.Tab tab, boolean isSelect) {

        if (isSelect) {
            //选中加粗
//            TextView tabSelect = (TextView) tab.getCustomView().findViewById(R.id.tab_item_textview);
//            TextView tabSelect =(TextView)(((LinearLayout) ((LinearLayout) mTabLayout.getChildAt(0)).getChildAt(tab.getPosition())).getChildAt(1));
            TextView tabSelect = (TextView) (((LinearLayout) ((LinearLayout) mTabLayout.getChildAt(0)).getChildAt(tab.getPosition())).getChildAt(1));
//            System.out.println("===tabSelect.getTextSize()==="+tabSelect.getTextSize());
            tabSelect.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
//            tabSelect.setTextSize(textSize+38);
            tabSelect.setText(tab.getText());
        } else {
//            TextView tabUnSelect = (TextView) tab.getCustomView().findViewById(R.id.tab_item_textview);
            TextView tabUnSelect = (TextView) (((LinearLayout) ((LinearLayout) mTabLayout.getChildAt(0)).getChildAt(tab.getPosition())).getChildAt(1));
            tabUnSelect.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
//            tabUnSelect.setTextSize(textSize);
            tabUnSelect.setText(tab.getText());
        }
    }
}