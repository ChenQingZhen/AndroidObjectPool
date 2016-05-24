package com.cqz.androidobjectpool.model;

import android.support.v4.util.Pools;

/**
 * Created by chenqingzhen on 2016/5/23.
 */
public class UserBean {
    private static final Pools.SynchronizedPool<UserBean> sPool=new Pools.SynchronizedPool<>(10);

    public static UserBean obtain(){
        UserBean instance=sPool.acquire();
        if(instance!=null){
            instance.setType("来自对象池");
        }else{
           instance=  new UserBean();
            instance.setType("新建的");
        }
        return  instance;
    }
    public void recycle(){
        this.setType("被释放的");
        sPool.release(this);

    }



    private int id;
    private String name;
    private String job;

    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
