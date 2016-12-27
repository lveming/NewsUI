package com.example.lm.newsdemo.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.lm.newsdemo.R;
import com.example.lm.newsdemo.frament.FuwuFragment;
import com.example.lm.newsdemo.frament.NewsFragment;
import com.example.lm.newsdemo.frament.ShezhiFragment;
import com.example.lm.newsdemo.frament.ShouyeFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationBar.OnTabSelectedListener {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private BottomNavigationBar mBottomNavigationBar;
    //监听器，或者说是将Toolbar跟DrawerLayout绑定的工具，V7包下的，V4也可以
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private FrameLayout frameLayout;
    private ShouyeFragment mShouyeFragment;
    private NewsFragment mNewsFragment;
    private FuwuFragment mFuwuFragment;
    private ShezhiFragment mShezhiFragment;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setDefaultFragment();

    }

    private void setDefaultFragment() {
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        mShouyeFragment =ShouyeFragment.newInstance("首页");
        ft.add(R.id.id_main_FrameLayout,mShouyeFragment);
        ft.commit();
    }

    private void initView() {

        mDrawerLayout= (DrawerLayout) findViewById(R.id.id_main_DrawerLayout);
        mToolbar= (Toolbar) findViewById(R.id.id_toolbar);
        //设置标题栏
        setSupportActionBar(mToolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setTitle("标题");
            //让导航图标显示出来
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //mDrawerLayout,mToolbar绑定，参数4,5是对打开和关闭的描述
        mActionBarDrawerToggle=new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,
                R.string.open_drawer,R.string.close_drawer);
        //初始化状态
        mActionBarDrawerToggle.syncState();
        //设置抽屉监听
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);

        mNavigationView= (NavigationView) findViewById(R.id.id_main_NavigationView);
        //设置默认选中
        mNavigationView.setCheckedItem(R.id.id_menu_SHOEYE);
        //设置每项的监听
        mNavigationView.setNavigationItemSelectedListener(this);

        mBottomNavigationBar= (BottomNavigationBar) findViewById(R.id.id_BottomNavigationBar);
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.shouye, "首页").setActiveColor(R.color.green))
                .addItem(new BottomNavigationItem(R.mipmap.news, "新闻").setActiveColor(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.mipmap.fuwu, "服务").setActiveColor(R.color.blue))
                .addItem(new BottomNavigationItem(R.mipmap.shezhi, "设置").setActiveColor(R.color.yellow))
                .setFirstSelectedPosition(0)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(this);

        frameLayout= (FrameLayout) findViewById(R.id.id_main_FrameLayout);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        mDrawerLayout.closeDrawers();
        return true;
    }

    @Override
    public void onTabSelected(int position) {//未选择 --> 选择
        Log.d(TAG, "onTabSelected() called with: " + "position = [" + position + "]");
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();

        switch (position){
            case 0:
                if (mShouyeFragment==null){
                    mShouyeFragment=ShouyeFragment.newInstance("首页");
                }
                transaction.replace(R.id.id_main_FrameLayout,mShouyeFragment);
                break;
            case 1:
                if (mNewsFragment==null){
                    mNewsFragment=NewsFragment.newInstance("新闻");
                }
                transaction.replace(R.id.id_main_FrameLayout,mNewsFragment);
                break;
            case 2:
                if (mFuwuFragment==null){
                    mFuwuFragment=FuwuFragment.newInstance("服务");
                }
                transaction.replace(R.id.id_main_FrameLayout,mFuwuFragment);
                break;
            case 3:
                if (mShezhiFragment==null){
                    mShezhiFragment=ShezhiFragment.newInstance("设置");
                }
                transaction.replace(R.id.id_main_FrameLayout,mShezhiFragment);
                break;
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {//选择 --> 未选择
        Log.d(TAG, "onTabUnselected() called with: " + "position = [" + position + "]");
    }

    @Override
    public void onTabReselected(int position) {//选择 --> 选择
        Log.d(TAG, "onTabReselected() called with: " + "position = [" + position + "]");
    }
}
