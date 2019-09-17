package com.example.myp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/9/168:25
 * desc   :
 * package: Myp:
 */
public class NetWorkUtils {
    public static final int NETWORK_WIFI = 1;
    public static final int NETWORK_MOBILE = 0;
    public static final int NETWORK_NONE = -1;

    public static int getNetWorkState(Context context) {
        ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                return NETWORK_WIFI;
            } else if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                return NETWORK_MOBILE;
            } else {
                return NETWORK_NONE;
            }
        }
        return NETWORK_NONE;
    }

    //是否有网络
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    //WIFI
    public static boolean isWiFiConnect(Context context) {
        ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                return true;
            }
        }
        return false;
    }
}
