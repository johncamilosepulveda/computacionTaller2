package com.icesi.edu.co.jcss.repositories;

import com.icesi.edu.co.jcss.model.TsscStory;

public interface IRepositoryStory {

	public void create(TsscStory story, Integer id);

	public void delete(Integer id);

	public TsscStory search(Integer id);

	public void update(TsscStory story, Integer id);

}
