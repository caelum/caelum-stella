<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://stella.caelum.com.br/faces" prefix="stella"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Validando IE usando o Componente do Stella Faces</title>
</head>
<body>
<h1>Validando IE usando o Componente do Stella Faces</h1>
<h2>Versão com JSP</h2>
<f:view>
	<h:form id="formulario">

		<h:panelGrid>
			<h:outputLabel value="IE sem formatacao:" for="ie" />
			<h:inputText id="ie" value="#{UsuarioBean.ie}">
				<stella:validateIE estado="SP"/>
			</h:inputText>
			<h:message for="ie" />

			<h:outputLabel value="IE com formatacao:" for="ieFormatado" />
			<h:inputText id="ieFormatado" value="#{UsuarioBean.ieFormatado}">
				<stella:validateIE formatted="true" estado="SP"/>
			</h:inputText>
			<h:message for="ieFormatado" />
		</h:panelGrid>

		<h:commandButton value="Enviar" />
		<h:messages />
	</h:form>
	<f:subview id="sample-IE">
		<jsp:include page="/exemplos-IE.jsp"></jsp:include>
	</f:subview>
</f:view>
</body>
</html>