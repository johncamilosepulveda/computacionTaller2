package com.icesi.edu.co.jcss.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.icesi.edu.co.jcss.model.TsscGame;

import lombok.Getter;

@Repository
@Getter
public class RepositoryGameImpl implements IRepositoryGame{
	
	Map<Integer, TsscGame> database;

	public RepositoryGameImpl() {
		// TODO Auto-generated constructor stub
		database = new HashMap<Integer, TsscGame>();
	}

	@Override
	public void create(TsscGame game, Integer id) {
		// TODO Auto-generated method stub
		if (!database.containsKey(id)) {
			database.put(id, game);
		}
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public TsscGame search(Integer id) {
		// TODO Auto-generated method stub
		TsscGame game = null;
		if (database.containsKey(id)) {
			game = database.get(id);
		} 

		return game;
	}

	@Override
	public void update(TsscGame game, Integer id) {
		// TODO Auto-generated method stub

	}

}
