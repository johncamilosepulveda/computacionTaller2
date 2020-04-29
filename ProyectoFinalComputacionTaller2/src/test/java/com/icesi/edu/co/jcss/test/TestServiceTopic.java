package com.icesi.edu.co.jcss.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.icesi.edu.co.jcss.exceptions.ExceptionNotCreateTopic;
import com.icesi.edu.co.jcss.model.TsscTopic;
import com.icesi.edu.co.jcss.repositories.IRepositoryTopic;
import com.icesi.edu.co.jcss.services.ServiceTopicImpl;

@SpringBootTest
public class TestServiceTopic {

	@InjectMocks
	private ServiceTopicImpl serviceTopic;
	
	@Mock
	private IRepositoryTopic repositoryTopic;
	
	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void createTopicA() throws ExceptionNotCreateTopic {
		TsscTopic topic = new TsscTopic();
		topic.setId(1);
		topic.setDefaultSprints(2);
		topic.setDefaultGroups(12);
		
		when(repositoryTopic.search((int) topic.getId())).thenReturn(topic);
		
		serviceTopic.saveTopic(topic, (int) topic.getId());
		TsscTopic topic2 = repositoryTopic.search((int) topic.getId());
		Assert.assertEquals(topic, topic2);
		
		verify(repositoryTopic,times(1)).search((int) topic.getId());

	}
	
	@Test(expectedExceptions = ExceptionNotCreateTopic.class)
	public void createTopicB() throws ExceptionNotCreateTopic {
		TsscTopic topic = new TsscTopic();
		topic.setId(4);
		topic.setDefaultSprints(0);
		topic.setDefaultGroups(0);
		
		when(repositoryTopic.search((int) topic.getId())).thenReturn(topic);
		
		serviceTopic.saveTopic(topic, (int) topic.getId());
		TsscTopic topic2 = repositoryTopic.search((int) topic.getId());
		Assert.assertEquals(topic, topic2);
		

	}
	
	@Test(expectedExceptions = ExceptionNotCreateTopic.class)
	public void createTopicC() throws ExceptionNotCreateTopic {
		TsscTopic topic = new TsscTopic();
		topic.setId(5);
		topic.setDefaultSprints(-2);
		topic.setDefaultGroups(-8);
		
		when(repositoryTopic.search((int) topic.getId())).thenReturn(topic);
		
		serviceTopic.saveTopic(topic, (int) topic.getId());
		TsscTopic topic2 = repositoryTopic.search((int) topic.getId());
		Assert.assertEquals(topic, topic2);
		


	}
	
	@Test(expectedExceptions = ExceptionNotCreateTopic.class)
	public void createTopicD() throws ExceptionNotCreateTopic {
		TsscTopic topic = null;
		when(repositoryTopic.search(100)).thenReturn(topic);
		serviceTopic.saveTopic(topic, 100);
		TsscTopic topic2 = repositoryTopic.search(100);
		Assert.assertEquals(topic, topic2);
		

	}
	
	
}
