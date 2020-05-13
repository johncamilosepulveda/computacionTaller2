package com.icesi.edu.co.jcss.dao;

import java.time.LocalDate;
import java.util.List;

import com.icesi.edu.co.jcss.model.TsscTopic;


public interface ITopicDao {
	
	public void save(TsscTopic entity);
	public void update(TsscTopic entity);
	public void delete(TsscTopic entity);
	public TsscTopic findById(Integer codigo);
	public List<TsscTopic> findAll();
	public TsscTopic findByName(String name);
	public TsscTopic findByDescription(String description);
	public List<TsscTopic> query1(LocalDate date); 

}
