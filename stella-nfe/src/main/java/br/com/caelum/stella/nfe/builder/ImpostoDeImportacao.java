package br.com.caelum.stella.nfe.builder;

import java.math.BigDecimal;

public class ImpostoDeImportacao {

    private ImpostoDeImportacao() {
    }

    public static ImpostoDeImportacao create() {
        // TODO Auto-generated method stub
        return new ImpostoDeImportacao();
    }

    public ImpostoDeImportacao withBaseDeCalculo(BigDecimal baseDeCalulo) {
        // TODO Auto-generated method stub
        return this;
    }

    public ImpostoDeImportacao withDespesasAduaneiras(BigDecimal despesasAduaneiras) {
        // TODO Auto-generated method stub
        return this;
    }

    public ImpostoDeImportacao withValor(BigDecimal valor) {
        // TODO Auto-generated method stub
        return this;
    }

    public ImpostoDeImportacao withValorDoIOF(BigDecimal iof) {
        // TODO Auto-generated method stub
        return this;
    }

}
