package com.txq.com.mvpdemo.view;

import java.util.List;

/**  V 层
 * Created by Administrator on 2017/1/3 0003.
 */

public interface MvpView  {

        void showData(List<String> list );
        void showProgress();
        void hideProgress();

        void showToast();

}
