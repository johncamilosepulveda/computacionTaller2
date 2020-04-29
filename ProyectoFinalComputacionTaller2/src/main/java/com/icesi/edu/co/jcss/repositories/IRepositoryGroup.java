package com.icesi.edu.co.jcss.repositories;

import com.icesi.edu.co.jcss.model.TsscGroup;

public interface IRepositoryGroup {
	
	public void create(TsscGroup group, Integer id);

	public void delete(Integer id);

	public TsscGroup search(Integer id);

	public void update(TsscGroup group, Integer id);

}
