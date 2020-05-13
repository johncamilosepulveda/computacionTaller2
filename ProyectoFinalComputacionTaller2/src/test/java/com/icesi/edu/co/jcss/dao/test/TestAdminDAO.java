package com.icesi.edu.co.jcss.dao.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.icesi.edu.co.jcss.dao.IAdminDao;
import com.icesi.edu.co.jcss.model.TsscAdmin;

public class TestAdminDAO {
	
	@Autowired
	private IAdminDao AdminDao;
	
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void aTest() {

		assertNotNull(AdminDao);
		
		TsscAdmin Admin = new TsscAdmin();
		Admin.setSuperAdmin("JCSS");
		Admin.setPassword("cammmm98");
		
		AdminDao.save(Admin);
		
	}
	
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void bTest() {

		assertNotNull(AdminDao);
		
		TsscAdmin Admin = AdminDao.findById(2);
		assertNotNull("Code not found", Admin);
		Admin.setSuperAdmin("JCSS");
		AdminDao.update(Admin);
		
	}
	
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void cTest() {

		assertNotNull(AdminDao);
		
		TsscAdmin Admin = AdminDao.findById(2);
		assertNotNull("Code not found", Admin);
		AdminDao.delete(Admin);
		
	}

}
