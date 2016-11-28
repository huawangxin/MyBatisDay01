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
		//1 ����SqlSession����
		//2 ִ�в������
		String cfg="SqlMapConfig.xml";
		//MyBatis�ṩ�˹��߷��������ڴ������ļ���
		Reader reader=Resources.getResourceAsReader(cfg);
		//���������Ĺ�������
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		//����SqlSession�Ĺ���
		SqlSessionFactory factory=builder.build(reader);
		//����SqlSession����(���ݿ��Ѿ���)
		SqlSession session=factory.openSession();
		System.out.println(session);
		System.out.println(session.getConnection());
		//MyBis�Զ�����Mapping�ӿڵ�ʵ��
		DeptMapper mapper=session.getMapper(DeptMapper.class);
		Dept dept=new Dept("��ѧ��","����");
		mapper.add(dept);
		System.out.println(dept);
		//����һ��ִ��SQL�ķ���
		Dept dept2=new Dept("��������","���˴�");
		//ִ�������ļ��� idΪadd�Ĳ�������
		session.insert("add",dept2);
		session.commit();
		session.close();//�Ͽ����ݿ����ӻ��߹黹����
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
		dept.setLoc("����");
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
		//������SqlSessionִ��CRUD
		//1 ���ҵ�һ������
		//2, �޸Ķ��������
		//3 ��ѯ���ж��󣬹۲��޸Ľ��
		Dept dept=session.selectOne("findById",27);
		dept.setLoc("����");
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
		session.insert("add",new Dept("PHP","����"));
		session.insert("add",new Dept(".net","����"));
		session.insert("add",new Dept("IOS","����"));
		session.insert("add",new Dept("��׿","����"));
		session.insert("add",new Dept("C","����"));
		session.insert("add",new Dept("Java","����"));
		session.insert("add",new Dept("����","����"));
		session.insert("add",new Dept("����","����"));
		session.insert("add",new Dept("Ӫ��","����"));
		session.insert("add",new Dept("����","����"));
		session.insert("add",new Dept("Big Data","����"));
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
		//���ط�ҳ�Ĳ�ѯ���
		//��ÿҳ5�����ݣ�һ��16������
		//��һҳ0-4  5-9  10-14 15 �ӵ�5����ʼ�������ȡ5��
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
		List<Map> map = mapper.findDeptInfo("����");
		for (Map row : map) {
			System.out.println(row);
		}
		session.close();
	}
}
