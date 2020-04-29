package com.icesi.edu.co.jcss.services;

import com.icesi.edu.co.jcss.exceptions.ExceptionNotCreateStory;
import com.icesi.edu.co.jcss.model.TsscStory;

public interface IServiceStory {
	
	public void saveStory(TsscStory story, Integer id, Integer idGame) throws ExceptionNotCreateStory;
	public void editStory(TsscStory story, Integer id, Integer idGame) throws ExceptionNotCreateStory;
	public boolean receiveGame(Integer idGame);

}
