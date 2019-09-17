package com.example.myp.interf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.example.myp.utils.NetWorkUtils;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/9/168:21
 * desc   :
 * package: Myp:
 */
public class NetStatusBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            int netWorkState = NetWorkUtils.getNetWorkState(context);
            if (netStatusListener != null) {
                netStatusListener.onNetChanged(netWorkState);
            }
        }
    }

    private NetStatusListener netStatusListener;

    public void setNetStatusListener(NetStatusListener netStatusListener) {
        this.netStatusListener = netStatusListener;
    }

    public interface NetStatusListener {
        void onNetChanged(int state);
    }

}
