package com.cqz.androidobjectpool;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.cqz.androidobjectpool.adapter.MemberListAdapter;
import com.cqz.androidobjectpool.model.UserBean;
import com.cqz.androidobjectpool.model.UserRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvMember;
    private MemberListAdapter mAdapter;

    private boolean isRefresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        new GetDataAsyncTask().execute();
    }

    private void initView() {
     lvMember= (ListView) findViewById(R.id.lv_member);
        Button btnAdd= (Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRefresh=false;
                initData();
            }
        });
    Button btnRefresh= (Button) findViewById(R.id.btn_refresh);
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRefresh=true;
                initData();
            }
        });
    }
     class GetDataAsyncTask extends AsyncTask<Void,Void,List<UserBean>>{

        @Override
        protected List<UserBean> doInBackground(Void... voids) {
            return UserRepository.getUserList();
        }

        @Override
        protected void onPostExecute(List<UserBean> userBeen) {
            super.onPostExecute(userBeen);
            if(mAdapter==null) {
                mAdapter = new MemberListAdapter(MainActivity.this, userBeen);
                lvMember.setAdapter(mAdapter);
            }else{
                if(isRefresh){
                    mAdapter.clear();
                }
                mAdapter.addAll(userBeen);
                mAdapter.notifyDataSetChanged();
            }
            }
    }

}
