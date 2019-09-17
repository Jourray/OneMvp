package com.example.framwork.contract;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/9/1719:26
 * desc   :
 * package: Myp:
 */
public interface MainContract {
    interface MainView {
        void showSuccess();

        void showError();
    }

    interface MainPresenter {
        void Http();
    }

    interface MianModel {
        interface Callback {
            void showSuccess();

            void showError();
        }

        void getData(Callback callback);
    }
}
