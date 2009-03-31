package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.modelo.UF;

public interface DeclaracaoDeImportacao {
    public DeclaracaoDeImportacao withNumeroDoDocumentoDeImportacao(String string);

    public DeclaracaoDeImportacao withDataDaDeclaracaoDeImportacao(Calendar calendar);

    public DeclaracaoDeImportacao withLocalDeDesenbaraco(String string);

    public DeclaracaoDeImportacao withUFDoDesembaraco(UF tUf);

    public DeclaracaoDeImportacao withDataDoDeembaraco(Calendar calendar);

    public DeclaracaoDeImportacao withCodigoDoExportador(String string);

    public DeclaracaoDeImportacao withAdicoes(Adicao... adis);
}