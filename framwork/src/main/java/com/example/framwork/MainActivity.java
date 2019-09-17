package com.example.framwork;

import com.example.framwork.base.BaseActivity;
import com.example.framwork.contract.MainContract;
import com.example.framwork.presenter.IMainPresenter;

public class MainActivity extends BaseActivity<MainContract.MainView, IMainPresenter<MainContract.MainView>> implements MainContract.MainView {


    @Override
    protected void initViewAndData() {
        mPresenter.Http();
    }

    @Override
    protected int createLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showSuccess() {

    }

    @Override
    public void showError() {

    }

    @Override
    protected IMainPresenter<MainContract.MainView> createPresenter() {
        return new IMainPresenter<>();
    }
}
