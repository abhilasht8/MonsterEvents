package com.cast.monster_event.base.dao;

import java.util.Collection;

import com.cast.monster_event.base.model.Monster;
import com.cast.monster_event.base.model.MonsterEvent;

/**
 * @author BGA
 * @created 30 juin 2010
 * Description : 
 * 
 */
//public class MonsterDao extends JPAResourceDao {
public class MonsterDao extends JPAResourceDao{
	
	/**
	 * 
	 */
	public MonsterDao() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	//Finds a monster by its Id
	public Monster findById(long in_id) {
		return (Monster) getEm().createQuery("From Monster where monsterId=?1").setParameter(1, in_id).getSingleResult();
	}
	
	//Finds a monster by its name
	public Monster findByName(String in_firstName,String in_lastName,String in_nomDuScene) {
		return (Monster) getEm().createQuery("From Monster where firstName=?1 and lastName=?2 and nomDuScene=?3 ").setParameter(1, in_firstName).setParameter(2, in_lastName).setParameter(3, in_nomDuScene).getSingleResult();
	}
	
	
	//Returns all the monsters
	public Collection<Monster> findAllMonsters() {
		return getEm().createQuery("From Monster").getResultList();
	}
	
	//returns alll events belonging to a Monster
	public Collection<MonsterEvent> findEvents(Monster in_Monster) {
		return null;
		
	}
	
	//creates a monster
	public Monster createMonster(Monster in_monster) {
		beginTransaction();
		getEm().persist(in_monster);
		commitTransaction();
		return in_monster;
	}
	
	public void updateMonster(Monster in_monster) {
		beginTransaction();
		getEm().persist(in_monster);
		commitTransaction();
	}
	
	public void deleteMonster(Monster in_monster) {
		beginTransaction();
		getEm().remove(in_monster);
		commitTransaction();
		
	}


}
