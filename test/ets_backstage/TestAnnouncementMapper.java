package ets_backstage;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.ets.mapper.AnnouncementMapper;
import com.ets.pojo.Announcement;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TestAnnouncementMapper {
	private SqlSessionFactory sessionFactory = null;
	@Before
	public void init() {
		// 1.读取核心配置问价
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("/ets_backstage/config/myBatis/myBatisConfig.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2.构建SqlSessionFactory
		sessionFactory = new SqlSessionFactoryBuilder().build(is);
	}
	
	@Test
	public void testSelectList(){
		SqlSession session = sessionFactory.openSession();
		AnnouncementMapper announcementMapper = session.getMapper(AnnouncementMapper.class);
		PageHelper.startPage(1,10);
		List<Announcement> selectList = announcementMapper.selectList();
		for (Announcement announcement : selectList) {
			System.out.println(announcement.getTitle() + "\t" + announcement.getAdmin().getAdUsername());
		}
		PageInfo<Announcement> pageInfo = new PageInfo<Announcement>(selectList);
		System.out.println("共有：" + pageInfo.getTotal());
	}
}
