package com.icesi.edu.co.jcss.services;

import com.icesi.edu.co.jcss.exceptions.ExceptionNotCreateTopic;
import com.icesi.edu.co.jcss.model.TsscTopic;

public interface IServiceTopic {

	public void saveTopic(TsscTopic topic, Integer id) throws ExceptionNotCreateTopic;
	public void editTopic(TsscTopic topic, Integer id) throws ExceptionNotCreateTopic;
	
}
