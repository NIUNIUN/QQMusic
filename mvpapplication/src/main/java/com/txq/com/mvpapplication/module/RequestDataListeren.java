package com.txq.com.mvpapplication.module;

import java.util.List;

/**
 * Created by Administrator on 2017/1/3 0003.
 */

public interface RequestDataListeren {

        void success(List<String> stringList);

        void failed();

}
