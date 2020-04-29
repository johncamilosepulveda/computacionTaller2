package com.icesi.edu.co.jcss.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.icesi.edu.co.jcss.model.TsscSprint;

import lombok.Getter;

@Repository
@Getter
public class RepositorySprintImpl implements IRepositorySprint{
	
	Map<Integer, TsscSprint> database;

	public RepositorySprintImpl() {
		// TODO Auto-generated constructor stub
		database = new HashMap<Integer, TsscSprint>();
	}

	
	public void create(TsscSprint sprint, Integer id) {
		// TODO Auto-generated method stub
		if (!database.containsKey(id)) {
			database.put(id, sprint);
		}
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	public TsscSprint search(Integer id) {
		// TODO Auto-generated method stub
		TsscSprint sprint = null;
		if (database.containsKey(id)) {
			sprint = database.get(id);
		} 

		return sprint;
	}


	public void update(TsscSprint sprint, Integer id) {
		// TODO Auto-generated method stub

	}

}
