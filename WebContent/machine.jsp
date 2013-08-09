<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Vending Machine</title>

<sx:head />

<style>
.errorMessage {color:red;}
</style>
</head>

<body>
    <a href="/VendingMachineKata">Main page</a>
    <hr/>

    <h1>Vending Machine</h1>

    <%@include file="adminMachine.jsp" %>

    <hr/>

    <label for="otherValue">Other value:</label>
    <input type="text" name="otherValue" value="<s:property value="otherValue"/>" />
</body>
</html>
