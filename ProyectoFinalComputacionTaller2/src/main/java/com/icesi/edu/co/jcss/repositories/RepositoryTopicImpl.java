package com.icesi.edu.co.jcss.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.icesi.edu.co.jcss.model.TsscTopic;

import lombok.Getter;

@Repository
@Getter
public class RepositoryTopicImpl implements IRepositoryTopic {

	Map<Integer, TsscTopic> database;

	public RepositoryTopicImpl() {
		// TODO Auto-generated constructor stub
		database = new HashMap<Integer, TsscTopic>();
	}

	@Override
	public void create(TsscTopic topic, Integer id) {
		// TODO Auto-generated method stub
		if (!database.containsKey(id)) {
			database.put(id, topic);
		}
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public TsscTopic search(Integer id) {
		// TODO Auto-generated method stub
		TsscTopic topic = null;
		if (database.containsKey(id)) {
			topic = database.get(id);
		} 

		return topic;
	}

	@Override
	public void update(TsscTopic topic, Integer id) {
		// TODO Auto-generated method stub

	}

}