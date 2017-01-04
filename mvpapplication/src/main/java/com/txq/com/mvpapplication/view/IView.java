package com.txq.com.mvpapplication.view;

import java.util.List;

/**
 * Created by Administrator on 2017/1/3 0003.
 */

public interface IView {

        void showData(List<String> stringList );

        void showProgress();

        void hideProgress();

        void showToast( String str );

}
