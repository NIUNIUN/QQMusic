package com.txq.com.mvpapplication.view;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.txq.com.mvpapplication.R;
import com.txq.com.mvpapplication.presenter.Presenter;
import java.util.List;

public class MainActivity extends BaseView<MainActivity,Presenter> {


        private ListView listView;
        private ProgressBar progressBar;

        private int id = R.layout.activity_main ;

        @Override
        public int getContentId() {
                return id ;
        }

        @Override
        public void init() {
                 listView = (ListView) findViewById(R.id.listview);
                 progressBar = (ProgressBar) findViewById(R.id.progressbar);
        }

        @Override
        public Presenter getPresenter() {
                return new Presenter( this );
        }

        @Override
        public void showData(List<String> stringList) {
                ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,stringList);
                listView.setAdapter( adapter );
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
        public void showToast(String str) {
                Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
}
