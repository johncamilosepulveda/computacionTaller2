package com.icesi.edu.co.jcss.repositories;

import com.icesi.edu.co.jcss.model.TsscSprint;

public interface IRepositorySprint {

	public void create(TsscSprint sprint, Integer id);

	public void delete(Integer id);

	public TsscSprint search(Integer id);

	public void update(TsscSprint sprint, Integer id);
	
}
