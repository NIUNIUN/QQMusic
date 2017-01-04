package com.txq.com.mvpapplication.presenter;

import android.os.Handler;
import com.txq.com.mvpapplication.module.MvpModule;
import com.txq.com.mvpapplication.module.RequestDataListeren;
import com.txq.com.mvpapplication.view.IView;
import com.txq.com.mvpapplication.view.MainActivity;
import java.util.List;

/**
 * Created by Administrator on 2017/1/3 0003.
 */

public class Presenter extends BasePresenter<MainActivity> {

        private Handler handler = new Handler();

        private MvpModule mvpModule;

        private IView view;

        public Presenter(IView view) {
                this.view = view;
        }

        @Override
        public void getData() {

                mvpModule = new MvpModule();

                view.showProgress();

                mvpModule.getData(new RequestDataListeren() {
                        @Override
                        public void success(final List<String> stringList) {
                                handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                                view.hideProgress();
                                                view.showData( stringList );
                                        }
                                });
                        }

                        @Override
                        public void failed() {
                                view.showToast( "网络请求失败，请重新检查网络！" );
                        }
                });
        }
}
