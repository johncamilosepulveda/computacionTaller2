package com.icesi.edu.co.jcss.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icesi.edu.co.jcss.exceptions.ExceptionNotCreateGame;
import com.icesi.edu.co.jcss.model.TsscGame;
import com.icesi.edu.co.jcss.model.TsscTopic;
import com.icesi.edu.co.jcss.repositories.IRepositoryGame;
import com.icesi.edu.co.jcss.repositories.IRepositoryTopic;

@Service
public class ServiceGameImpl implements IServiceGame {

	@Autowired
	private IRepositoryGame iRepositoryGame;

	@Override
	public void saveGame(TsscGame game, Integer id, Integer idTopic, IRepositoryTopic iRepositoryTopic) throws ExceptionNotCreateGame {

		if (game != null) {
			if (game.getNSprints() > 0 && game.getNGroups() > 0) {
				if (receiveTopic(idTopic, iRepositoryTopic)) {
					iRepositoryGame.create(game, id);
				} else {
					throw new ExceptionNotCreateGame("Recibe tema pero este no existe");
				}
			} else {
				throw new ExceptionNotCreateGame("la cantidad de sprint y grupos debe ser mayor a cero.");
			}
		} else {
			throw new ExceptionNotCreateGame("El juego es null.");
		}
	}

	@Override
	public void editGame(TsscGame game, Integer id, Integer idTopic, IRepositoryTopic iRepositoryTopic) throws ExceptionNotCreateGame {

		if (game != null) {
			if (game.getNSprints() > 0 && game.getNGroups() > 0) {
				if (receiveTopic(idTopic, iRepositoryTopic)) {
					iRepositoryGame.update(game, id);
				} else {
					throw new ExceptionNotCreateGame("Recibe tema pero este no existe");
				}
			} else {
				throw new ExceptionNotCreateGame("la cantidad de sprint y grupos debe ser mayor a cero.");
			}
		} else {
			throw new ExceptionNotCreateGame("El juego es null.");
		}
	}

	@Override
	public boolean receiveTopic(Integer idTopic, IRepositoryTopic iRepositoryTopic) {

		boolean receive = false;

		if (idTopic != -1) {
			if (iRepositoryTopic.search(idTopic) != null) {
				receive = true;
			}
		}

		return receive;
	}

}
