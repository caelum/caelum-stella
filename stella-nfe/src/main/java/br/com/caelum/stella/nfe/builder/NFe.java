package br.com.caelum.stella.nfe.builder;

import java.io.InputStream;
import java.io.OutputStream;

import net.vidageek.fluid.proxy.ObjectCreator;
import br.com.caelum.stella.nfe.builder.impl.NFeDeCancelamentoImpl;
import br.com.caelum.stella.nfe.builder.impl.NFeDeConsultaImpl;
import br.com.caelum.stella.nfe.builder.impl.NFeDeInutilizacaoImpl;
import br.com.caelum.stella.nfe.fluid.PedidoDeAutorizacaoDaNFE;
import br.com.caelum.stella.nfe.fluid.TAtuCadEmiDFe;
import br.com.caelum.stella.nfe.fluid.TCadEmiDFe;
import br.com.caelum.stella.nfe.proxy.NFeProxyFactory;

final public class NFe {

    private ObjectCreator creator;

    public NFeDeConsulta<NFe> deConsulta() {
        NFeDeConsultaImpl creator = new NFeDeConsultaImpl(this);
        this.creator = creator;
        return creator;
    }

    public TCadEmiDFe<NFe> deCadastroDeEmissor() {
        TCadEmiDFe<NFe> creator = new NFeProxyFactory().createProxyFor(TCadEmiDFe.class);
        this.creator = (ObjectCreator) creator;
        return creator;
    }

    public NFeDeCancelamento<NFe> deCancelamento() {
        NFeDeCancelamentoImpl creator = new NFeDeCancelamentoImpl(this);
        this.creator = creator;
        return creator;
    }

    public TAtuCadEmiDFe<NFe> deAtualizacaoDeEmissor() {
        TAtuCadEmiDFe<NFe> creator = new NFeProxyFactory().createProxyFor(TAtuCadEmiDFe.class);
        this.creator = (ObjectCreator) creator;
        return creator;
    }

    public NFeDeInutilizacao<NFe> deInutilizacao() {
        NFeDeInutilizacaoImpl creator = new NFeDeInutilizacaoImpl(this);
        this.creator = creator;
        return creator;
    }

    public PedidoDeAutorizacaoDaNFE<NFe> deEnvioDeLote() {
        PedidoDeAutorizacaoDaNFE<NFe> creator = new NFeProxyFactory().createProxyFor(PedidoDeAutorizacaoDaNFE.class);
        this.creator = (ObjectCreator) creator;
        return creator;
    }

    public NFe from(final InputStream stream) {
        return null;
    }

    public void to(final OutputStream stream) {
    }

    public void send() {// deve receber o estado

    }

    public void send(final String webServiceUrl) {

    }

}
