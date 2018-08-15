package com.offcn.dao;

import java.util.List;

import com.offcn.po.NewStudent;

public interface stuDao {

	/**
	 *返回全部学生信息
	 */
	public List<NewStudent> getAll();
	
	//保存
	public void save(NewStudent stu);
}
