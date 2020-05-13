package com.icesi.edu.co.jcss.dao.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.icesi.edu.co.jcss.dao.IGameDao;
import com.icesi.edu.co.jcss.model.TsscGame;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestGameDAO {
	
	@Autowired
	private IGameDao gameDao;
	
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void aTest() {

		assertNotNull(gameDao);
		
		TsscGame game = new TsscGame();
		game.setName("Completa PI2 20-1");
		game.setNGroups(4);
		game.setNSprints(4);
		
		gameDao.save(game);
		
	}
	
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void bTest() {

		assertNotNull(gameDao);
		
		TsscGame game = gameDao.findById(2);
		assertNotNull("Code not found", game);
		game.setName("202-mgp");
		gameDao.update(game);
		
	}
	
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void cTest() {

		assertNotNull(gameDao);
		
		TsscGame game = gameDao.findById(2);
		assertNotNull("Code not found", game);
		gameDao.delete(game);
		
	}

}
