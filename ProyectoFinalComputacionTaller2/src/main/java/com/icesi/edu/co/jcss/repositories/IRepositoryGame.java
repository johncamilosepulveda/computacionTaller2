package com.icesi.edu.co.jcss.repositories;

import com.icesi.edu.co.jcss.model.TsscGame;

public interface IRepositoryGame {
	
	public void create(TsscGame game, Integer id);

	public void delete(Integer id);

	public TsscGame search(Integer id);

	public void update(TsscGame game, Integer id);

}
