package com.example.myp.comm;

import com.example.myp.interf.ICommonView;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/9/169:05
 * desc   :
 * package: Myp:
 */
public interface ICommonModel<T> {
    void getData(ICommonView view, int whichApi, T... t);

}
