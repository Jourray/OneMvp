package com.example.myp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.myp.comm.CommonPresenter;
import com.example.myp.comm.ICommonModel;
import com.example.myp.interf.ICommonView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/9/168:18
 * desc   :
 * package: Myp:
 */
public abstract class BaseMvpActivity<M> extends BaseActivity implements ICommonView {

    private Unbinder bind;
    public CommonPresenter presenter;
    public M model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        bind = ButterKnife.bind(this);
        presenter = getPresenter();
        model=getModel();
        if(presenter!=null){
            presenter.attach(this, (ICommonModel) model);
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract M getModel();

    protected abstract CommonPresenter getPresenter();

    protected abstract int getLayoutId();

    @Override
    public void onError(int whickApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
        presenter.detach();
    }
}
