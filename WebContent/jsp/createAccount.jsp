<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<form action="showAccount.jsp" method="post">
<table>
<tr>
<td>Enter First Name : </td>
<td><input name="firstName" type="text"/></td>
<td>Enter Last Name : </td>
<td><input name="lastName" type="text"/></td>
</tr>
<tr>
<td>Enter Organization Name : </td>
<td><input name="organization" type="text"/></td>
<td>Enter Email Address : </td>
<td><input name="emailAddress" type="text"/></td>
</tr>
<tr>
<td>Enter Cellular Number : </td>
<td><input name="mobileNumber" type="text"/></td>
<td>Enter Home Number : </td>
<td><input name="homeNumber" type="text"/></td>
</tr>
<tr>
<table>
<tr><td>Enter Address : </td></tr>
<tr><td><input name="address" type="text"/></td></tr>
</table>
</tr>
<tr>
<td>Enter Zipcode : </td>
<td><input name="zipCode" type="text"/></td>
<td>Enter City Name : </td>
<td><input name="city" type="text"/></td>
</tr>
<tr>
<td>Enter State : </td>
<td><input name="state" type="text"/></td>
<td>Enter Country : </td>
<td><input name="country" type="text"/></td>
</tr>
</table>
<input type="submit" name="Save_Account" value="Save Account"/>
</form>
</body>
</html>