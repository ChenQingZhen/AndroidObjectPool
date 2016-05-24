package com.cqz.androidobjectpool;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.cqz.androidobjectpool.adapter.MemberListAdapter;
import com.cqz.androidobjectpool.model.UserBean;
import com.cqz.androidobjectpool.model.UserRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvMember;
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

    }
     class GetDataAsyncTask extends AsyncTask<Void,Void,List<UserBean>>{

        @Override
        protected List<UserBean> doInBackground(Void... voids) {
            return UserRepository.getUserList();
        }

        @Override
        protected void onPostExecute(List<UserBean> userBeen) {
            super.onPostExecute(userBeen);
            lvMember.setAdapter(new MemberListAdapter(MainActivity.this,userBeen));
        }
    }

}
