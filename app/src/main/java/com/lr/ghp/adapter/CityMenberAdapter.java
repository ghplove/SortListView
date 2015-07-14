package com.lr.ghp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lr.ghp.model.GroupMemberBean;
import com.lr.ghp.sortlistview.R;

import java.util.List;

/**
 * Created by ghp on 15/7/14.
 */
public class CityMenberAdapter extends BaseAdapter {
    private List<GroupMemberBean> list = null;
    private Context mContext;

    public CityMenberAdapter(List<GroupMemberBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        GroupMemberBean mContent = list.get(position);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.city_member_item, null);
            viewHolder.cityMember = (TextView) convertView.findViewById(R.id.cityMember);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.cityMember.setText(mContent.getName());

        return convertView;

    }
    final static class ViewHolder{
        TextView cityMember;
    }
}
