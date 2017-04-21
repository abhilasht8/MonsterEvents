<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%--
File Name 		:	showEvent.jsp 
Project 		:	Monster_Events_JSP

Has FP			:	TRUE
FP				:	7
EI or EQ		:	EQ

Accesses Tables	:	SPOOKY_PLACE, MONSTER, SPOOKY_OPTIONS, SPOOKY_EVENT, SPOOKED_CUSTOMER  (U)

Details : 			Here we have a table SPOOKED_CUSTOMER that is not really Queried, however we  
access the table SPOOKED_EVENT the field customer, which is of the PERSISTANT type Customer
 
 --%>

<%@page import="com.cast.monster_event.base.model.Monster"%>
<%@page import="com.cast.monster_event.base.model.MonsterEvent"%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.cast.monster_event.base.dao.MonsterDao"%>
<%@page import="java.util.Collection"%>
<%@page import="com.cast.monster_event.base.dao.SpookyPlaceDao"%>
<%@page import="com.cast.monster_event.base.model.SpookyPlace"%>
<%@page import="com.cast.monster_event.base.model.SpookyOption"%>
<%@page import="com.cast.monster_event.base.dao.SpookyOptionDao"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.cast.monster_event.base.model.Customer"%>
<%@page import="com.cast.monster_event.base.model.EventStatus"%>
<%@page import="com.cast.monster_event.base.dao.MonsterEventDao"%><html
	xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Event Details</title>
</head>
<%
	String l_createEventButton = request.getParameter("Save_Event");
	String l_updateEventButton = request.getParameter("Update_Event");
	
	MonsterEvent l_thisMonsterEvent = new MonsterEvent();
	MonsterEventDao l_eventDao = new MonsterEventDao();
	
	String l_eventId = request.getParameter("Event_ID");
	
	//We'll see if we come from the createEvent Page or not
	if ((l_createEventButton != null) || (l_updateEventButton != null)) {
		//save event

		//retrieve form parameters

		//retrieve the spooky place Dao
		int l_selectedPlaceId =
				Integer.parseInt(request.getParameter("PlaceSelect"));

		SpookyPlaceDao l_placeDao = new SpookyPlaceDao();
		SpookyPlace l_selectedSpookyPlace =
				l_placeDao.findById(l_selectedPlaceId);

		//retrieve the monsters
		Collection<Monster> l_selectedMonsters =
				new ArrayList<Monster>();
		MonsterDao l_monsterDao = new MonsterDao();
		for (String l_monsterIdString : request
				.getParameterValues("MonsterSelect")) {
			Monster lt_monster =
					l_monsterDao.findById(Integer
							.parseInt(l_monsterIdString));
			l_selectedMonsters.add(lt_monster);
		}

		//retrieval of simple parameters 
		int l_nrOfParticipants =
				Integer.parseInt(request
						.getParameter("nrOfParticipants"));

		//retrieval of dates
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		Date l_startDate =
				df.parse(request.getParameter("plannedStart"));
		Date l_endDate = df.parse(request.getParameter("plannedEnd"));

		//Retrieval of the spooky options
		Collection<SpookyOption> l_selectedOptions =
				new ArrayList<SpookyOption>();
		SpookyOptionDao l_optionDao = new SpookyOptionDao();

		for (String l_optionString : request
				.getParameterValues("OptionsSelect")) {
			SpookyOption lt_Option =
					l_optionDao.findById(Integer
							.parseInt(l_optionString));
			l_selectedOptions.add(lt_Option);
		}		

		if (l_updateEventButton != null) {
			l_thisMonsterEvent =
					l_eventDao.findById(Integer.parseInt(request
							.getParameter("Event_ID")));
		}

		//create and save the monster event
		l_thisMonsterEvent.setCustomer((Customer) session
				.getAttribute("CurrentCustomer"));
		l_thisMonsterEvent.setBookedMonsters(l_selectedMonsters);
		l_thisMonsterEvent.setLocation(l_selectedSpookyPlace);
		l_thisMonsterEvent.setPlannedStart(l_startDate);
		l_thisMonsterEvent.setPlannedEnd(l_endDate);
		l_thisMonsterEvent.setNrOfParticipants(l_nrOfParticipants);
		l_thisMonsterEvent.setStatus(EventStatus.Planned);
		l_thisMonsterEvent.setOptions(l_selectedOptions);

		if (l_createEventButton != null)
			l_thisMonsterEvent =
					l_eventDao.createMonsterEvent(l_thisMonsterEvent);
		else
			l_eventDao.updateMonsterEvent(l_thisMonsterEvent);

		//message to the user 
		out.println("monster event saved</BR>");
	} else {
		l_thisMonsterEvent =
			l_eventDao.findById(Integer.parseInt(request
					.getParameter("Event_ID")));				
	}
%>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<Br/>	
<h2>Details of the Event <%
	out.println(l_thisMonsterEvent.getStringValue());
%>
</h2>
<a href="updateEvent.jsp">Update this Event</a>
</body>
</html>