package com.icesi.edu.co.jcss.dao;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.icesi.edu.co.jcss.model.TsscGame;

@Repository
@Scope("singleton")
public class GameDao implements IGameDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(TsscGame entity) {
		entityManager.persist(entity);

	}

	@Override
	public void update(TsscGame entity) {
		entityManager.merge(entity);

	}

	@Override
	public void delete(TsscGame entity) {
		entityManager.remove(entity);
	}

	@Override
	public TsscGame findById(long id) {
		return entityManager.find(TsscGame.class, id);
	}

	@Override
	public List<TsscGame> findAll() {
		String jpql = "Select a from TsscGame a";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<TsscGame> findByDates(LocalDate ini, LocalDate fin) {

		String jpql = "Select a from TsscGame a" + "where a.scheduledDate >" + ini + "and" + "a.scheduledDate <" + fin;
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<TsscGame> findByDateTime(LocalDate date, LocalTime ini, LocalTime fin) {
		String jpql = "Select a from TsscGame a" + " where a.scheduledDate = " + date + " and " + " a.scheduledTime > "
				+ ini + " and " + " a.scheduledTime < " + fin;
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<TsscGame> query2(LocalDate date) {
		String jpql = "Select a.id, a.adminPassword, a.guestPassword, a.nGroups, a.nSprints, a.name From TsscGame a "
				+ "Where (a.scheduledDate = " + date
				+ " and (Select count(b) From TsscStory b Member of a.tsscStories)>=10) or (Select count(c) From TsscTimecontrol c Where c Member of a.tsscTimecontrols and)<=1)";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<TsscGame> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TsscGame> findByDescription(String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TsscGame> findByIdTopic(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
