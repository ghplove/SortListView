package com.lr.ghp.sortlistview;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.lr.ghp.fragment.CityFragment;
import com.lr.ghp.fragment.ProvinceFragment;


public class MainActivity extends ActionBarActivity {
    private FrameLayout provinceLayout;
    private FrameLayout cityLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setProvinceLayout();
    }

    private void initView(){
        provinceLayout= (FrameLayout) findViewById(R.id.provinceLayout);
        cityLayout= (FrameLayout) findViewById(R.id.cityLayout);
    }
    private void setProvinceLayout(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        ProvinceFragment fragment = new ProvinceFragment();
        transaction.replace(R.id.provinceLayout, fragment);
        transaction.commit();
    }
    private void setCityLayout(String province){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        CityFragment fragment = new CityFragment();
        fragment.setProvince(province);
        transaction.replace(R.id.cityLayout, fragment);
        transaction.commit();
    }
    public void getProvinces(){
        cityLayout.clearAnimation();
        Animation enterAnim= AnimationUtils.loadAnimation(this, R.anim.foot_move_exit);
        cityLayout.startAnimation(enterAnim);
        cityLayout.setVisibility(View.GONE);
        provinceLayout.setVisibility(View.VISIBLE);
    }
    public void getCitys(String province){
        cityLayout.clearAnimation();
        Animation enterAnim= AnimationUtils.loadAnimation(this, R.anim.foot_move_enter);
        cityLayout.startAnimation(enterAnim);
        cityLayout.setVisibility(View.VISIBLE);
        setCityLayout(province);
        cityLayout.setLayoutAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                provinceLayout.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
