<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%--
File Name 		:	welcome.jsp
Project 		:	Monster_Events_JSP

Has FP			:	TRUE
FP				:	4
EI or EQ		:	EQ

Accesses Tables	:	SPOOKED_CUSTOMER  (Us)		
 --%>
 
<%@page import="com.cast.monster_event.base.dao.CustomerDao"%>
<%@page import="com.cast.monster_event.base.model.Customer"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Welcome Page</title>
</head>
<%
	String l_firstName = request.getParameter("firstName");
	String l_lastName = request.getParameter("lastName");

	String l_Organization = request.getParameter("organization");

	CustomerDao l_customerDao = new CustomerDao();

	Customer l_customer =
			l_customerDao.findByName(l_firstName, l_lastName,
					l_Organization);

	session.setAttribute("CurrentCustomer", l_customer);
%>
<body>

<jsp:include page="menu.jsp"></jsp:include>

<BR />
<h2>Welcome <%
	out.println(l_customer.getFirstName());
%>
</h2>

</body>
</html>