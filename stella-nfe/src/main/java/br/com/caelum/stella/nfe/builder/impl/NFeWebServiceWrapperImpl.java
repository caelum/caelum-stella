package br.com.caelum.stella.nfe.builder.impl;

import net.vidageek.fluid.proxy.ObjectCreator;
import br.com.caelum.stella.nfe.builder.NFeWebServiceWrapper;
import br.com.caelum.stella.nfe.fluid.Cabecalho;
import br.com.caelum.stella.nfe.xml.JAXBXmlBinder;
import br.com.caelum.stella.nfe.xml.XmlBinder;

/**
 * @author jonasabreu
 * 
 */
final public class NFeWebServiceWrapperImpl<T> implements NFeWebServiceWrapper<T>, ObjectCreator {

    private Cabecalho<NFeWebServiceWrapper<T>> cabecalho;
    private final T body;

    public NFeWebServiceWrapperImpl(final T body) {
        this.body = body;
    }

    public Cabecalho<NFeWebServiceWrapper<T>> withCabecalho() {
        cabecalho = new CabecalhoImpl<NFeWebServiceWrapper<T>>(this);
        return cabecalho;
    }

    public T withCorpo() {
        return body;
    }

    public T build() {
        return null;
    }

    public Object getInstance() {
        return this;
    }

    public String getXml() {
        XmlBinder binder = new JAXBXmlBinder();
        return binder.marshal(body);
    }

}
