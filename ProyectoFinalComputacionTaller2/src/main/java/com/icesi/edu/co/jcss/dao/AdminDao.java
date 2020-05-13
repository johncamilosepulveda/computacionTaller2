package com.icesi.edu.co.jcss.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.icesi.edu.co.jcss.model.TsscAdmin;


@Repository
@Scope("singleton")
public class AdminDao implements IAdminDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(TsscAdmin entity) {
		entityManager.persist(entity);

	}

	@Override
	public void update(TsscAdmin entity) {
		entityManager.merge(entity);

	}

	@Override
	public void delete(TsscAdmin entity) {
		entityManager.remove(entity);
	}

	@Override
	public TsscAdmin findById(Integer codigo) {
		return entityManager.find(TsscAdmin.class, codigo);
	}

	@Override
	public List<TsscAdmin> findAll() {
		String jpql = "Select a from TsscAdmin a";
		return 	entityManager.createQuery(jpql).getResultList();
	}

}
