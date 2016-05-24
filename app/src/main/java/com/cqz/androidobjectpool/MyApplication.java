package com.cqz.androidobjectpool;

import android.app.Application;

import com.cqz.androidobjectpool.model.UserRepository;

/**
 * Created by chenqingzhen on 2016/5/23.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new MyThread().start();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            UserRepository.init();
        }
    }
}
