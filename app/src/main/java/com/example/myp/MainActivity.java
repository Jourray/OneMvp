package com.example.myp;

import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;

import com.example.myp.base.BaseMvpActivity;
import com.example.myp.comm.CommonPresenter;
import com.example.myp.interf.NetStatusBroadCast;
import com.example.myp.model.HomeModel;

public class MainActivity extends BaseMvpActivity<HomeModel> {

    @Override
    protected void initData() {
        registerNetWorkStatus();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected HomeModel getModel() {
        return new HomeModel();
    }

    @Override
    protected CommonPresenter getPresenter() {
        return new CommonPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onNetChanged(int state) {
        super.onNetChanged(state);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (netStatusBroadCast != null) {
            unregisterReceiver(netStatusBroadCast);
        }
    }

    @Override
    public void onNetConnected() {
        super.onNetConnected();

    }

    @Override
    public void onNetDisConnected() {
        super.onNetDisConnected();
    }
}
