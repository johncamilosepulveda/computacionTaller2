package com.icesi.edu.co.jcss.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icesi.edu.co.jcss.exceptions.ExceptionNotCreateStory;
import com.icesi.edu.co.jcss.model.TsscStory;
import com.icesi.edu.co.jcss.repositories.IRepositoryGame;
import com.icesi.edu.co.jcss.repositories.IRepositoryStory;

@Service
public class ServiceStoryImpl implements IServiceStory {

	@Autowired
	private IRepositoryGame iRepositoryGame;
	@Autowired
	private IRepositoryStory iRepositoryStory;

	@Override
	public void saveStory(TsscStory story, Integer id, Integer idGame) throws ExceptionNotCreateStory {
		
		if(story != null) {
			if(story.getPriority().signum() > 0  && story.getInitialSprint().signum() > 0 && story.getBusinessValue().signum() > 0) {
				if(receiveGame(idGame)) {
					iRepositoryStory.create(story, id);
				}else {
					throw new ExceptionNotCreateStory("El juego asociado no existe");
				}
			}else {
				throw new ExceptionNotCreateStory("La prioridad, el sprint inicial y el valor del negocio deben ser mayor a cero");
			}
		}else {
			throw new ExceptionNotCreateStory("La historia es null");
		}
		
	}

	@Override
	public void editStory(TsscStory story, Integer id, Integer idGame) throws ExceptionNotCreateStory {
		
		if(story != null) {
			if(story.getPriority().signum() > 0  && story.getInitialSprint().signum() > 0 && story.getBusinessValue().signum() > 0) {
				if(receiveGame(idGame)) {
					iRepositoryStory.update(story, id);
				}
			}
		}
		
	}

	@Override
	public boolean receiveGame(Integer idGame) {
		boolean receive = false;

		if (idGame != -1) {
			if (iRepositoryGame.search(idGame) != null) {
				receive = true;
			}
		}

		return receive;

	}

}
