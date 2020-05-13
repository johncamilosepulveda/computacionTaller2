package com.icesi.edu.co.jcss.dao.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.icesi.edu.co.jcss.dao.IGameDao;
import com.icesi.edu.co.jcss.dao.ITopicDao;
import com.icesi.edu.co.jcss.model.TsscGame;
import com.icesi.edu.co.jcss.model.TsscTopic;

public class TestTopicDAO {

	@Autowired
	private ITopicDao TopicDao;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void aTest() {

		assertNotNull(TopicDao);

		TsscTopic Topic = new TsscTopic();
		Topic.setName("Scrum <20 MGP - Corto");
		Topic.setDescription("Scrum menos de 20 personas MGP");
		Topic.setDefaultGroups(4);
		Topic.setDefaultSprints(3);

		TopicDao.save(Topic);

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void bTest() {

		assertNotNull(TopicDao);

		TsscTopic Topic = TopicDao.findById(2);
		assertNotNull("Code not found", Topic);
		Topic.setName("202-mgp");
		TopicDao.update(Topic);

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void cTest() {

		assertNotNull(TopicDao);

		TsscTopic Topic = TopicDao.findById(2);
		assertNotNull("Code not found", Topic);
		TopicDao.delete(Topic);

	}

}
