package br.com.caelum.stella.nfe.xml;

import net.vidageek.mirror.dsl.Mirror;
import br.com.caelum.stella.nfe.builder.impl.NFeWebServiceType;

/**
 * @author jonasabreu
 * 
 */
final public class NFeXmlAssembler {

    private static final String HEADER = "header198snldnvni234p8pfnpRJ9PFLOjf2";
    private static final String BODY = "bodykmdsi13038s7d8f9hf27fhdcibb27HHC";
    private final NFeWebServiceType type;
    private final JAXBXmlBinder binder;

    public NFeXmlAssembler(final NFeWebServiceType type) {
        this.type = type;
        binder = new JAXBXmlBinder();
    }

    public String assembly(final Object cabecalho, final Object body) {
        Object wsModel = new Mirror().on(type.getWebServiceModelType()).invoke().constructor().withoutArgs();

        new Mirror().on(wsModel).set().field("nfeCabecMsg").withValue(HEADER);

        new Mirror().on(wsModel).set().field("nfeDadosMsg").withValue(BODY);

        String xml = binder.marshal(wsModel);
        xml = xml.replace(HEADER, binder.marshal(cabecalho));
        xml = xml.replace(BODY, binder.marshal(body));

        return xml;
    }
}
