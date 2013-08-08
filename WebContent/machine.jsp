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
    <a href="/VendingMachineKata">Main page</a>
    <hr/>

    <h1>Vending Machine</h1>
    <form action="machine">
        <p>
        <label for="shelves[0].productName">Shelf 1:</label>
        <input type="text"
            name="shelves[0].productName"
            <s:if test="shelves[0] != null">value="<s:property value="shelves[0].productName"/>"</s:if> />
        <input type="text"
            name="shelves[0].quantity"
            <s:if test="shelves[0] != null">value="<s:property value="shelves[0].quantity"/>"</s:if> />
        </p>
        <p>
        <input type="submit" value="Actualize"/>
        </p>
    </form>

    <label for="otherValue">Other value:</label>
    <input type="text" name="otherValue" value="<s:property value="otherValue"/>" />
</body>
</html>
