package com.example.framwork.presenter;

import com.example.framwork.base.BasePresenter;
import com.example.framwork.contract.MainContract;
import com.example.framwork.model.IMainModle;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/9/1719:27
 * desc   :
 * package: Myp:
 */
public class IMainPresenter<V extends MainContract.MainView> extends BasePresenter<V> implements MainContract.MainPresenter, MainContract.MianModel.Callback {

    private MainContract.MianModel mianModel = new IMainModle();

    @Override
    public void Http() {
        if (mview != null) {
            mianModel.getData(this);
        }
    }

    @Override
    public void showSuccess() {
        mview.showSuccess();
    }

    @Override
    public void showError() {
        mview.showError();
    }
}
