package com.txq.com.mvpdemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.txq.com.mvpdemo.modle.RequestDataIml;
import com.txq.com.mvpdemo.modle.RequestDataListener;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {


        private ListView listView;
        private ProgressBar progressBar;

        private Handler handler = new Handler();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                listView = (ListView) findViewById(R.id.listview);
                progressBar = (ProgressBar) findViewById(R.id.progressbar);

                progressBar.setVisibility(View.VISIBLE );

                RequestDataIml requestDataIml = new RequestDataIml(new RequestDataListener() {
                        @Override
                        public void success(final List<String> list) {

                                handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                                progressBar.setVisibility( View.INVISIBLE );

                                                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1, list );
                                                listView.setAdapter(adapter);
                                        }
                                });
                        }

                        @Override
                        public void failed() {

                               // 请求失败
                                handler.post(new Runnable() {
                                        @Override
                                        public void run() {

                                                Toast.makeText(MainActivity.this, "网络请求失败，请检查网络", Toast.LENGTH_SHORT).show();
                                        }
                                });
                        }
                });

                // 调用请求网络
                requestDataIml.getDate();

        }



}
