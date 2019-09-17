package com.example.myp.app;

import android.app.Application;
import android.content.Context;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/9/168:47
 * desc   :
 * package: Myp:
 */
public class MyApplication extends Application {
    public static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }

    public static Context getAppContext() {
        return myApplication.getApplicationContext();
    }

    public static MyApplication getMyApplication() {
        return myApplication;
    }
}
