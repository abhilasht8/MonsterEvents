<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%--
File Name 		:	showOptions.jsp 
Project 		:	Monster_Events_JSP

Has FP			:	TRUE
FP				:	7
EI or EQ		:	EQ

Accesses Tables	:	SPOOKY_OPTIONS, SPOOKY_EVENT (MONSTER has a persistant member of this type)  (U)

Details : 			Here we have a table SPOOKY_OPTIONS that is really Queried, but we also access the 
table SPOOKY_EVENT the field usedAtEvents, which is of the PERSISTANT type MonsterEvent
 		
 --%>


<%@page import="com.cast.monster_event.base.dao.SpookyOptionDao"%>
<%@page import="java.util.Collection"%>
<%@page import="com.cast.monster_event.base.model.SpookyOption"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>The list of our options</title>
</head>
<%
SpookyOptionDao l_optionDao = new SpookyOptionDao();
Collection<SpookyOption> l_optionList = l_optionDao.findAllSpookyOptions();
%>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<%
for (SpookyOption lt_option:l_optionList) {
	out.println("<a href='showDistinctSpookyOption.jsp?OPTION_ID="+lt_option.getOptionId()+"'>"+lt_option.getStringValue()+"</a> <BR/>");
}
%>
</body>
</html>