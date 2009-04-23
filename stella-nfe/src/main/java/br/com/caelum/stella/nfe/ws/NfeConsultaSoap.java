//
//package br.com.caelum.stella.nfe.ws;
//
//import javax.jws.WebMethod;
//import javax.jws.WebParam;
//import javax.jws.WebResult;
//import javax.jws.WebService;
//import javax.xml.bind.annotation.XmlSeeAlso;
//import javax.xml.ws.RequestWrapper;
//import javax.xml.ws.ResponseWrapper;
//
//
//@WebService(name = "NfeConsultaSoap", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeConsulta")
//@XmlSeeAlso({
//    ObjectFactory.class
//})
//public interface NfeConsultaSoap {
//
//
//    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeConsulta/nfeConsultaNF")
//    @WebResult(name = "nfeConsultaNFResult", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeConsulta")
//    @RequestWrapper(localName = "nfeConsultaNF", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeConsulta", className = "br.com.caelum.stella.nfe.ws.NfeConsultaNF")
//    @ResponseWrapper(localName = "nfeConsultaNFResponse", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeConsulta", className = "br.com.caelum.stella.nfe.ws.NfeConsultaNFResponse")
//    public String nfeConsultaNF(
//        @WebParam(name = "nfeCabecMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeConsulta")
//        String nfeCabecMsg,
//        @WebParam(name = "nfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeConsulta")
//        String nfeDadosMsg);
//
//}
