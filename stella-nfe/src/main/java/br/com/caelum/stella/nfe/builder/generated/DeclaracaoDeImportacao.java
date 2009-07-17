package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.UF;

public interface DeclaracaoDeImportacao<T> extends NFeBuilder<T> {
    public DeclaracaoDeImportacao<T> withNumeroDoDocumentoDeImportacao(String string);

    public DeclaracaoDeImportacao<T> withDataDaDeclaracaoDeImportacao(Calendar calendar);

    public DeclaracaoDeImportacao<T> withLocalDeDesenbaraco(String string);

    public DeclaracaoDeImportacao<T> withUFDoDesembaraco(UF tUf);

    public DeclaracaoDeImportacao<T> withDataDoDeembaraco(Calendar calendar);

    public DeclaracaoDeImportacao<T> withCodigoDoExportador(String string);

    public DeclaracaoDeImportacao<T> withAdicoes(Adicao<?>... adis);
}