package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public interface COFINSST {
    public COFINSST withValorDaBaseDeCalculo(BigDecimal baseDeCalculo);

    public COFINSST withAliquotaEmPercentual(BigDecimal percentual);

    public COFINSST withQuantidadeVendida(String string);

    public COFINSST withAliquota(String string);

    public COFINSST withValor(String string);
}