package com.txq.com.mvpapplication.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.txq.com.mvpapplication.presenter.BasePresenter;

/**
 * Created by Administrator on 2017/1/3 0003.
 */

public abstract class BaseView<V extends BaseView,P extends BasePresenter<V>> extends AppCompatActivity implements IView{

        private P presenter ;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

                setContentView( getContentId() );

                init();
        }

        /**
         * 获得activity显示的布局ID
         * @return
         */
        public abstract int getContentId();

        public abstract void init();

        @Override
        protected void onResume() {
                super.onResume();

                presenter = getPresenter();

                presenter.getData();
        }

        @Override
        protected void onDestroy() {
                super.onDestroy();

                presenter.onViewDestory();
        }

        public abstract P getPresenter();

}
