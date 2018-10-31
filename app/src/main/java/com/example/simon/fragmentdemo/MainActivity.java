package com.example.simon.fragmentdemo;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Fragment mFristFragment;
    private Fragment mSecondFragment;
    private View mContent;
    private Fragment mCurrentFragment;
    boolean isSecond = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFristFragment = new FirstFragment();
        mSecondFragment = new SecondFragment();
        mContent = findViewById(R.id.content);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.content, mFristFragment);
        ft.add(R.id.content, mSecondFragment);
        ft.hide(mSecondFragment).show(mFristFragment).commit();
        mCurrentFragment = mFristFragment;
        isSecond = false;

        mContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSecond) {
                    getFragmentManager().beginTransaction().hide(mCurrentFragment).show(mSecondFragment).commit();
                    mCurrentFragment = mSecondFragment;
                    isSecond = true;
                } else {
                    getFragmentManager().beginTransaction().hide(mCurrentFragment).show(mFristFragment).commit();
                    mCurrentFragment = mFristFragment;
                    isSecond = false;
                }
            }
        });
    }

}
