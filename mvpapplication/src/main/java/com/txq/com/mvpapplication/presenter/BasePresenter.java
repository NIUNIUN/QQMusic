package com.txq.com.mvpapplication.presenter;

import com.txq.com.mvpapplication.view.BaseView;

/** 基类
 * Created by Administrator on 2017/1/3 0003.
 */

public  abstract   class BasePresenter<V extends BaseView> implements IPresenter {

        public V view;

        public void onViewCreate(V view) {
                this.view = view;
        }

        @Override
        public void onViewDestory() {
                view = null;
        }
}
