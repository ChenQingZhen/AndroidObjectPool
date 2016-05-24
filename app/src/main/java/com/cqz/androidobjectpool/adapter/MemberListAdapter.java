package com.cqz.androidobjectpool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.cqz.androidobjectpool.R;
import com.cqz.androidobjectpool.model.UserBean;

import java.util.List;

/**
 * Created by chenqingzhen on 2016/5/23.
 */
public class MemberListAdapter extends BaseAdapter{
    private List<UserBean> mUserList;
    private Context mContext;
    public MemberListAdapter(Context context, List<UserBean> userList) {
        mContext=context;
        mUserList = userList;
    }
    public void clear(){
       for(int i=mUserList.size()-1;i>=0;i--){
           mUserList.remove(i).recycle();
       }
    }
    public void addAll(List<UserBean> userList){
        mUserList.addAll(userList);
    }

    @Override
    public int getCount() {
        return mUserList.size();
    }

    @Override
    public UserBean getItem(int i) {
        return mUserList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mUserList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View convertView=view;
        ViewHolder holder=null;
        if(convertView==null){
         convertView = LayoutInflater.from(mContext).inflate(R.layout.view_member_list_item,viewGroup,false);
            holder=new ViewHolder();
            holder.tvName= (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvjob= (TextView) convertView.findViewById(R.id.tv_job);
            holder.tvType= (TextView) convertView.findViewById(R.id.tv_type);
            convertView.setTag(holder);
        }else{
          holder= (ViewHolder) convertView.getTag();
      }
        UserBean user= getItem(i);
        holder.tvName.setText(user.getName());
        holder.tvjob.setText(user.getJob());
        holder.tvType.setText(user.getType()+"");
        return convertView;
    }

    private static class ViewHolder{
        TextView tvName;
        TextView tvjob;
        TextView tvType;
    }
}
