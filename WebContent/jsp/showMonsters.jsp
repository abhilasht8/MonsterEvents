<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%--
File Name 		:	showMonsters.jsp
Project 		:	Monster_Events_JSP

Has FP			:	TRUE
FP				:	7
EI or EQ		:	EQ

Accesses Tables	:	MONSTER, SPOOKY_EVENT (MONSTER has a persistant member of this type)  (U)

Details : 			Here we have a table MONSTER that is really Queried, but we also access the table 
SPOOKY_EVENT the field participatedEvents, which is of the PERSISTANT type MonsterEvent
 		
 --%>
 
<%@page import="com.cast.monster_event.base.dao.MonsterDao"%>
<%@page import="java.util.Collection"%>
<%@page import="com.cast.monster_event.base.model.Monster"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>The list of our monsters</title>
</head>
<%
MonsterDao l_monsterDao = new MonsterDao();
Collection<Monster> l_monsterList = l_monsterDao.findAllMonsters();
%>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<%
for (Monster lt_monster:l_monsterList) {
	out.println("<a href='showDistinctMonster.jsp?MONSTER_ID="+lt_monster.getMonsterId()+"'>"+lt_monster.getStringValue()+"</a> <BR/>");
}
%>
</body>
</html>