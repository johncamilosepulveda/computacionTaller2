package com.icesi.edu.co.jcss.repositories;


import com.icesi.edu.co.jcss.model.TsscAdmin;

public interface IRepositoryAdmin {

	public void create(TsscAdmin admin, Integer id);

	public void delete(Integer id);

	public TsscAdmin search(Integer id);

	public void update(TsscAdmin topic, Integer id);

	
}
