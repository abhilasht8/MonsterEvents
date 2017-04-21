package com.cast.monster_event.base.dao;

import java.util.Collection;

import com.cast.monster_event.base.model.Customer;
import com.cast.monster_event.base.model.MonsterEvent;

/**
 * @author BGA
 * @created 30 juin 2010
 * Description : 
 * 
 */

public class MonsterEventDao extends JPAResourceDao {

	public MonsterEventDao() {
		super();
	}
		
	//Finds a Customer by its Id
	public MonsterEvent findById(long in_id) {
		return (MonsterEvent) getEm().createQuery("From MonsterEvent where eventId=?1").setParameter(1, in_id).getSingleResult();
	}
	
	//Finds a MonsterEvent by its name
	public MonsterEvent findByName(String in_firstName,String in_lastName,String in_organization, String in_place) {
		return (MonsterEvent) getEm().createQuery("From MonsterEvent where customer.firstName=?1 and customer.lastName=?2 and customer.organization=?3 and location.name=?4").setParameter(1, in_firstName).setParameter(2, in_lastName).setParameter(3, in_organization).setParameter(4, in_place).getSingleResult();
	}	
	
	//Returns all the MonsterEvents
	public Collection<MonsterEvent> findAllMonsterEvents() {
		return getEm().createQuery("From MonsterEvent").getResultList();
	}
	
	//returns alll events belonging to a MonsterEvent
	public Collection<MonsterEvent> findEvents(MonsterEvent in_MonsterEvent) {
		return null;
		
	}
	
	//creates a MonsterEvent
	public MonsterEvent createMonsterEvent(MonsterEvent in_MonsterEvent) {
		beginTransaction();
		getEm().merge(in_MonsterEvent);
		commitTransaction();
		return in_MonsterEvent;
	}
	
	public void updateMonsterEvent(MonsterEvent in_MonsterEvent) {
		beginTransaction();
		getEm().persist(in_MonsterEvent);
		commitTransaction();
	}
	
	public void deleteMonsterEvent(MonsterEvent in_MonsterEvent) {
		beginTransaction();
		getEm().remove(in_MonsterEvent);
		commitTransaction();
		
	}


}
