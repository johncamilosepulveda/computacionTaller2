package com.icesi.edu.co.jcss.repositories;

import com.icesi.edu.co.jcss.model.TsscTopic;

public interface IRepositoryTopic {

	public void create(TsscTopic topic, Integer id);

	public void delete(Integer id);

	public TsscTopic search(Integer id);

	public void update(TsscTopic topic, Integer id);

}
