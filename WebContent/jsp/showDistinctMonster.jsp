<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%--
File Name 		:	showDistinctMonster.jsp
Project 		:	Monster_Events_JSP

Has FP			:	TRUE
FP				:	7
EI or EQ		:	EQ

Accesses Tables	:	MONSTER, SPOOKY_EVENT (MONSTER has a persistant member of this type)  (U)

Details : 			Here we have a table MONSTER that is really Queried, but we also access the table 
SPOOKY_EVENT the field participatedEvents, which is of the PERSISTANT type MonsterEvent
 		
 --%>


<%@page import="com.cast.monster_event.base.dao.MonsterDao"%>
<%@page import="com.cast.monster_event.base.model.Monster"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>monster details</title>
</head>
<%
int l_monsterId = Integer.parseInt(request.getParameter("MONSTER_ID"));

MonsterDao l_monsterDao = new MonsterDao();
Monster l_monster = l_monsterDao.findById(l_monsterId);
%>

<body>
<jsp:include page="menu.jsp"></jsp:include>

</body>
</html>