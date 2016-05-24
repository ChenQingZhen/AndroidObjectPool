package com.cqz.androidobjectpool.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenqingzhen on 2016/5/23.
 */
public class UserRepository {
    private static int position=0;
    private static final String[] jobs={"teacher","programmer","engineer"};
    public static List<UserBean> getUserList(){
        List<UserBean> userList=new ArrayList<>();
        UserBean user=null;
        for(int i=0;i<10;i++){
            user= UserBean.obtain();
            user.setId(position);
            user.setName("user"+position);
            user.setJob(getJob(i));
            userList.add(user);
            position++;
        }
        return userList;
    }
    private static String getJob(int i){
        return jobs[i%3];
    }
    public static void init(){
        for(int i=0;i<10;i++){
           new UserBean().recycle();
        }
    }
}
