package com.example.myp.base;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.myp.app.MyApplication;
import com.example.myp.interf.NetStatusBroadCast;

import static com.example.myp.utils.NetWorkUtils.NETWORK_MOBILE;
import static com.example.myp.utils.NetWorkUtils.NETWORK_WIFI;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/9/168:19
 * desc   :
 * package: Myp:
 */
public class BaseActivity extends AppCompatActivity implements NetStatusBroadCast.NetStatusListener {

    public MyApplication application;
    public NetStatusBroadCast netStatusBroadCast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化Application
        application = (MyApplication) getApplication();

    }

    @Override
    public void onNetChanged(int state) {
        if (state == NETWORK_MOBILE || state == NETWORK_WIFI) {
            onNetConnected();
        } else {
            onNetDisConnected();
        }
    }

    public void onNetDisConnected() {

    }

    public void onNetConnected() {

    }

    public void registerNetWorkStatus() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        netStatusBroadCast = new NetStatusBroadCast();
        netStatusBroadCast.setNetStatusListener(this);
        registerReceiver(netStatusBroadCast, intentFilter);
    }
}
