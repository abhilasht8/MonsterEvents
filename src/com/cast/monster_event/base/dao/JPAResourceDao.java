package com.cast.monster_event.base.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class JPAResourceDao {

	protected EntityManagerFactory emf;
	protected EntityManager em;
	//protected final EntityManagerFactory emf;
	

	/**
	 * 
	 */
	public JPAResourceDao() {
		try {
			emf =
					Persistence
							.createEntityManagerFactory("PersistenceUnit_MONSTER");
			
			em = getEmf().createEntityManager();
			BasicConfigurator.configure();
			Logger.getLogger("org").setLevel(Level.WARN);
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return (EntityManagerFactory) emf;
	}

	public EntityManager getEntityManager() {
		return (EntityManager) getEmf().createEntityManager();
	}

	/**
	 * @return the emf
	 */
	protected EntityManagerFactory getEmf() {
		return emf;
	}

	/**
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	private void setEm(EntityManager in_em) {
		em = in_em;
	}

	public void beginTransaction() {
		getEm().getTransaction().begin();
	}

	public void commitTransaction() {
		getEm().getTransaction().commit();
	}

	public void cleanup() {
		if (getEm().isOpen())
			getEm().close();
	}

	public void flush() {
		getEm().flush();
	}
	
}
