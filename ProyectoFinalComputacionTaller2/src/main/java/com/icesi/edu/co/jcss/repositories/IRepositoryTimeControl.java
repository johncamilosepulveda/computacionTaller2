package com.icesi.edu.co.jcss.repositories;

import com.icesi.edu.co.jcss.model.TsscTimecontrol;

public interface IRepositoryTimeControl {
	
	public void create(TsscTimecontrol timecontrol, Integer id);

	public void delete(Integer id);

	public TsscTimecontrol search(Integer id);

	public void update(TsscTimecontrol timecontrol, Integer id);

}
