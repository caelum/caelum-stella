<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<f:subview id="sample-cnpj">
	<h4>Exemplos de CNPJ</h4>
	<h:panelGrid columns="2">
		<h:outputLabel value="CNPJ Válido:" />
		<h:outputLabel value="63025530002409" />
		<h:outputLabel value="CNPJ INVALID_CHECK_DIGITS:" />
		<h:outputLabel value="74221325000160" />
		<h:outputLabel value="CNPJ INVALID_DIGITS:" />
		<h:outputLabel value="1234567890123" />
		<h:outputLabel value="CNPJ Formatado:" />
		<h:outputLabel value="26.637.142/0001-58" />
	</h:panelGrid>
</f:subview>
