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

public final class IdentificacaoDaNFEImpl<T> implements IdentificacaoDaNFE<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Ide ide;
    private final T parent;

    public IdentificacaoDaNFEImpl(final T parent) {
        this.parent = parent;
        ide = new br.com.caelum.stella.nfe.modelo.Ide();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.ide;
    }

    public IdentificacaoDaNFE<T> withCodigoUFDoEmitente(final String string) {
        ide.setCUF(string);
        return this;
    }

    public IdentificacaoDaNFE<T> withCodigoDaNF(final Integer string) {
        ide.setCNF(string.toString());
        return this;
    }

    public IdentificacaoDaNFE<T> withDescricaoDaNaturezaDaOperacao(final String string) {
        ide.setNatOp(string);
        return this;
    }

    public IdentificacaoDaNFE<T> withFormaDePagamento(final FormaDePagamento string) {
        ide.setIndPag(string.getCode());
        return this;
    }

    public IdentificacaoDaNFE<T> withModeloDoDocumentoFiscal(final String string) {
        ide.setMod(string);
        return this;
    }

    public IdentificacaoDaNFE<T> withSerie(final String string) {
        ide.setSerie(string);
        return this;
    }

    public IdentificacaoDaNFE<T> withNumeroDoDocumentoFiscal(final String string) {
        ide.setNNF(string);
        return this;
    }

    public IdentificacaoDaNFE<T> withDataDeEmissao(final Calendar calendar) {
        ide.setDEmi(calendar);
        return this;
    }

    public IdentificacaoDaNFE<T> withDataDeSaidaOuEntrada(final Calendar calendar) {
        ide.setDSaiEnt(calendar);
        return this;
    }

    public IdentificacaoDaNFE<T> withTipoDoDocumentoFiscal(final TipoDocumentoFiscal string) {
        ide.setTpNF(string.getCode());
        return this;
    }

    public IdentificacaoDaNFE<T> withCodigoDoMunicipioDeOcorrenciaDoFatoGerador(final String string) {
        ide.setCMunFG(string);
        return this;
    }

    public IdentificacaoDaNFE<T> withInformacoesDaNFReferenciada(final InformacaoDaNFReferenciada<?>... nfref) {
        List<br.com.caelum.stella.nfe.modelo.NFref> list = new ArrayList<br.com.caelum.stella.nfe.modelo.NFref>();
        for (InformacaoDaNFReferenciada<?> p : nfref) {
            list.add((br.com.caelum.stella.nfe.modelo.NFref) ((ObjectCreator) p).getInstance());
        }
        ide.setNFref(list);
        return this;
    }

    public IdentificacaoDaNFE<T> withFormatoDeImpressao(final FormatoDeImpressao formato) {
        ide.setTpImp(formato.getCode());
        return this;
    }

    public IdentificacaoDaNFE<T> withFormaDeEmissao(final FormaDeEmissao string) {
        ide.setTpEmis(string.getCode());
        return this;
    }

    public IdentificacaoDaNFE<T> withDigitoVerificadorDaChaveDeAcessoDaNFE(final String string) {
        ide.setCDV(string);
        return this;
    }

    public IdentificacaoDaNFE<T> withTipoDoAmbiente(final TipoDoAmbiente string) {
        ide.setTpAmb(string.getCode());
        return this;
    }

    public IdentificacaoDaNFE<T> withFinalidadeDaEmissaoDaNFE(final FinalidadeDaEmissao string) {
        ide.setFinNFe(string.getCode());
        return this;
    }

    public IdentificacaoDaNFE<T> withProcessoDeEmissao(final ProcessoDeEmissao string) {
        ide.setProcEmi(string.getCode());
        return this;
    }

    public IdentificacaoDaNFE<T> withVersaoDoAplicativoUsadoNaEmissao(final String string) {
        ide.setVerProc(string);
        return this;
    }
}