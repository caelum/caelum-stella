//
//package br.com.caelum.stella.nfe.ws;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import javax.xml.namespace.QName;
//import javax.xml.ws.Service;
//import javax.xml.ws.WebEndpoint;
//import javax.xml.ws.WebServiceClient;
//import javax.xml.ws.WebServiceFeature;
//
//
//@WebServiceClient(name = "NfeConsulta", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeConsulta", wsdlLocation = "file:/Users/setf/Documents/workspace/caelum-stella/stella-nfe/src/main/resources/wsdl-sp/NfeCancelamento.wsdl")
//public class NfeConsulta
//    extends Service
//{
//
//    private final static URL NFECONSULTA_WSDL_LOCATION;
//
//    static {
//        URL url = null;
//        try {
//            url = new URL("file:/Users/setf/Documents/workspace/caelum-stella/stella-nfe/src/main/resources/wsdl-sp/NfeCancelamento.wsdl");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        NFECONSULTA_WSDL_LOCATION = url;
//    }
//
//    public NfeConsulta(URL wsdlLocation, QName serviceName) {
//        super(wsdlLocation, serviceName);
//    }
//
//    public NfeConsulta() {
//        super(NFECONSULTA_WSDL_LOCATION, new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NfeConsulta", "NfeConsulta"));
//    }
//
//    @WebEndpoint(name = "NfeConsultaSoap")
//    public NfeConsultaSoap getNfeConsultaSoap() {
//        return (NfeConsultaSoap)super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NfeConsulta", "NfeConsultaSoap"), NfeConsultaSoap.class);
//    }
//
//    @WebEndpoint(name = "NfeConsultaSoap")
//    public NfeConsultaSoap getNfeConsultaSoap(WebServiceFeature... features) {
//        return (NfeConsultaSoap)super.getPort(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NfeConsulta", "NfeConsultaSoap"), NfeConsultaSoap.class, features);
//    }
//
//}
