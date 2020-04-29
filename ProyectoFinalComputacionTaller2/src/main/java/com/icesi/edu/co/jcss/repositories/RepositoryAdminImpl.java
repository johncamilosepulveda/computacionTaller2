package com.icesi.edu.co.jcss.repositories;

import java.util.HashMap;
import java.util.Map;

import com.icesi.edu.co.jcss.model.TsscAdmin;


public class RepositoryAdminImpl implements IRepositoryAdmin{

	Map<Integer, TsscAdmin> database;

	public RepositoryAdminImpl() {
		// TODO Auto-generated constructor stub
		database = new HashMap<Integer, TsscAdmin>();
	}
	
	
	@Override
	public void create(TsscAdmin admin, Integer id) {
		// TODO Auto-generated method stub
		if (!database.containsKey(id)) {
			database.put(id, admin);
		}
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TsscAdmin search(Integer id) {
		// TODO Auto-generated method stub
		TsscAdmin admin = null;
		if (database.containsKey(id)) {
			admin = database.get(id);
		} 

		return admin;
	}

	@Override
	public void update(TsscAdmin topic, Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
