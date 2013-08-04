<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Vending Machine</title>
</head>
<body>
    <h1>Vending Machine</h1>
    <form action="machine">
        <label for="name">Please enter your name</label><br/>
        <input type="text" name="name"/>
        <input type="submit" value="Send"/>
    </form>

    <s:if test="name != null">
        <hr>
        <p>Hello, <s:property value="name"/></p>
    </s:if>
</body>
</html>
