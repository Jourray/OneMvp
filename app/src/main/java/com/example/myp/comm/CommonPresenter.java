package com.example.myp.comm;

import com.example.myp.base.BasePresenter;
import com.example.myp.interf.ICommonView;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/9/169:02
 * desc   :
 * package: Myp:
 */
public class CommonPresenter extends BasePresenter implements ICommonView, ICommonPresenter {

    @Override
    public void onError(int whickApi, Throwable e) {
        if (getView() != null) {
            getView().onError(whickApi, e);
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        if (getView() != null) {
            getView().onResponse(whichApi, t);
        }
    }

    @Override
    public void getData(int whichApi, Object[] t) {
        if (getModel() != null) {
            getModel().getData(this, whichApi, t);
        }

    }
}
