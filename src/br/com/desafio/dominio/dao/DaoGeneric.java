package br.com.desafio.dominio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class DaoGeneric<T> {

	@PersistenceUnit(name = "CentroOperacoes")
	protected EntityManager entityManager;

	protected Class classPersistence;
	
	

	public DaoGeneric() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("centroOperacoes");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;

	}

	@SuppressWarnings("unchecked")
	public T getById(int id) {
		return (T) entityManager.find(classPersistence, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return entityManager.createQuery("FROM " + classPersistence.getName()).getResultList();
	}
	
	// faz a inserção no banco
	public void persist(T object) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(object);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	// atualiza o banco
	public void merge(T object) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(object);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}


}
