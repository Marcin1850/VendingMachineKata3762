<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Vending Machine</title>

<style>
.errorMessage {color:red;}
.blueBg {background-color:blue;}
.darkKhakiBg {background-color:darkKhaki;}
.greenYellowBg {background-color:greenYellow;}
</style>
</head>

<body>
    <a href="/VendingMachineKata/machine.action">Main page</a>
    <hr/>

    <h1>Vending Machine</h1>

    <p>Current products:</p>
    <table border="1" class="greenYellowBg">
        <tr>
            <td>Shelf number</td>
            <td>Product name</td>
            <td>Quantity</td>
        </tr>
        <s:iterator value="storage.shelves" status="stat">
            <tr>
                <td><s:property value="%{#stat.index + 1}" /></td>
                <td><s:property value="product.productType.name" /></td>
                <td><s:property value="quantity" /></td>
            </tr>
        </s:iterator>
    </table>
    <hr/>

    <p>
        <s:form action="machine" method="post">
            <s:textfield
                label="Shelf 1"
                name="storage.shelves[0].product.productType.name"
                size="20" />
            <s:textfield
                name="storage.shelves[0].quantity"
                size="5" />
            <s:submit value="Actualize shelves" showLoadingText="true" />
        </s:form>
    </p>
</body>
</html>
