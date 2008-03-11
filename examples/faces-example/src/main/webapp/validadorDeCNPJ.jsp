<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://stella.caelum.com.br/faces" prefix="stella"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Validando CNPJ usando o Componente do Stella Faces</title>
</head>
<body>
<h1>Validando CNPJ usando o Componente do Stella Faces</h1>
<h2>Versão com JSP</h2>
<f:view>
	<h:form id="formulario">

		<h:panelGrid>
			<h:outputLabel value="CNPJ sem formatacao:" for="CNPJ" />
			<h:inputText id="CNPJ" value="#{UsuarioBean.cnpj}">
				<stella:validateCNPJ />
			</h:inputText>
			<h:message for="CNPJ" />

			<h:outputLabel value="CNPJ com formatacao:" for="CNPJFormatado" />
			<h:inputText id="CNPJFormatado" value="#{UsuarioBean.cnpjFormatado}">
				<stella:validateCNPJ formatted="true" />
			</h:inputText>
			<h:message for="CNPJFormatado" />
		</h:panelGrid>

		<h:commandButton value="Enviar" />
		<h:messages />
	</h:form>
	<f:subview id="sample-cnpj">
		<jsp:include page="/exemplos-CNPJ.jsp"></jsp:include>
	</f:subview>
</f:view>
</body>
</html>