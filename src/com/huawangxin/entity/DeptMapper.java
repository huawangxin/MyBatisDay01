package com.huawangxin.entity;

import java.util.List;
import java.util.Map;

/** ʵ������CRUD���� */
public interface DeptMapper {

	void add(Dept dept);
	
	void delete(Dept dept);
	
//	void delete(Integer deptno);
	
	void update(Dept dept);
	
	Dept findById(Integer deptno);
	
	List<Dept> findAll();
	
//	List<Dept> findByLoc(String loc);
	//���ݵص��ѯ������Ϣ,����в�����deptno
	List<Map> findDeptInfo(String loc);
}
