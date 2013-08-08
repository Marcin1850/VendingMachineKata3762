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
    <s:form action="machine" method="post">
        <p>
        <s:textfield
            label="Shelf 1"
            name="shelves[0].productName"
            size="20" />
        <s:textfield
            name="shelves[0].quantity"
            size="5" />
        </p>
        <p>
        <s:submit name="Actualize"/>
        </p>
    </s:form>

    <hr/>

    <label for="otherValue">Other value:</label>
    <input type="text" name="otherValue" value="<s:property value="otherValue"/>" />
</body>
</html>
