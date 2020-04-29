package com.icesi.edu.co.jcss.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icesi.edu.co.jcss.exceptions.ExceptionNotCreateTopic;
import com.icesi.edu.co.jcss.model.TsscTopic;
import com.icesi.edu.co.jcss.repositories.IRepositoryTopic;

@Service
public class ServiceTopicImpl implements IServiceTopic{
	
	@Autowired
	private IRepositoryTopic iRepositoryTopic;

	@Override
	public void saveTopic(TsscTopic topic, Integer id) throws ExceptionNotCreateTopic {
		
		if(topic != null) {
			if(topic.getDefaultSprints() > 0 && topic.getDefaultGroups() > 0) {
				iRepositoryTopic.create(topic, id);
			}else {
				throw new ExceptionNotCreateTopic("la cantidad de sprint y grupos debe ser mayor a cero.");
			}
		}else {
			throw new ExceptionNotCreateTopic("El Tema es null.");
		}
		
	}

	@Override
	public void editTopic(TsscTopic topic, Integer id) throws ExceptionNotCreateTopic {
		
		if(topic != null) {
			if(topic.getDefaultSprints() > 0 && topic.getDefaultGroups() > 0) {
				iRepositoryTopic.update(topic, id);
			}else {
				throw new ExceptionNotCreateTopic("la cantidad de sprint y grupos debe ser mayor a cero.");
			}
		}else {
			throw new ExceptionNotCreateTopic("El Tema es null.");
		}
		
	}

}
