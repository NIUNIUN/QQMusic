package com.txq.com.mvpdemo.modle;

import java.util.List;

/**
 * Created by Administrator on 2017/1/3 0003.
 */

public interface RequestDataListener {

        void success(List<String> list);   // 网络请求成功

        void failed();  // 网络请求失败

}
