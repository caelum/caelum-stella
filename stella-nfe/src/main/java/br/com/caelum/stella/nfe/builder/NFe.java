package br.com.caelum.stella.nfe.builder;

import br.com.caelum.stella.nfe.fluid.PedidoDeAutorizacaoDaNFE;
import br.com.caelum.stella.nfe.fluid.TAtuCadEmiDFe;
import br.com.caelum.stella.nfe.fluid.TCadEmiDFe;

final public class NFe {

    public NFeDeConsulta<NFe> deConsulta() {
        return null;
    }

    public TCadEmiDFe<NFe> deCadastroDeEmissor() {
        return null;
    }

    public NFeDeCancelamento<NFe> deCancelamento() {
        return null;
    }

    public TAtuCadEmiDFe<NFe> deAtualizacaoDeEmissor() {
        return null;
    }

    public NFeDeInutilizacao<NFe> deInutilizacao() {
        return null;
    }

    public PedidoDeAutorizacaoDaNFE<NFe> deEnvioDeLote() {
        return null;
    }

}
