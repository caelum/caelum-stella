package br.com.caelum.stella.nfe.builder.impl;

import net.vidageek.fluid.proxy.ObjectCreator;
import br.com.caelum.stella.nfe.builder.NFeWebServiceWrapper;
import br.com.caelum.stella.nfe.fluid.Cabecalho;
import br.com.caelum.stella.nfe.xml.NFeXmlAssembler;

/**
 * @author jonasabreu
 * 
 */
final public class NFeWebServiceWrapperImpl<T> implements NFeWebServiceWrapper<T>, ObjectCreator {

    private Cabecalho<NFeWebServiceWrapper<T>> cabecalho;
    private final T body;
    private final NFeWebServiceType wsType;

    public NFeWebServiceWrapperImpl(final NFeWebServiceType wsType, final T body) {
        this.wsType = wsType;
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
        return new NFeXmlAssembler(wsType).assembly(((ObjectCreator) cabecalho).getInstance(), ((ObjectCreator) body)
            .getInstance());
    }
}
