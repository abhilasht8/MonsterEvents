<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Monster Event Login</title>
</head>
<body>
<form action="welcome.jsp" method="post">
<table>
	<tr>
		<td>Please Enter your First Name :</td>
		<td><input type="text" name="firstName" value="Benjamine"/></td>
	</tr>
	<tr>
		<td>Please Enter your Last Name :</td>
		<td><input type="text" name="lastName" value="Dover"/></td>
	</tr>
	<tr>
		<td>Please Enter your Organization :</td>
	
		<td><input type="text" name="organization" value="The Nice Enterprise"/></td>
	</tr>
</table>
<input type="submit" value="Search"/>
</form>
</body>
</html>