package com.cast.monster_event.base.dao;

import java.util.Collection;

import com.cast.monster_event.base.model.Monster;
import com.cast.monster_event.base.model.MonsterEvent;
import com.cast.monster_event.base.model.SpookyPlace;

/**
 * @author BGA
 * @created 30 juin 2010
 * Description : 
 * 
 */
//public class MonsterDao extends JPAResourceDao {
public class SpookyPlaceDao extends JPAResourceDao {

	public SpookyPlaceDao() {
		super();
	}	
	
	//Finds a SpookyPlace by its Id
	public SpookyPlace findById(long in_id) {
		return (SpookyPlace) getEm().createQuery("From SpookyPlace where placeId=?1").setParameter(1, in_id).getSingleResult();
	}
	
	//Finds a SpookyPlace by its name
	public SpookyPlace findByName(String in_name) {
		return (SpookyPlace) getEm().createQuery("From SpookyPlace where name=?1").setParameter(1, in_name).getSingleResult();
	}
	
	
	//Returns all the SpookyPlaces
	@SuppressWarnings("unchecked")
	public Collection<SpookyPlace> findAllSpookyPlaces() {
		return getEm().createQuery("From SpookyPlace").getResultList();
	}
	
	//returns alll events belonging to a SpookyPlace
	public Collection<MonsterEvent> findEvents(SpookyPlace in_spookyPlace) {
		return null;
		
	}
	
	//creates a SpookyPlace
	public SpookyPlace createSpookyPlace(SpookyPlace in_spookyPlace) {
		beginTransaction();
		getEm().persist(in_spookyPlace);
		commitTransaction();
		return in_spookyPlace;
	}
	
	public void updateSpookyPlace(SpookyPlace in_spookyPlace) {
		beginTransaction();
		getEm().persist(in_spookyPlace);
		commitTransaction();
	}
	
	public void deleteSpookyPlace(SpookyPlace in_spookyPlace) {
		beginTransaction();
		getEm().remove(in_spookyPlace);
		commitTransaction();
		
	}


}
