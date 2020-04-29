package com.icesi.edu.co.jcss.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.icesi.edu.co.jcss.exceptions.ExceptionNotCreateStory;
import com.icesi.edu.co.jcss.model.TsscGame;
import com.icesi.edu.co.jcss.model.TsscStory;
import com.icesi.edu.co.jcss.repositories.IRepositoryGame;
import com.icesi.edu.co.jcss.repositories.IRepositoryStory;
import com.icesi.edu.co.jcss.services.ServiceStoryImpl;

@SpringBootTest
public class TestServiceStory {

	@InjectMocks
	private ServiceStoryImpl serviceStory;
	
	@Mock
	private IRepositoryStory repositoryStory;
	
	@Mock
	private IRepositoryGame repositoryGame;
	
	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void createStoryA() throws ExceptionNotCreateStory {
		TsscStory story = new TsscStory();
		story.setId(1);
		story.setPriority(new BigDecimal(100));
		story.setInitialSprint(new BigDecimal(200));
		story.setBusinessValue(new BigDecimal(300));
		
		TsscGame game = new TsscGame();
		game.setId(1);
		
		when(repositoryStory.search((int) story.getId())).thenReturn(story);
		when(repositoryGame.search((int) game.getId())).thenReturn(game);
		
		serviceStory.saveStory(story, (int)story.getId(), (int)game.getId());
		TsscStory story2 = repositoryStory.search((int) story.getId());
		Assert.assertEquals(story, story2);
		
		verify(repositoryStory,times(1)).search((int) story.getId());

	}
	
	@Test(expectedExceptions = ExceptionNotCreateStory.class)
	public void createStoryB() throws ExceptionNotCreateStory {
		TsscStory story = new TsscStory();
		story.setId(0);
		story.setPriority(new BigDecimal(0));
		story.setInitialSprint(new BigDecimal(0));
		story.setBusinessValue(new BigDecimal(0));
		
		TsscGame game = new TsscGame();
		game.setId(0);
		
		when(repositoryStory.search((int) story.getId())).thenReturn(story);
		when(repositoryGame.search((int) game.getId())).thenReturn(game);
		
		serviceStory.saveStory(story, (int) story.getId(), (int)game.getId());
		TsscStory story2 = repositoryStory.search((int) story.getId());
		Assert.assertEquals(story, story2);
		

	}
	
	@Test(expectedExceptions = ExceptionNotCreateStory.class)
	public void createStoryC() throws ExceptionNotCreateStory {
		TsscStory story = new TsscStory();
		story.setId(-2);
		story.setPriority(new BigDecimal(-100));
		story.setInitialSprint(new BigDecimal(-200));
		story.setBusinessValue(new BigDecimal(-300));
		
		TsscGame game = new TsscGame();
		game.setId(-2);
		
		when(repositoryStory.search((int) story.getId())).thenReturn(story);
		when(repositoryGame.search((int) game.getId())).thenReturn(game);

		serviceStory.saveStory(story, (int) story.getId(), (int) game.getId());
		TsscStory story2 = repositoryStory.search((int) story.getId());
		Assert.assertEquals(story, story2);
		


	}
	
	@Test(expectedExceptions = ExceptionNotCreateStory.class)
	public void createStoryD() throws ExceptionNotCreateStory {
		TsscStory story = null;
		when(repositoryStory.search(100)).thenReturn(story);
		serviceStory.saveStory(story, 100, 2);
		TsscStory story2 = repositoryStory.search(100);
		Assert.assertEquals(story, story2);
		

	}
	
	
}
