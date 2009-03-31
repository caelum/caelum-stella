package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.generated.enums.FinalidadeDaEmissao;
import br.com.caelum.stella.nfe.builder.generated.enums.FormaDeEmissao;
import br.com.caelum.stella.nfe.builder.generated.enums.FormaDePagamento;
import br.com.caelum.stella.nfe.builder.generated.enums.FormatoDeImpressao;
import br.com.caelum.stella.nfe.builder.generated.enums.ProcessoDeEmissao;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDocumentoFiscal;

public final class IdentificacaoDaNFEImpl implements IdentificacaoDaNFE, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Ide ide;

    public IdentificacaoDaNFEImpl() {
        ide = new br.com.caelum.stella.nfe.modelo.Ide();
    }

    public br.com.caelum.stella.nfe.modelo.Ide getInstance() {
        return ide;
    }

    public IdentificacaoDaNFE withCodigoUFDoEmitente(final String string) {
        ide.setCUF(string);
        return this;
    }

    public IdentificacaoDaNFE withCodigoDaNF(final Integer string) {
        ide.setCNF(string.toString());
        return this;
    }

    public IdentificacaoDaNFE withDescricaoDaNaturezaDaOperacao(final String string) {
        ide.setNatOp(string);
        return this;
    }

    public IdentificacaoDaNFE withFormaDePagamento(final FormaDePagamento string) {
        ide.setIndPag(string.getCode());
        return this;
    }

    public IdentificacaoDaNFE withModeloDoDocumentoFiscal(final String string) {
        ide.setMod(string);
        return this;
    }

    public IdentificacaoDaNFE withSerie(final String string) {
        ide.setSerie(string);
        return this;
    }

    public IdentificacaoDaNFE withNumeroDoDocumentoFiscal(final String string) {
        ide.setNNF(string);
        return this;
    }

    public IdentificacaoDaNFE withDataDeEmissao(final Calendar calendar) {
        ide.setDEmi(calendar);
        return this;
    }

    public IdentificacaoDaNFE withDataDeSaidaOuEntrada(final Calendar calendar) {
        ide.setDSaiEnt(calendar);
        return this;
    }

    public IdentificacaoDaNFE withTipoDoDocumentoFiscal(final TipoDocumentoFiscal string) {
        ide.setTpNF(string.getCode());
        return this;
    }

    public IdentificacaoDaNFE withCodigoDoMunicipioDeOcorrenciaDoFatoGerador(final String string) {
        ide.setCMunFG(string);
        return this;
    }

    public IdentificacaoDaNFE withInformacoesDaNFReferenciada(final InformacaoDaNFReferenciada... nfref) {
        List<br.com.caelum.stella.nfe.modelo.NFref> list = new ArrayList<br.com.caelum.stella.nfe.modelo.NFref>();
        for (InformacaoDaNFReferenciada p : nfref) {
            list.add((br.com.caelum.stella.nfe.modelo.NFref) ((ObjectCreator) p).getInstance());
        }
        ide.setNFref(list);
        return this;
    }

    public IdentificacaoDaNFE withFormatoDeImpressao(final FormatoDeImpressao formato) {
        ide.setTpImp(formato.getCode());
        return this;
    }

    public IdentificacaoDaNFE withFormaDeEmissao(final FormaDeEmissao string) {
        ide.setTpEmis(string.getCode());
        return this;
    }

    public IdentificacaoDaNFE withDigitoVerificadorDaChaveDeAcessoDaNFE(final String string) {
        ide.setCDV(string);
        return this;
    }

    public IdentificacaoDaNFE withTipoDoAmbiente(final TipoDoAmbiente string) {
        ide.setTpAmb(string.getCode());
        return this;
    }

    public IdentificacaoDaNFE withFinalidadeDaEmissaoDaNFE(final FinalidadeDaEmissao string) {
        ide.setFinNFe(string.getCode());
        return this;
    }

    public IdentificacaoDaNFE withProcessoDeEmissao(final ProcessoDeEmissao string) {
        ide.setProcEmi(string.getCode());
        return this;
    }

    public IdentificacaoDaNFE withVersaoDoAplicativoUsadoNaEmissao(final String string) {
        ide.setVerProc(string);
        return this;
    }
}