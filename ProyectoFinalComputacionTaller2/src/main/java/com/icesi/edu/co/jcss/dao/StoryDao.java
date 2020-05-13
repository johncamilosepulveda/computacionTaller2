package com.icesi.edu.co.jcss.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.icesi.edu.co.jcss.model.TsscStory;

@Repository
@Scope("singleton")
public class StoryDao implements IStoryDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(TsscStory entity) {
		entityManager.persist(entity);

	}

	@Override
	public void update(TsscStory entity) {
		entityManager.merge(entity);

	}

	@Override
	public void delete(TsscStory entity) {
		entityManager.remove(entity);
	}

	@Override
	public TsscStory findById(Integer codigo) {
		return entityManager.find(TsscStory.class, codigo);
	}

	@Override
	public List<TsscStory> findAll() {
		String jpql = "Select a from TsscStory a";
		return entityManager.createQuery(jpql).getResultList();
	}

}
