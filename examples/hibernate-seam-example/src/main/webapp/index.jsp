<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html
        PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:s="http://jboss.com/products/seam/taglib">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Exemplo de Validação com Jboss Seam e Stella Hiberante Validator</title>
</head>
<body>
<f:view>
	<h1>Exemplo de Validação com Jboss Seam e Stella Hiberante Validator</h1>
	<h2>Preencha os campos:</h2>
	<h:form>
		<s:validateAll>
		<h:panelGrid>
			<h:outputLabel for="cpf" value="CPF:" />
			<h:inputText id="cpf" value="#{modelo.cpf}"/>
			
			<h:outputLabel for="cnpj" value="CNPJ:" />
			<h:inputText id="cnpj" value="#{modelo.cnpj}"/>
			
		</h:panelGrid>
		</s:validateAll>
		<h:commandButton value="Enviar" action="#{ModeloBean.submit}" />
		<s:message styleClass="msgErro"/> 
	</h:form>
</f:view>
</body>
</html>
