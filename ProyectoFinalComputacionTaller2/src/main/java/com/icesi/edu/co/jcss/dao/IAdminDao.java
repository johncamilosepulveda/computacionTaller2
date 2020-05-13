package com.icesi.edu.co.jcss.dao;

import java.util.List;

import com.icesi.edu.co.jcss.model.TsscAdmin;


public interface IAdminDao {
	
	public void save(TsscAdmin entity);
	public void update(TsscAdmin entity);
	public void delete(TsscAdmin entity);
	public TsscAdmin findById(Integer codigo);
	public List<TsscAdmin> findAll();

}
