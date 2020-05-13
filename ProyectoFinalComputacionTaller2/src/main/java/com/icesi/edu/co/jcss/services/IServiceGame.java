package com.icesi.edu.co.jcss.services;

import java.util.Optional;

import com.icesi.edu.co.jcss.exceptions.ExceptionNotCreateGame;
import com.icesi.edu.co.jcss.model.TsscGame;
import com.icesi.edu.co.jcss.repositories.IRepositoryTopic;


public interface IServiceGame {

	public void saveGame(TsscGame game, Integer id, Integer idTopic, IRepositoryTopic iRepositoryTopic)
			throws ExceptionNotCreateGame;

	public void editGame(TsscGame game, Integer id, Integer idTopic, IRepositoryTopic iRepositoryTopic)
			throws ExceptionNotCreateGame;

	public boolean receiveTopic(Integer idTopic, IRepositoryTopic iRepositoryTopic);
	
	public void delete(TsscGame game);

	public Optional<TsscGame> findById(int id);

	public Iterable<TsscGame> findAll();

}
