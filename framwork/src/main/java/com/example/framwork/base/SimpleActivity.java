package com.example.framwork.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/9/1719:25
 * desc   :
 * package: Myp:
 */
public abstract class SimpleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createLayout());
        viewCreateded();
        initViewAndData();
    }

    protected abstract void initViewAndData();

    protected abstract void viewCreateded();

    protected abstract int createLayout();

}
