package com.icesi.edu.co.jcss.repositories;

import org.springframework.data.repository.CrudRepository;

import com.icesi.edu.co.jcss.model.TsscGame;


public interface IRepositoryGame extends CrudRepository<TsscGame, Integer>{
	
	public void create(TsscGame game, Integer id);

	public void delete(Integer id);

	public TsscGame search(Integer id);

	public void update(TsscGame game, Integer id);

}
