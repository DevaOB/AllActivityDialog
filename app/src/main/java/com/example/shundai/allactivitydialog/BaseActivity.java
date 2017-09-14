package com.example.shundai.allactivitydialog;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import butterknife.ButterKnife;

/**
 * Created by win7 on 2017/8/28.
 */

public abstract class BaseActivity extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        ButterKnife.bind(this);
        initData();
        initView();
    }

    public abstract int getLayoutRes();

    protected abstract void initData();

    protected abstract void initView();
}
