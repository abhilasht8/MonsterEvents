<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%--
File Name 		:	createEvent.jsp
Project 		:	Monster_Events_JSP

Has FP			:	TRUE
FP				:	7
EI or EQ		:	EQ

Accesses Tables	:	SPOOKY_PLACE, MONSTER, SPOOKY_OPTIONS (U)
 --%>

<%@page import="com.cast.monster_event.base.model.SpookyPlace"%>
<%@page import="com.cast.monster_event.base.dao.SpookyPlaceDao"%>
<%@page import="java.util.Collection"%>
<%@page import="com.cast.monster_event.base.dao.MonsterDao"%>
<%@page import="com.cast.monster_event.base.model.Monster"%>
<%@page import="com.cast.monster_event.base.dao.SpookyOptionDao"%>
<%@page import="com.cast.monster_event.base.model.SpookyOption"%><html
	xmlns="http://www.w3.org/1999/xhtml">

<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Create new Event</title>
</head>
<%
	SpookyPlaceDao l_placeDao = new SpookyPlaceDao();
	Collection<SpookyPlace> l_placeList =
			(Collection<SpookyPlace>) l_placeDao.findAllSpookyPlaces();

	MonsterDao l_monsterDao = new MonsterDao();
	Collection<Monster> l_monstersList =
			(Collection<Monster>) l_monsterDao.findAllMonsters();

	SpookyOptionDao l_optionDao = new SpookyOptionDao();
	Collection<SpookyOption> l_optionsList =
			(Collection<SpookyOption>) l_optionDao
					.findAllSpookyOptions();
%>
<body>
<h2>Create a new Event</h2>
<form action="showEvent.jsp" method="post">
<table>
	<tr>
		<td>Select the location for this event :</td>
		<td>
			<select name="PlaceSelect">
				<%
					for (SpookyPlace l_place : l_placeList) {
						out.println("<option value='" + l_place.getPlaceId() + "'>"
								+ l_place.getStringValue() + "</option>");
					}
				%>
			</select>
		</td>
	</tr>
	<tr>
		<td>Select the Monsters you want for this event :</td>
		<td>
			<%
				for (Monster l_monster : l_monstersList) {
					out.println("<input type='checkbox' name='MonsterSelect' value='"+l_monster.getMonsterId()+"' />"+l_monster.getStringValue()+"<br />");
				}
			%>
		</td>
	</tr>
	<tr>
		<td>Number of Participants</td>
		<td><input name="nrOfParticipants" type="text" value="1" /></td>
	</tr>
	<tr>
		<td>Planned Start (DD/MM/YYYY) :</td>
		<td><input name="plannedStart" type="text" /></td>
	</tr>
	<tr>
		<td>Planned End (DD/MM/YYYY) :</td>
		<td><input name="plannedEnd" type="text" /></td>
	</tr>
			<tr>
		<td>Select the Options you want for this event :</td>
		<td>		
				<%
					for (SpookyOption l_option : l_optionsList) {
						out.println("<input type='checkbox' name='OptionsSelect' value='"+l_option.getOptionId()+"' />"+l_option.getStringValue()+"<br />");
					}
				%>
			</select>
		</td>
	</tr>
</table>
<input type="submit" name="Save_Event" value="Save Event"/>
</form>


</body>
</html>