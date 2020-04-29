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

import com.icesi.edu.co.jcss.exceptions.ExceptionNotCreateGame;
import com.icesi.edu.co.jcss.model.TsscGame;
import com.icesi.edu.co.jcss.model.TsscTopic;
import com.icesi.edu.co.jcss.repositories.IRepositoryGame;
import com.icesi.edu.co.jcss.repositories.IRepositoryTopic;
import com.icesi.edu.co.jcss.services.ServiceGameImpl;

@SpringBootTest
public class TestServiceGame {

	@InjectMocks
	private ServiceGameImpl serviceGame;
	
	@Mock
	private IRepositoryGame repositoryGame;
	
	@Mock
	private IRepositoryTopic repositoryTopic;
	
	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void createGameA() throws ExceptionNotCreateGame {
		TsscGame game = new TsscGame();
		game.setId(1);
		game.setNGroups(10);
		game.setNSprints(20);
		
		
		when(repositoryGame.search((int) game.getId())).thenReturn(game);
		
		serviceGame.saveGame(game, (int) game.getId(), -1, repositoryTopic);
		TsscGame game2 = repositoryGame.search((int) game.getId());
		Assert.assertEquals(game, game2);
		
		verify(repositoryGame,times(1)).search((int) game.getId());

	}
	
	@Test
	public void createGameB() throws ExceptionNotCreateGame {
		
		TsscGame game = new TsscGame();
		game.setId(1);
		game.setNGroups(10);
		game.setNSprints(20);
		
		TsscTopic topic = new TsscTopic();
		topic.setId(2);
		
		when(repositoryGame.search((int) game.getId())).thenReturn(game);
		when(repositoryTopic.search((int)topic.getId())).thenReturn(topic);
		
		serviceGame.saveGame(game, (int) game.getId(), (int)topic.getId(), repositoryTopic);
		TsscGame game2 = repositoryGame.search((int) game.getId());
		Assert.assertEquals(game, game2);
		
		verify(repositoryGame,times(1)).search((int) game.getId());
		

	}
	
	
	@Test(expectedExceptions = ExceptionNotCreateGame.class)
	public void createGameC() throws ExceptionNotCreateGame {
		TsscGame game = null;
		when(repositoryGame.search(100)).thenReturn(game);
		serviceGame.saveGame(game, 100, 2, null);
		TsscGame game2 = repositoryGame.search(100);
		Assert.assertEquals(game, game2);
		

	}
	
}
