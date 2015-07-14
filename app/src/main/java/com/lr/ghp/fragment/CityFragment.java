package com.lr.ghp.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lr.ghp.adapter.CityMenberAdapter;
import com.lr.ghp.adapter.SortGroupMemberAdapter;
import com.lr.ghp.model.GroupMemberBean;
import com.lr.ghp.sortlistview.MainActivity;
import com.lr.ghp.sortlistview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CityFragment extends Fragment  {
    private MainActivity mainActivity;
    private View view;
    private String province;
    private ListView sortListView;
    private CityMenberAdapter adapter;
    private RelativeLayout titleLayout;
    private TextView title;
    private RelativeLayout goProvince;
    private List<GroupMemberBean> SourceDateList;
    public CityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_city, container, false);
        mainActivity= (MainActivity) getActivity();
        initView();
        initDate();
        return view;
    }
    private void initView(){
        titleLayout = (RelativeLayout) view.findViewById(R.id.city_title_layout);
        title = (TextView) view.findViewById(R.id.title_layout_province);
        goProvince= (RelativeLayout) view.findViewById(R.id.city_title_layout);
        goProvince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.getProvinces();
            }
        });
        sortListView= (ListView) view.findViewById(R.id.cityList);
        sortListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mainActivity, SourceDateList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initDate(){
        title.setText(province);
        SourceDateList=filledData(getResources().getStringArray(R.array.hotP));
        adapter = new CityMenberAdapter(SourceDateList,mainActivity);
        sortListView.setAdapter(adapter);
    }
    private List<GroupMemberBean> filledData(String[] date) {
        List<GroupMemberBean> mSortList = new ArrayList<GroupMemberBean>();
        for (int i = 0; i < date.length; i++) {
            GroupMemberBean sortModel = new GroupMemberBean();
            sortModel.setName(date[i]);
            mSortList.add(sortModel);
        }
        return mSortList;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
