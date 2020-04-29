package com.icesi.edu.co.jcss.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.icesi.edu.co.jcss.model.TsscStory;

import lombok.Getter;

@Repository
@Getter
public class RepositoryStoryImpl implements IRepositoryStory {

	Map<Integer, TsscStory> database;

	public RepositoryStoryImpl() {
		// TODO Auto-generated constructor stub
		database = new HashMap<Integer, TsscStory>();
	}

	@Override
	public void create(TsscStory story, Integer id) {
		// TODO Auto-generated method stub
		if (!database.containsKey(id)) {
			database.put(id, story);
		}
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public TsscStory search(Integer id) {
		// TODO Auto-generated method stub
		TsscStory story = null;
		if (database.containsKey(id)) {
			story = database.get(id);
		} 

		return story;
	}

	@Override
	public void update(TsscStory topic, Integer id) {
		// TODO Auto-generated method stub

	}

}