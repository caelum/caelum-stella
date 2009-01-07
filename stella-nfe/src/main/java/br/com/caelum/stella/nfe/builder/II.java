package br.com.caelum.stella.nfe.builder;

import java.math.BigDecimal;

public interface II {

    II withValorBaseCalculo(BigDecimal valorBaseCalculo);

    II withValorAduaneira(BigDecimal valorAduaneira);

    II withValorImpostoImportacao(BigDecimal valorII);

    II withValorImpostoSobreOperacoesFinanceiras(BigDecimal valorIOF);
    
}
