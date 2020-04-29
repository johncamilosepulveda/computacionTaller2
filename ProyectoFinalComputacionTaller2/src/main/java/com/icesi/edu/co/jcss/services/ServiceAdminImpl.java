package com.icesi.edu.co.jcss.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.icesi.edu.co.jcss.model.TsscAdmin;
import com.icesi.edu.co.jcss.repositories.RepositoryAdminImpl;


public class ServiceAdminImpl implements IServiceAdmin{

	private RepositoryAdminImpl adminRepository;

	@Autowired
	public ServiceAdminImpl(RepositoryAdminImpl adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	
	@Override
	public void create(TsscAdmin admin, Integer id) {
		adminRepository.create(admin, id);
	}

	@Override
	public TsscAdmin update(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(TsscAdmin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<TsscAdmin> getAllGames() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void signup(TsscAdmin admin) {
		
	}

}
