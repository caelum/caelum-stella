<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://stella.caelum.com.br/faces" prefix="stella"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Validando NIT usando o Componente do Stella Faces</title>
</head>
<body>
<h1>Validando NIT usando o Componente do Stella Faces</h1>
<h2>Versão com JSP</h2>
<f:view>
	<h:form id="formulario">

		<h:panelGrid>
			<h:outputLabel value="NIT sem formatacao:" for="NIT" />
			<h:inputText id="NIT" value="#{UsuarioBean.nit}">
				<stella:validateNIT />
			</h:inputText>
			<h:message for="NIT" />


			<h:outputLabel value="NIT com formatacao:" for="NITFormatado" />
			<h:inputText id="NITFormatado" value="#{UsuarioBean.nitFormatado}">
			  <stella:validateNIT formatted="true" />
			</h:inputText>
			<h:message for="NITFormatado" />
		</h:panelGrid>

		<h:commandButton value="Enviar" />
		<h:messages />
	</h:form>
	<f:subview id="sample-nit">
		<jsp:include page="/exemplos-NIT.jsp"></jsp:include>
	</f:subview>
</f:view>
</body>
</html>