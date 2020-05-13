package com.icesi.edu.co.jcss.dao;

import java.util.List;

import com.icesi.edu.co.jcss.model.TsscStory;

public interface IStoryDao {

	public void save(TsscStory entity);

	public void update(TsscStory entity);

	public void delete(TsscStory entity);

	public TsscStory findById(Integer codigo);

	public List<TsscStory> findAll();

}
