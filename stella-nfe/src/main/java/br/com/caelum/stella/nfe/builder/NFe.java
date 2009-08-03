package br.com.caelum.stella.nfe.builder;

import net.vidageek.fluid.proxy.ObjectCreator;
import br.com.caelum.stella.nfe.builder.impl.NFeDeCancelamentoImpl;
import br.com.caelum.stella.nfe.builder.impl.NFeDeConsultaImpl;
import br.com.caelum.stella.nfe.builder.impl.NFeDeInutilizacaoImpl;
import br.com.caelum.stella.nfe.builder.impl.NFeWebServiceWrapperFactory;
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
        creator = new NFeWebServiceWrapperFactory().createWrapper(TCadEmiDFe.class);
        return (NFeWebServiceWrapper<TCadEmiDFe<NFe>>) creator;
    }

    public NFeDeCancelamento<NFe> deCancelamento() {
        NFeDeCancelamentoImpl creator = new NFeDeCancelamentoImpl(this);
        this.creator = creator;
        return creator;
    }

    public NFeWebServiceWrapper<TAtuCadEmiDFe<NFe>> deAtualizacaoDeEmissor() {
        creator = new NFeWebServiceWrapperFactory().createWrapper(TAtuCadEmiDFe.class);
        return (NFeWebServiceWrapper<TAtuCadEmiDFe<NFe>>) creator;
    }

    public NFeDeInutilizacao<NFe> deInutilizacao() {
        NFeDeInutilizacaoImpl creator = new NFeDeInutilizacaoImpl(this);
        this.creator = creator;
        return creator;
    }

    public NFeWebServiceWrapper<PedidoDeAutorizacaoDaNFE<NFe>> deEnvioDeLote() {
        creator = new NFeWebServiceWrapperFactory().createWrapper(PedidoDeAutorizacaoDaNFE.class);
        return (NFeWebServiceWrapper<PedidoDeAutorizacaoDaNFE<NFe>>) creator;
    }

    public void send() {// TODO deve receber o estado

    }

    public void send(final String webServiceUrl) {
        NFeWebServiceWrapper wrapper = (NFeWebServiceWrapper) creator.getInstance();
    }

}
