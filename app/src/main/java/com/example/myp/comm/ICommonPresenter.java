package com.example.myp.comm;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/9/169:03
 * desc   :
 * package: Myp:
 */
public interface ICommonPresenter<T> {
    void getData(int whichApi, T... t);
}
