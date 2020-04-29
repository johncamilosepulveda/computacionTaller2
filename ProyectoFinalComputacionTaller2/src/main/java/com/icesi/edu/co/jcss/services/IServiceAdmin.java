package com.icesi.edu.co.jcss.services;


import com.icesi.edu.co.jcss.model.TsscAdmin;


public interface IServiceAdmin {
	
	public void create(TsscAdmin admin, Integer id);
	public TsscAdmin update(Integer id);
	public void delete(TsscAdmin admin);
	public Iterable<TsscAdmin> getAllGames();
	
	public void signup(TsscAdmin admin);

}
