
package br.com.caelum.stella.nfe.ws;

import javax.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory {


    public ConsultaCadastro createConsultaCadastro() {
        return new ConsultaCadastro();
    }
    public NfeConsultaNF createNfeConsultaNF() {
        return new NfeConsultaNF();
    }

    public NfeRecepcaoLote createNfeRecepcaoLote() {
        return new NfeRecepcaoLote();
    }

    public NfeInutilizacaoNFResponse createNfeInutilizacaoNFResponse() {
        return new NfeInutilizacaoNFResponse();
    }

    public ConsultaCadastroResponse createConsultaCadastroResponse() {
        return new ConsultaCadastroResponse();
    }

    public NfeInutilizacaoNF createNfeInutilizacaoNF() {
        return new NfeInutilizacaoNF();
    }

    public NfeConsultaNFResponse createNfeConsultaNFResponse() {
        return new NfeConsultaNFResponse();
    }

    public NfeStatusServicoNFResponse createNfeStatusServicoNFResponse() {
        return new NfeStatusServicoNFResponse();
    }

    public NfeCancelamentoNF createNfeCancelamentoNF() {
        return new NfeCancelamentoNF();
    }

    public NfeCancelamentoNFResponse createNfeCancelamentoNFResponse() {
        return new NfeCancelamentoNFResponse();
    }

    public NfeRetRecepcao createNfeRetRecepcao() {
        return new NfeRetRecepcao();
    }

    public NfeStatusServicoNF createNfeStatusServicoNF() {
        return new NfeStatusServicoNF();
    }

    public NfeRetRecepcaoResponse createNfeRetRecepcaoResponse() {
        return new NfeRetRecepcaoResponse();
    }

    public NfeRecepcaoLoteResponse createNfeRecepcaoLoteResponse() {
        return new NfeRecepcaoLoteResponse();
    }

}
