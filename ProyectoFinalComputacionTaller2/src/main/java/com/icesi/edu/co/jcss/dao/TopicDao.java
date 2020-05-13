package com.icesi.edu.co.jcss.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.icesi.edu.co.jcss.model.TsscTopic;

@Repository
@Scope("singleton")
public class TopicDao implements ITopicDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(TsscTopic entity) {
		entityManager.persist(entity);

	}

	@Override
	public void update(TsscTopic entity) {
		entityManager.merge(entity);

	}

	@Override
	public void delete(TsscTopic entity) {
		entityManager.remove(entity);
	}

	@Override
	public TsscTopic findById(Integer codigo) {
		return entityManager.find(TsscTopic.class, codigo);
	}

	@Override
	public List<TsscTopic> findAll() {
		String jpql = "Select a from TsscTopic a";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public TsscTopic findByName(String name) {
		return entityManager.find(TsscTopic.class, name);
	}

	@Override
	public TsscTopic findByDescription(String description) {
		return entityManager.find(TsscTopic.class, description);
	}

	@Override
	public List<TsscTopic> query1(LocalDate date) {
		String jpql = "Select a.id, a.name, a.defaultSprints, a.defaultGroups From TsscTopic a "
				+ "Where (Select b.scheduledDate From TsscGame b Order By b.scheduledTime ASC Where b Member of a.tsscGames)="
				+ date;
		return entityManager.createQuery(jpql).getResultList();
	}

}
