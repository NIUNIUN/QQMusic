package com.txq.com.mvpdemo.modle;

import java.util.ArrayList;
import java.util.List;

/**  类似于一个网络请求（ M层 ）
 * Created by Administrator on 2017/1/3 0003.
 */

public class RequestDataIml implements RequestData {

        private RequestDataListener listener;

        public RequestDataIml(RequestDataListener listener) {
                this.listener = listener;
        }

        @Override
        public void getDate() {
                new Thread(){
                        @Override
                        public void run() {
                                try {
                                        Thread.sleep( 3000 );

                                        List<String> list   = new ArrayList<String>();
                                        for( int i = 0; i < 20 ; i++ ){
                                                list.add( " item --> " + i );
                                        }

                                        if( listener != null ){
                                               listener.success( list );
                                        }else{
                                                listener.failed();
                                        }

                                } catch (InterruptedException e) {
                                        e.printStackTrace();
                                }
                        }
                }.start();
        }
}
