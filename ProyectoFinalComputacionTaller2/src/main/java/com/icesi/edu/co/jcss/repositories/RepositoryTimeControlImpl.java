package com.icesi.edu.co.jcss.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.icesi.edu.co.jcss.model.TsscTimecontrol;

import lombok.Getter;

@Repository
@Getter
public class RepositoryTimeControlImpl implements IRepositoryTimeControl {
	
	Map<Integer, TsscTimecontrol> database;

	public RepositoryTimeControlImpl() {
		// TODO Auto-generated constructor stub
		database = new HashMap<Integer, TsscTimecontrol>();
	}

	
	public void create(TsscTimecontrol timecontrol, Integer id) {
		// TODO Auto-generated method stub
		if (!database.containsKey(id)) {
			database.put(id, timecontrol);
		}
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	public TsscTimecontrol search(Integer id) {
		// TODO Auto-generated method stub
		TsscTimecontrol timecontrol = null;
		if (database.containsKey(id)) {
			timecontrol = database.get(id);
		} 

		return timecontrol;
	}


	public void update(TsscTimecontrol timecontrol, Integer id) {
		// TODO Auto-generated method stub

	}

}
