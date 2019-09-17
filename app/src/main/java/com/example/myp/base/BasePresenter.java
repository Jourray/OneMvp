package com.example.myp.base;

import com.example.myp.comm.ICommonModel;
import com.example.myp.interf.ICommonView;

import java.lang.ref.WeakReference;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/9/169:04
 * desc   :
 * package: Myp:
 */
public class BasePresenter<V extends ICommonView, M extends ICommonModel> {

    private WeakReference<V> view;
    private WeakReference<M> model;

    public void attach(V view, M model) {
        this.view = new WeakReference<>(view);
        this.model = new WeakReference<>(model);
    }

    public void detach() {
        if (view != null) {
            view.clear();
            this.view = null;
        }
        if (model != null) {
            model.clear();
            this.model = null;
        }
    }

    public V getView() {
        return view != null ? view.get() : null;
    }

    public M getModel() {
        return model != null ? model.get() : null;

    }
}
