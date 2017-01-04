package com.txq.com.mvpapplication.module;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/3 0003.
 */

public class MvpModule implements IMvpModule {

        @Override
        public void  getData(final RequestDataListeren dataListeren) {
                new Thread(){
                        @Override
                        public void run() {

                                try {
                                        Thread.sleep( 3000 );
                                } catch (InterruptedException e) {
                                        e.printStackTrace();
                                }

                                List<String> list  = new ArrayList<>();
                                for( int i = 0; i < 15 ; i++ ){
                                        list.add( "item --->" + i );
                                }

                                if( dataListeren != null ){
                                        dataListeren.success(  list );
                                }else{
                                        dataListeren.failed();
                                }
                        }
                }.start();
        }
}
