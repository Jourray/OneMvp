package com.example.framwork.base;

import android.webkit.WebView;

import java.lang.ref.WeakReference;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/9/1719:26
 * desc   :
 * package: Myp:
 */
public class BasePresenter<V> {

    private WeakReference<V> vWeakReference;
    public V mview;

    public void attach(V view) {
        vWeakReference = new WeakReference<>(view);
        this.mview = vWeakReference.get();
    }

    public void detachView() {
        if (vWeakReference != null) {
            vWeakReference.clear();
        }
    }
}
