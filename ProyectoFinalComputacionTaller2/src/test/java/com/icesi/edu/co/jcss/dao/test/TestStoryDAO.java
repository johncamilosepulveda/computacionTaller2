package com.icesi.edu.co.jcss.dao.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.icesi.edu.co.jcss.dao.IStoryDao;
import com.icesi.edu.co.jcss.model.TsscStory;

public class TestStoryDAO {
	
	@Autowired
	private IStoryDao StoryDao;
	
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void aTest() {

		assertNotNull(StoryDao);
		
		TsscStory Story = new TsscStory();
		Story.setAltDescripton("aaaa");
		Story.setAltDescShown("bbbb");
		
		StoryDao.save(Story);
		
	}
	
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void bTest() {

		assertNotNull(StoryDao);
		
		TsscStory Story = StoryDao.findById(2);
		assertNotNull("Code not found", Story);
		Story.setAltDescripton("aaaa");
		StoryDao.update(Story);
		
	}
	
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void cTest() {

		assertNotNull(StoryDao);
		
		TsscStory Story = StoryDao.findById(2);
		assertNotNull("Code not found", Story);
		StoryDao.delete(Story);
		
	}

}
