<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%--
File Name 		:	showPlaces.jsp  
Project 		:	Monster_Events_JSP

Has FP			:	TRUE
FP				:	4
EI or EQ		:	EQ

Accesses Tables	:	SPOOKY_PLACE  (U)

 --%>
 
 
<%@page import="com.cast.monster_event.base.dao.SpookyPlaceDao"%>
<%@page import="java.util.Collection"%>
<%@page import="com.cast.monster_event.base.model.SpookyPlace"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>The list of our places</title>
</head>
<%
SpookyPlaceDao l_placeDao = new SpookyPlaceDao();
Collection<SpookyPlace> l_placeList = l_placeDao.findAllSpookyPlaces();
%>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<%
for (SpookyPlace lt_place:l_placeList) {
	out.println("<a href='showDistinctSpookyPlace.jsp?PLACE_ID="+lt_place.getPlaceId()+"'>"+lt_place.getStringValue()+"</a> <BR/>");
}
%>
</body>
</html>