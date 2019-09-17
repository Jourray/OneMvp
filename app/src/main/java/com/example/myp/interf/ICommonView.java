package com.example.myp.interf;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/9/168:20
 * desc   :
 * package: Myp:
 */
public interface ICommonView<T> {
    void onError(int whickApi, Throwable e);

    void onResponse(int whichApi, T... t);
}
