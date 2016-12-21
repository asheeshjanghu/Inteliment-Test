package com.optus.demoapptest.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.optus.demoapptest.R;
import com.optus.demoapptest.adapters.MyViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnPageChange;

public class TabTaskActivity extends AppCompatActivity {

    @BindView (R.id.rlContainer)
    RelativeLayout mRlContainer;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView (R.id.viewPager)
    ViewPager mViewPager;
    @BindView (R.id.tvItemNameIndicator)
    TextView mTvItemNameIndicator;
    @BindView (R.id.llButtonsContainer)
    LinearLayout mLLButtonsContainer;
    @BindView(R.id.ivDot1)
    ImageView ivDot1;
    @BindView(R.id.ivDot2)
    ImageView ivDot2;
    @BindView(R.id.ivDot3)
    ImageView ivDot3;
    @BindView(R.id.ivDot4)
    ImageView ivDot4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_task);
        ButterKnife.bind(this);
        initializeViews();
    }

    private void initializeViews(){
        setupViewPager();
        setupTabLayout();
    }

    @OnClick(R.id.btnBlue)
    public void onBlueButtonClick(View v) {
        mRlContainer.setBackgroundColor(getResources().getColor(R.color.colorBlue));
    }

    @OnClick(R.id.btnRed)
    public void onRedButtonClick(View v) {
        mRlContainer.setBackgroundColor(getResources().getColor(R.color.colorRed));
    }

    @OnClick(R.id.btnGreen)
    public void onGreenButtonClick(View v) {
        mRlContainer.setBackgroundColor(getResources().getColor(R.color.colorGreen));
    }

    private void setupTabLayout() {
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mTvItemNameIndicator.setText(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @OnPageChange(R.id.viewPager)
    public void onPageChange(int position){
        Toast.makeText(getApplicationContext(), "Fragment " + String.valueOf(position + 1), Toast.LENGTH_SHORT).show();
        setActiveFragmentDot(position);
    }

    private void setupViewPager() {
        final MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myViewPagerAdapter);
        setActiveFragmentDot(0);
    }

    private void setActiveFragmentDot(int position){
        ivDot1.setColorFilter(ContextCompat.getColor(TabTaskActivity.this, R.color.textColorPrimary));
        ivDot2.setColorFilter(ContextCompat.getColor(TabTaskActivity.this, R.color.textColorPrimary));
        ivDot3.setColorFilter(ContextCompat.getColor(TabTaskActivity.this, R.color.textColorPrimary));
        ivDot4.setColorFilter(ContextCompat.getColor(TabTaskActivity.this, R.color.textColorPrimary));
        switch (position) {
            case 0:
                ivDot1.setColorFilter(ContextCompat.getColor(TabTaskActivity.this, R.color.colorAccent));
                break;

            case 1:
                ivDot2.setColorFilter(ContextCompat.getColor(TabTaskActivity.this, R.color.colorAccent));
                break;

            case 2:
                ivDot3.setColorFilter(ContextCompat.getColor(TabTaskActivity.this, R.color.colorAccent));

                break;

            case 3:
                ivDot4.setColorFilter(ContextCompat.getColor(TabTaskActivity.this, R.color.colorAccent));

                break;

            default:
                break;
        }
    }
}
