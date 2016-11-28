package com.huawangxin.entity;

import java.util.List;
import java.util.Map;

/** 实体对象的CRUD操作 */
public interface DeptMapper {

	void add(Dept dept);
	
	void delete(Dept dept);
	
//	void delete(Integer deptno);
	
	void update(Dept dept);
	
	Dept findById(Integer deptno);
	
	List<Dept> findAll();
	
//	List<Dept> findByLoc(String loc);
	//根据地点查询部门信息,结果中不包含deptno
	List<Map> findDeptInfo(String loc);
}
