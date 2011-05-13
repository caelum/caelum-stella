<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<f:subview id="sample-cpf">
	<h4>Exemplos de CPF</h4>
	<h:panelGrid columns="2">
		<h:outputLabel value="CPF Válido:" />
		<h:outputLabel value="47393545608" />
		<h:outputLabel value="CPF INVALID_CHECK_DIGITS:" />
		<h:outputLabel value="09907586561" />
		<h:outputLabel value="CPF INVALID_DIGITS:" />
		<h:outputLabel value="123456789012" />
		<h:outputLabel value="CPF Formatado:" />
		<h:outputLabel value="356.296.825-63" />
	</h:panelGrid>
</f:subview>
</body>
</html>