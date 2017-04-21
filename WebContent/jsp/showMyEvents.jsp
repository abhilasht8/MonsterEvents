<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%--
File Name 		:	showMyEvents.jsp 
Project 		:	Monster_Events_JSP

Has FP			:	TRUE
FP				:	7
EI or EQ		:	EQ

Accesses Tables	:	SPOOKY_PLACE, MONSTER, SPOOKY_OPTIONS, SPOOKY_EVENT, SPOOKED_CUSTOMER  (U)

Details : 			Here we have a table SPOOKED_CUSTOMER that is not really Queried, however we  
access the table SPOOKED_EVENT the field customer, which is of the PERSISTANT type Customer
 
 --%>
 
<%@page import="com.cast.monster_event.base.model.Customer"%>
<%@page import="com.cast.monster_event.base.dao.MonsterEventDao"%>
<%@page import="com.cast.monster_event.base.dao.CustomerDao"%>
<%@page import="com.cast.monster_event.base.model.MonsterEvent"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%><html
	xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>My Monster Events</title>
</head>
<%
Customer l_currentCustomer = (Customer) session.getAttribute("CurrentCustomer");
%>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<h2>Here are the event associated to <%out.println(l_currentCustomer.getStringValue()); %></h2>
<br />

<%
CustomerDao l_customerDao = new CustomerDao();

Collection<MonsterEvent> l_myEvents =  new ArrayList();
l_myEvents = l_customerDao.findEvents(l_currentCustomer);

for (MonsterEvent lt_currentEvent:l_myEvents) {
	out.println("<a href='showEvent.jsp?Event_ID="+lt_currentEvent.getEventId()+"'>"+lt_currentEvent.getStringValue()+ "</a> <BR/>");
}

%>

</body>
</html>