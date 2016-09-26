package com.uestczhh.app.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.support.design.widget.TabLayout;

import com.uestczhh.app.R;
import com.uestczhh.app.adapter.NewsFragmentAdapter;
import com.uestczhh.app.base.BaseActivity;
import com.uestczhh.app.fragment.NewsFragement;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻
 * Created by zhanghao on 2016/9/26.
 */
public class NewsActivity extends BaseActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private FloatingActionButton actionButton;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ImageView ivAdd;
    private NewsFragmentAdapter fragmentAdapter;
    private List<Fragment> listFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        getData();
        initView();

        setAdater();
    }

    private void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.news_drawer);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        navigationView = (NavigationView) findViewById(R.id.news_navigation_view);
        actionButton = (FloatingActionButton) findViewById(R.id.news_action_btn);
        viewPager = (ViewPager) findViewById(R.id.news_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.news_tablayout);
        ivAdd = (ImageView) findViewById(R.id.news_add);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(NewsActivity.this, drawerLayout,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();
    }

    private void setAdater() {
        fragmentAdapter = new NewsFragmentAdapter(getSupportFragmentManager(), listFragment);
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    private void getData() {
        listFragment = new ArrayList<>();
        NewsFragement fragement = new NewsFragement();
        NewsFragement fragement1 = new NewsFragement();
        NewsFragement fragement2 = new NewsFragement();
        NewsFragement fragement3 = new NewsFragement();
        listFragment.add(fragement);
        listFragment.add(fragement1);
        listFragment.add(fragement2);
        listFragment.add(fragement3);
    }


}













