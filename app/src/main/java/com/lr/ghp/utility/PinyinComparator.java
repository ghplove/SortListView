package com.lr.ghp.utility;

import com.lr.ghp.model.GroupMemberBean;

import java.util.Comparator;


public class PinyinComparator implements Comparator<GroupMemberBean> {

	public int compare(GroupMemberBean o1, GroupMemberBean o2) {
		if (o1.getSortLetters().equals("＃")
				|| o2.getSortLetters().equals("热门")) {
			return 1;
		} else if (o1.getSortLetters().equals("热门")
				|| o2.getSortLetters().equals("＃")) {
			return -1;
		} else {
			return o1.getSortLetters().compareTo(o2.getSortLetters());
		}
	}

}
