package br.com.caelum.stella.nfe.builder.impl;

import br.com.caelum.stella.nfe.fluid.PedidoDeAutorizacaoDaNFE;
import br.com.caelum.stella.nfe.fluid.PedidoDeConsultaDoRecidoDoLoteDeNFE;
import br.com.caelum.stella.nfe.fluid.TCancNFe;
import br.com.caelum.stella.nfe.fluid.TConsCad;
import br.com.caelum.stella.nfe.fluid.TConsSitNFe;
import br.com.caelum.stella.nfe.fluid.TConsStatServ;
import br.com.caelum.stella.nfe.fluid.TInutNFe;
import br.com.caelum.stella.nfe.fluid.TProcCancNFe;
import br.com.caelum.stella.nfe.fluid.TProcInutNFe;
import br.com.caelum.stella.nfe.ws.ConsultaCadastro;
import br.com.caelum.stella.nfe.ws.NfeCancelamentoNF;
import br.com.caelum.stella.nfe.ws.NfeConsultaNF;
import br.com.caelum.stella.nfe.ws.NfeInutilizacaoNF;
import br.com.caelum.stella.nfe.ws.NfeRecepcaoLote;
import br.com.caelum.stella.nfe.ws.NfeRetRecepcao;
import br.com.caelum.stella.nfe.ws.NfeStatusServicoNF;

/**
 * @author jonasabreu
 * 
 */
public enum NFeWebServiceType {

    // CADASTRO_EMISSOR(TCadEmiDFe.class),
    // ATUALIZACAO_EMISSOR(TAtuCadEmiDFe.class),
    ENVIO_LOTE(PedidoDeAutorizacaoDaNFE.class, NfeRecepcaoLote.class),
    CANCELAMENTO_NOTA(TCancNFe.class, NfeCancelamentoNF.class),
    CANCELAMENTO_NOTA_PROCESSADA(TProcCancNFe.class, NfeCancelamentoNF.class),
    CONSULTA_CADASTRO(TConsCad.class, ConsultaCadastro.class),
    CONSULTA_RECIBO_LOTE(PedidoDeConsultaDoRecidoDoLoteDeNFE.class, NfeRetRecepcao.class),
    CONSULTA_SITUACAO(TConsSitNFe.class, NfeConsultaNF.class),
    CONSULTA_STATUS_SERVICO(TConsStatServ.class, NfeStatusServicoNF.class),
    INUTILIZACAO_NOTA(TInutNFe.class, NfeInutilizacaoNF.class),
    INUTILIZACAO_NOTA_PROCESSADA(TProcInutNFe.class, NfeInutilizacaoNF.class);

    private final Class<?> builderType;
    private final Class<?> wsType;

    private NFeWebServiceType(final Class<?> builderType, final Class<?> wsType) {
        this.builderType = builderType;
        this.wsType = wsType;
    }

    public Class<?> getBuilderType() {
        return builderType;
    }

    public Class<?> getWebServiceModelType() {
        return wsType;
    }

}
