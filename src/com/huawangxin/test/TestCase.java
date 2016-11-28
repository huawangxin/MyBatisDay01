package com.huawangxin.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.huawangxin.entity.Dept;
import com.huawangxin.entity.DeptMapper;

public class TestCase {
//	@Test
	public void testAdd() throws Exception{
		//1 创建SqlSession对象
		//2 执行插入操作
		String cfg="SqlMapConfig.xml";
		//MyBatis提供了工具方法，用于打开配置文件流
		Reader reader=Resources.getResourceAsReader(cfg);
		//创建工厂的工厂对象
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		//创建SqlSession的工厂
		SqlSessionFactory factory=builder.build(reader);
		//创建SqlSession对象(数据库已经打开)
		SqlSession session=factory.openSession();
		System.out.println(session);
		System.out.println(session.getConnection());
		//MyBis自动创建Mapping接口的实例
		DeptMapper mapper=session.getMapper(DeptMapper.class);
		Dept dept=new Dept("教学部","北京");
		mapper.add(dept);
		System.out.println(dept);
		//另外一种执行SQL的方法
		Dept dept2=new Dept("测试中心","奥运村");
		//执行配置文件中 id为add的插入语言
		session.insert("add",dept2);
		session.commit();
		session.close();//断开数据库连接或者归还连接
	}
//	@Test
	public void testDelete() throws Exception{
		String cfg="SqlMapConfig.xml";
		Reader reader=Resources.getResourceAsReader(cfg);
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		SqlSessionFactory factory=builder.build(reader);
		SqlSession session=factory.openSession();
		DeptMapper mapper=session.getMapper(DeptMapper.class);
		Dept d=mapper.findById(27);
		System.out.println(d);
		session.commit();
		session.close();
	}
//	@Test
	public void testUpdate() throws Exception{
		String cfg="SqlMapConfig.xml";
		Reader reader=Resources.getResourceAsReader(cfg);
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		SqlSessionFactory factory=builder.build(reader);
		SqlSession session=factory.openSession();
		DeptMapper mapper=session.getMapper(DeptMapper.class);
		Dept dept=mapper.findById(27);
		System.out.println(dept);
		dept.setLoc("杭州");
		mapper.update(dept);
		System.out.println(dept);
		session.commit();
		session.close();
	}
//	@Test
	public void testFindAll() throws Exception{
		String cfg="SqlMapConfig.xml";
		Reader reader=Resources.getResourceAsReader(cfg);
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		SqlSessionFactory factory=builder.build(reader);
		SqlSession session=factory.openSession();
		DeptMapper mapper=session.getMapper(DeptMapper.class);
		List<Dept> all=mapper.findAll();
		System.out.println(all);
		session.close();
	}
//	@Test
	public void testFind() throws Exception{
		String cfg="SqlMapConfig.xml";
		Reader reader=Resources.getResourceAsReader(cfg);
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		SqlSessionFactory factory=builder.build(reader);
		SqlSession session=factory.openSession();
		//还是用SqlSession执行CRUD
		//1 查找到一个对象
		//2, 修改对象的属性
		//3 查询所有对象，观察修改结果
		Dept dept=session.selectOne("findById",27);
		dept.setLoc("北京");
		session.update("update",dept);
		List<Dept> all=session.selectList("findAll");
		System.out.println(all);
		session.commit();
		session.close();
	}
//	@Test
	public void testAddSomeRows() throws Exception{
		String cfg="SqlMapConfig.xml";
		Reader reader=Resources.getResourceAsReader(cfg);
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		SqlSessionFactory factory=builder.build(reader);
		SqlSession session=factory.openSession();
		session.insert("add",new Dept("PHP","北京"));
		session.insert("add",new Dept(".net","北京"));
		session.insert("add",new Dept("IOS","北京"));
		session.insert("add",new Dept("安卓","北京"));
		session.insert("add",new Dept("C","北京"));
		session.insert("add",new Dept("Java","北京"));
		session.insert("add",new Dept("测试","北京"));
		session.insert("add",new Dept("网络","北京"));
		session.insert("add",new Dept("营销","北京"));
		session.insert("add",new Dept("财务","北京"));
		session.insert("add",new Dept("Big Data","北京"));
		session.commit();
		session.close();
	}
//	@Test
	public void testFindAlls() throws Exception{
		String cfg="SqlMapConfig.xml";
		Reader reader=Resources.getResourceAsReader(cfg);
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		SqlSessionFactory factory=builder.build(reader);
		SqlSession session=factory.openSession();
		//返回分页的查询结果
		//如每页5条数据，一共16条数据
		//第一页0-4  5-9  10-14 15 从第5条开始连续最多取5条
		RowBounds bounds=new RowBounds(5,5);
		List<Dept> list=session.selectList("findAll",null,bounds);
//		System.out.println(list);
		for(Dept dept:list){
			System.out.println(dept);
		}
		session.close();
	}
	@Test
	public void testFindDeptInfo() throws Exception {
		String cfg = "SqlMapConfig.xml";
		Reader reader = 
			Resources.getResourceAsReader(cfg);
		SqlSessionFactoryBuilder builder = 
			new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = 
			builder.build(reader);
		SqlSession session = factory.openSession();
		DeptMapper mapper = session.getMapper(
				DeptMapper.class);
		List<Map> map = mapper.findDeptInfo("北京");
		for (Map row : map) {
			System.out.println(row);
		}
		session.close();
	}
}
