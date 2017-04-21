<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%--
File Name 		:	showAccount.jsp
Project 		:	Monster_Events_JSP

Has FP			:	TRUE
FP				:	3
EI or EQ		:	EI

Accesses Tables	:	SPOOKED_CUSTOMER  (Ui)		
 --%>

<%@page import="com.cast.monster_event.base.model.Customer"%>
<%@page import="com.cast.monster_event.base.dao.CustomerDao"%><html
	xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>My Account Information</title>
</head>
<%
	String l_createAccountButton = request.getParameter("Save_Account");
	Customer l_currentCustomer;
	if (l_createAccountButton != null) {

		String l_firstName = request.getParameter("firstName");
		String l_lastName = request.getParameter("lastName");
		String l_organization = request.getParameter("organization");
		String l_emailAddress = request.getParameter("emailAddress");
		String l_mobileNumber = request.getParameter("mobileNumber");
		String l_homeNumber = request.getParameter("homeNumber");
		String l_address = request.getParameter("address");
		int l_zipCode =
				Integer.parseInt(request.getParameter("zipCode"));
		String l_city = request.getParameter("city");
		String l_state = request.getParameter("state");
		String l_country = request.getParameter("country");

		Customer l_newCustomer =
				new Customer(l_firstName, l_lastName, l_organization,
						l_emailAddress, l_mobileNumber, l_homeNumber,
						l_address, l_zipCode, l_city, l_state,
						l_country);

		CustomerDao l_customerDao = new CustomerDao();

		l_currentCustomer =
				l_customerDao.createAccountNative(l_newCustomer);
		session.setAttribute("CurrentCustomer", l_currentCustomer);
	} else {
		l_currentCustomer =
				(Customer) session.getAttribute("CurrentCustomer");
	}
%>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<h2>Account information for <%
	out.println(l_currentCustomer.getFirstName() + " "
			+ l_currentCustomer.getLastName());
%>
</h2>
<table>
	<tr>
		<td>Organization :</td>
		<td>
		<%
			out.println(l_currentCustomer.getOrganization());
		%>
		</td>
		<td bgcolor="#200000 "></td>
		<td>Email Address :</td>
		<td>
		<%
			out.println(l_currentCustomer.getEmailAddress());
		%>
		</td>
	</tr>
	<tr>
		<td>Cellular Number :</td>
		<td>
		<%
			out.println(l_currentCustomer.getMobileNumber());
		%>
		</td>
		<td bgcolor="#200000 "></td>
		<td>Home Number :</td>
		<td>
		<%
			out.println(l_currentCustomer.getHomeNumber());
		%>
		</td>
	</tr>
	<tr>
		<table>
			<tr>
				<td>Address :</td>
				<td>
				<%
					out.println(l_currentCustomer.getAddress());
				%>
				</td>
			</tr>
		</table>
	</tr>
	<tr>
		<td>Zip Code :</td>
		<td>
		<%
			out.println(l_currentCustomer.getZipCode());
		%>
		</td>
		<td bgcolor="#200000 "></td>
		<td>City :</td>
		<td>
		<%
			out.println(l_currentCustomer.getCity());
		%>
		</td>
	</tr>
	<tr>
		<td>State :</td>
		<td>
		<%
			out.println(l_currentCustomer.getState());
		%>
		</td>
		<td bgcolor="#200000 "></td>
		<td>Country :</td>
		<td>
		<%
			out.println(l_currentCustomer.getCountry());
		%>
		</td>
	</tr>
</table>
</body>
</html>