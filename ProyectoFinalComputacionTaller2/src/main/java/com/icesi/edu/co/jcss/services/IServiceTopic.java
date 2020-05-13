package com.icesi.edu.co.jcss.services;

import java.util.Optional;

import com.icesi.edu.co.jcss.exceptions.ExceptionNotCreateTopic;
import com.icesi.edu.co.jcss.model.TsscGame;
import com.icesi.edu.co.jcss.model.TsscTopic;

public interface IServiceTopic {

	public void saveTopic(TsscTopic topic, Integer id) throws ExceptionNotCreateTopic;
	public void editTopic(TsscTopic topic, Integer id) throws ExceptionNotCreateTopic;
	public void delete(TsscTopic topic);
	public Optional<TsscTopic> findById(int id);
	public Iterable<TsscTopic> findAll();
	
}
