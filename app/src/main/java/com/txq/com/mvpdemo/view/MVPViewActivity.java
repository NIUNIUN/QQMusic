package com.txq.com.mvpdemo.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.txq.com.mvpdemo.R;
import com.txq.com.mvpdemo.modle.RequestDataIml;
import com.txq.com.mvpdemo.modle.RequestDataListener;
import com.txq.com.mvpdemo.presenter.MVPPresenter;

import java.util.List;

import static android.R.id.list;

public class MVPViewActivity extends AppCompatActivity implements MvpView {

        private ListView listView;
        private ProgressBar progressBar;

        private  MVPPresenter mvpPresenter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                listView = (ListView) findViewById(R.id.listview);
                progressBar = (ProgressBar) findViewById(R.id.progressbar);

                 mvpPresenter = new MVPPresenter(this);
                mvpPresenter.getData();
        }

        @Override
        public void showData(List<String> list) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,list);
                listView.setAdapter( arrayAdapter );
        }

        @Override
        public void showProgress() {
                progressBar.setVisibility(View.VISIBLE );
        }

        @Override
        public void hideProgress() {
                progressBar.setVisibility( View.INVISIBLE );
        }

        @Override
        public void showToast() {
                Toast.makeText(MVPViewActivity.this, "网络请求失败，请检查网络", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onDestroy() {
                super.onDestroy();

                // 取消Persenter 对Activity的引用。避免Activity引起内存泄漏
                mvpPresenter.onViewDestory();

        }
}
