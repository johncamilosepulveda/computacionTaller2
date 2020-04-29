package com.icesi.edu.co.jcss.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.icesi.edu.co.jcss.model.TsscGroup;

import lombok.Getter;

@Repository
@Getter
public class RepositoryGroupImpl implements IRepositoryGroup{


	Map<Integer, TsscGroup> database;

	public RepositoryGroupImpl() {
		// TODO Auto-generated constructor stub
		database = new HashMap<Integer, TsscGroup>();
	}

	
	public void create(TsscGroup group, Integer id) {
		// TODO Auto-generated method stub
		if (!database.containsKey(id)) {
			database.put(id, group);
		}
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	public TsscGroup search(Integer id) {
		// TODO Auto-generated method stub
		TsscGroup group = null;
		if (database.containsKey(id)) {
			group = database.get(id);
		} 

		return group;
	}


	public void update(TsscGroup group, Integer id) {
		// TODO Auto-generated method stub

	}
	
}
