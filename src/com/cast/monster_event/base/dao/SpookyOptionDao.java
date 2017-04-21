package com.cast.monster_event.base.dao;

import java.util.Collection;

import com.cast.monster_event.base.model.MonsterEvent;
import com.cast.monster_event.base.model.SpookyOption;

/**
 * @author BGA
 * @created 30 juin 2010
 * Description : 
 * 
 */

public class SpookyOptionDao extends JPAResourceDao{

	public SpookyOptionDao() {
		super();
	}
		
	//Finds a spooky option by its Id
	public SpookyOption findById(long in_id) {
		return (SpookyOption) getEm().createQuery("From SpookyOption where optionId=?1").setParameter(1, in_id).getSingleResult();
	}
	
	//Finds a spooky option by its name
	public SpookyOption findByName(String in_name) {
		return (SpookyOption) getEm().createQuery("From SpookyOption where title=?1").setParameter(1, in_name).getSingleResult();
	}
	
	
	//Returns all the spooky options
	@SuppressWarnings("unchecked")
	public Collection<SpookyOption> findAllSpookyOptions() {
		return getEm().createQuery("From SpookyOption").getResultList();
	}
	
	//returns alll events using to a SpookyOption
	public Collection<MonsterEvent> findEvents(SpookyOption in_SpookyOption) {
		return null;
		
	}
	
	//creates a spooky option
	public SpookyOption createSpookyOption(SpookyOption in_spookyOption) {
		beginTransaction();
		getEm().persist(in_spookyOption);
		commitTransaction();
		return in_spookyOption;
	}
	
	public void updateSpookyOption(SpookyOption in_spookyOption) {
		beginTransaction();
		getEm().persist(in_spookyOption);
		commitTransaction();
	}
	
	public void deleteSpookyOption(SpookyOption in_spookyOption) {
		beginTransaction();
		getEm().remove(in_spookyOption);
		commitTransaction();
		
	}


}
