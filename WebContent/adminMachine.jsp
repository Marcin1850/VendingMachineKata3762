<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<s:div id="adminMachineDiv">
    <s:form action="adminMachine" method="post">
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
        <sx:submit targets="adminMachineDiv" value="Actualize shelves" showLoadingText="true" />
        </p>
    </s:form>
</s:div>
