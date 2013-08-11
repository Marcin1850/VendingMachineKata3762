<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<s:div id="adminMachineDiv">
    <p>Current products:</p>
    <table border="1" class="greenYellowBg">
        <tr>
            <td>Shelf number</td>
            <td>Product name</td>
            <td>Quantity</td>
        </tr>
        <tr>
            <td><s:property value="1" /></td>
            <td><s:property value="storage.shelves[0].product.productType.name" /></td>
            <td><s:property value="storage.shelves[0].quantity" /></td>
        </tr>
    </table>
    <hr/>

    <p>
        <s:form action="adminMachine" method="post">
            <s:textfield
                label="Shelf 1"
                name="shelves[0].product.productType.name"
                size="20" />
            <s:textfield
                name="shelves[0].product.quantity"
                size="5" />
            <sx:submit targets="adminMachineDiv" value="Actualize shelves" showLoadingText="true" />
        </s:form>
    </p>
</s:div>
