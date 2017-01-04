package com.txq.com.mvpdemo.presenter;

import android.os.Handler;

import com.txq.com.mvpdemo.MainActivity;
import com.txq.com.mvpdemo.modle.RequestDataIml;
import com.txq.com.mvpdemo.modle.RequestDataListener;
import com.txq.com.mvpdemo.view.MvpView;

import java.util.List;

/**  P层
 * Created by Administrator on 2017/1/3 0003.
 */

public class MVPPresenter implements IMVPPresenter {

        private MvpView mvpView;

        private MainActivity mainActivity;

        private RequestDataIml requestDataIml;

        private Handler handler = new Handler();

        public MVPPresenter(MainActivity mainActivity, MvpView mvpView) {
                this.mainActivity = mainActivity;
                this.mvpView = mvpView;
        }

        @Override
        public void getData() {

                mvpView.showProgress();

                requestDataIml  = new RequestDataIml(new RequestDataListener() {
                        @Override
                        public void success(final List<String> list) {
                                handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                                mvpView.hideProgress();
                                                mvpView.showData( list );
                                        }
                                });
                        }

                        @Override
                        public void failed() {

                                handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                                mvpView.showToast();
                                        }
                                });
                        }
                });
                requestDataIml.getDate();

        }

        @Override
        public void onViewDestory() {
                mainActivity = null;
        }
}
