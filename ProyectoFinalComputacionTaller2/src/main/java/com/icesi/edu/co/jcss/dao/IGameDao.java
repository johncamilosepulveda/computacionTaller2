package com.icesi.edu.co.jcss.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.icesi.edu.co.jcss.model.TsscGame;

public interface IGameDao {

	public void save(TsscGame entity);

	public void update(TsscGame entity);

	public void delete(TsscGame entity);

	public TsscGame findById(long id);

	public List<TsscGame> findAll();
	
	public List<TsscGame> findByDates(LocalDate ini, LocalDate fin);
	
	public List<TsscGame> findByDateTime(LocalDate date, LocalTime ini, LocalTime fin);
	
	public List<TsscGame> query2(LocalDate date);
	
	public List<TsscGame> findByName(String name);
	
	public List<TsscGame> findByDescription(String description);
	
	public List<TsscGame> findByIdTopic(long id);
}
