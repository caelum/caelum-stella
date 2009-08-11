package br.com.caelum.stella.nfe.builder;

import net.vidageek.fluid.proxy.ObjectCreator;
import br.com.caelum.stella.nfe.builder.impl.NFeDeCancelamentoImpl;
import br.com.caelum.stella.nfe.builder.impl.NFeDeConsultaImpl;
import br.com.caelum.stella.nfe.builder.impl.NFeDeInutilizacaoImpl;
import br.com.caelum.stella.nfe.builder.impl.NFeWebServiceType;
import br.com.caelum.stella.nfe.builder.impl.NFeWebServiceWrapperFactory;
import br.com.caelum.stella.nfe.builder.impl.NFeWebServiceWrapperImpl;
import br.com.caelum.stella.nfe.fluid.PedidoDeAutorizacaoDaNFE;
import br.com.caelum.stella.nfe.fluid.TAtuCadEmiDFe;
import br.com.caelum.stella.nfe.fluid.TCadEmiDFe;

final public class NFe {

    private ObjectCreator creator;

    public NFeDeConsulta<NFe> deConsulta() {
        NFeDeConsultaImpl creator = new NFeDeConsultaImpl(this);
        this.creator = creator;
        return creator;
    }

    public NFeWebServiceWrapper<TCadEmiDFe<NFe>> deCadastroDeEmissor() {
        throw new RuntimeException("There is no web service registered for this kind of NFe");
        // creator = new
        // NFeWebServiceWrapperFactory().createWrapper(NFeWebServiceType.CADASTRO_EMISSOR,
        // this);
        // return (NFeWebServiceWrapper<TCadEmiDFe<NFe>>) creator;
    }

    public NFeDeCancelamento<NFe> deCancelamento() {
        NFeDeCancelamentoImpl creator = new NFeDeCancelamentoImpl(this);
        this.creator = creator;
        return creator;
    }

    public NFeWebServiceWrapper<TAtuCadEmiDFe<NFe>> deAtualizacaoDeEmissor() {
        throw new RuntimeException("There is no web service registered for this kind of NFe");
        // creator = new
        // NFeWebServiceWrapperFactory().createWrapper(NFeWebServiceType.ATUALIZACAO_EMISSOR,
        // this);
        // return (NFeWebServiceWrapper<TAtuCadEmiDFe<NFe>>) creator;
    }

    public NFeDeInutilizacao<NFe> deInutilizacao() {
        NFeDeInutilizacaoImpl creator = new NFeDeInutilizacaoImpl(this);
        this.creator = creator;
        return creator;
    }

    public NFeWebServiceWrapper<PedidoDeAutorizacaoDaNFE<NFe>> deEnvioDeLote() {
        creator = new NFeWebServiceWrapperFactory().createWrapper(NFeWebServiceType.ENVIO_LOTE, this);
        return (NFeWebServiceWrapper<PedidoDeAutorizacaoDaNFE<NFe>>) creator;
    }

    public void send() {// TODO deve receber o estado

    }

    public void send(final String webServiceUrl) {
        NFeWebServiceWrapper wrapper = (NFeWebServiceWrapper) creator.getInstance();
    }

    public static void main(final String[] args) {
        NFe nfe = new NFe().deCancelamento().deNota().withCabecalho().withVersao("versao").withVersaoDados(
                "versão dados").build().withCorpo().withInfCanc().withId("id infcad").build().build();

        NFeWebServiceWrapperImpl wrapper = (NFeWebServiceWrapperImpl) nfe.creator.getInstance();
        System.out.println(wrapper.getXml());

    }

}
