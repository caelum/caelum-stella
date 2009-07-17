package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.builder.generated.enums.FinalidadeDaEmissao;
import br.com.caelum.stella.nfe.builder.generated.enums.FormaDeEmissao;
import br.com.caelum.stella.nfe.builder.generated.enums.FormaDePagamento;
import br.com.caelum.stella.nfe.builder.generated.enums.FormatoDeImpressao;
import br.com.caelum.stella.nfe.builder.generated.enums.ProcessoDeEmissao;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDocumentoFiscal;

public interface IdentificacaoDaNFE<T> extends NFeBuilder<T> {

    public IdentificacaoDaNFE<T> withCodigoUFDoEmitente(String string);

    public IdentificacaoDaNFE<T> withCodigoDaNF(Integer string);

    public IdentificacaoDaNFE<T> withDescricaoDaNaturezaDaOperacao(String string);

    public IdentificacaoDaNFE<T> withFormaDePagamento(FormaDePagamento string);

    public IdentificacaoDaNFE<T> withModeloDoDocumentoFiscal(String string);

    public IdentificacaoDaNFE<T> withSerie(String string);

    public IdentificacaoDaNFE<T> withNumeroDoDocumentoFiscal(String string);

    public IdentificacaoDaNFE<T> withDataDeEmissao(Calendar calendar);

    public IdentificacaoDaNFE<T> withDataDeSaidaOuEntrada(Calendar calendar);

    public IdentificacaoDaNFE<T> withTipoDoDocumentoFiscal(TipoDocumentoFiscal string);

    public IdentificacaoDaNFE<T> withCodigoDoMunicipioDeOcorrenciaDoFatoGerador(String string);

    public IdentificacaoDaNFE<T> withInformacoesDaNFReferenciada(InformacaoDaNFReferenciada<?>... nfref);

    public IdentificacaoDaNFE<T> withFormatoDeImpressao(FormatoDeImpressao string);

    public IdentificacaoDaNFE<T> withFormaDeEmissao(FormaDeEmissao string);

    public IdentificacaoDaNFE<T> withDigitoVerificadorDaChaveDeAcessoDaNFE(String string);

    public IdentificacaoDaNFE<T> withTipoDoAmbiente(TipoDoAmbiente string);

    public IdentificacaoDaNFE<T> withFinalidadeDaEmissaoDaNFE(FinalidadeDaEmissao string);

    public IdentificacaoDaNFE<T> withProcessoDeEmissao(ProcessoDeEmissao string);

    public IdentificacaoDaNFE<T> withVersaoDoAplicativoUsadoNaEmissao(String string);
}