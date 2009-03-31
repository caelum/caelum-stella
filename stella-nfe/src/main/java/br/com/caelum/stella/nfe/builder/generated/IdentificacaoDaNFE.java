package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.generated.enums.FinalidadeDaEmissao;
import br.com.caelum.stella.nfe.builder.generated.enums.FormaDeEmissao;
import br.com.caelum.stella.nfe.builder.generated.enums.FormaDePagamento;
import br.com.caelum.stella.nfe.builder.generated.enums.FormatoDeImpressao;
import br.com.caelum.stella.nfe.builder.generated.enums.ProcessoDeEmissao;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDocumentoFiscal;

public interface IdentificacaoDaNFE {

    public IdentificacaoDaNFE withCodigoUFDoEmitente(String string);

    public IdentificacaoDaNFE withCodigoDaNF(Integer string);

    public IdentificacaoDaNFE withDescricaoDaNaturezaDaOperacao(String string);

    public IdentificacaoDaNFE withFormaDePagamento(FormaDePagamento string);

    public IdentificacaoDaNFE withModeloDoDocumentoFiscal(String string);

    public IdentificacaoDaNFE withSerie(String string);

    public IdentificacaoDaNFE withNumeroDoDocumentoFiscal(String string);

    public IdentificacaoDaNFE withDataDeEmissao(Calendar calendar);

    public IdentificacaoDaNFE withDataDeSaidaOuEntrada(Calendar calendar);

    public IdentificacaoDaNFE withTipoDoDocumentoFiscal(TipoDocumentoFiscal string);

    public IdentificacaoDaNFE withCodigoDoMunicipioDeOcorrenciaDoFatoGerador(String string);

    public IdentificacaoDaNFE withInformacoesDaNFReferenciada(InformacaoDaNFReferenciada... nfref);

    public IdentificacaoDaNFE withFormatoDeImpressao(FormatoDeImpressao string);

    public IdentificacaoDaNFE withFormaDeEmissao(FormaDeEmissao string);

    public IdentificacaoDaNFE withDigitoVerificadorDaChaveDeAcessoDaNFE(String string);

    public IdentificacaoDaNFE withTipoDoAmbiente(TipoDoAmbiente string);

    public IdentificacaoDaNFE withFinalidadeDaEmissaoDaNFE(FinalidadeDaEmissao string);

    public IdentificacaoDaNFE withProcessoDeEmissao(ProcessoDeEmissao string);

    public IdentificacaoDaNFE withVersaoDoAplicativoUsadoNaEmissao(String string);
}