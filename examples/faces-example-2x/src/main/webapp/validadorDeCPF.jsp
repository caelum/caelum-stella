<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://stella.caelum.com.br/faces" prefix="stella"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Validando CPF usando o Componente do Stella Faces</title>
</head>
<body>
<h1>Validando CPF usando o Componente do Stella Faces</h1>
<h2>Versão com JSP</h2>
<f:view>
	<h:form id="formulario">

		<h:panelGrid>
			<h:outputLabel value="cpf sem formatacao:" for="cpf" />
			<h:inputText id="cpf" value="#{UsuarioBean.cpf}">
				<stella:validateCPF/>
			</h:inputText>
			<h:message for="cpf" />

			<h:outputLabel value="cpf com formatacao:" for="cpfFormatado" />
			<h:inputText id="cpfFormatado" value="#{UsuarioBean.cpfFormatado}">
				<stella:validateCPF formatted="true" />
			</h:inputText>
			<h:message for="cpfFormatado" />
		</h:panelGrid>

		<h:commandButton value="Enviar" />
		<h:messages />
	</h:form>
	<f:subview id="sample-cpf">
		<jsp:include page="/exemplos-CPF.jsp"></jsp:include>
	</f:subview>
</f:view>
</body>
</html>