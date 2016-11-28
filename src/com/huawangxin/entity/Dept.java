package com.huawangxin.entity;

import java.io.Serializable;

/** 部门, 数据库中是部门表 
 * Department 实体类: 实体对象的类型
 *            实体对象: 有ID, 持久化存储的对象
 *            值对象: 无ID, 用于数据的封装和传输
 * */
public class Dept implements Serializable {
	/** 部门编号 */
	private Integer deptno;
	private String dname;
	/** location 部门位置, 工作地点 */
	private String loc; 
	
	public Dept() {
	}

	public Dept(String dname, String loc) {
		super();
		this.dname = dname;
		this.loc = loc;
	}

	public Dept(Integer deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptno == null) ? 0 : deptno.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dept other = (Dept) obj;
		if (deptno == null) {
			if (other.deptno != null)
				return false;
		} else if (!deptno.equals(other.deptno))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
}