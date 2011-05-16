<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://stella.caelum.com.br/faces" prefix="stella" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <title>Validando IE usando o Componente do Stella Faces</title>
</head>
<body>
<h1>Validando IE usando o Componente do Stella Faces</h1>

<h2>Versão com JSP</h2>
<f:view>
  <h:form id="formulario">

    <h:panelGrid>

      <h:outputText value="Selecione um estado:"/>
      <h:selectOneMenu id="estado">
        <f:selectItem itemValue="" itemLabel=""/>
        <f:selectItem itemValue="SP" itemLabel="SP"/>
        <f:selectItem itemValue="RJ" itemLabel="RJ"/>
        <f:selectItem itemValue="MG" itemLabel="MG"/>
        <f:selectItem itemValue="RS" itemLabel="RS"/>
        <f:selectItem itemValue="SC" itemLabel="SC"/>
      </h:selectOneMenu>

      <h:outputLabel value="IE sem formatacao:" for="ie"/>
      <h:inputText id="ie" value="#{EmpresaBean.ie}">
        <stella:validateIE estadoComponentId="formulario:estado" formatted="false"/>
      </h:inputText>
      <h:message for="ie"/>

      <h:outputLabel value="IE com formatacao:" for="ieFormatado"/>
      <h:inputText id="ieFormatado" value="#{EmpresaBean.ieFormatado}">
        <stella:validateIE estadoComponentId="formulario:estado" formatted="true"/>
      </h:inputText>
      <h:message for="ieFormatado"/>

    </h:panelGrid>

    <h:commandButton value="Enviar"/>
    <h:messages/>
  </h:form>

  <jsp:include page="/exemplos-IE.jsp" />
</f:view>
</body>
</html>