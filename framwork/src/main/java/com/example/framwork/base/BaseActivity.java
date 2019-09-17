package com.example.framwork.base;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/9/1719:25
 * desc   :
 * package: Myp:
 */
public abstract class BaseActivity<V, P extends BasePresenter<V>> extends SimpleActivity {
    public P mPresenter;

    @Override
    protected void viewCreateded() {
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attach((V) this);
        }
    }


    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
