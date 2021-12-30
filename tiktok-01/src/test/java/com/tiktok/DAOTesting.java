package com.tiktok;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tiktok.dao.TiktokDAO;
import com.tiktok.dao.TiktokDAOInterface;
import com.tiktok.entity.TiktokUser;

public class DAOTesting {
	
	private TiktokDAOInterface ld;

	@Before
	public void setUp() throws Exception {
		ld=new TiktokDAO();
	}

	@After
	public void tearDown() throws Exception {
		ld=null;
	}

	@Test
	public void testCreateProfileDAO() {
		TiktokUser lu=new TiktokUser();
		lu.setName("Mohan");
		lu.setPassword("sss");
		lu.setEmail("s");
		lu.setAddress("Chennai");
		int i=ld.createProfileDAO(lu);
		
		assert i>0:"profile creation failed";
	}

	@Test
	public void testViewProfileDAO() {
		TiktokUser lu=new TiktokUser();
		
		lu.setEmail("s");
		
		TiktokUser i=ld.viewProfileDAO(lu);
		
		assert i!=null:"profile not found";
	}

}
