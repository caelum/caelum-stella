package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public interface ISSQN {
    public ISSQN withValorDaBaseDeCalculo(BigDecimal baseDeCalculo);

    public ISSQN withAliquota(String string);

    public ISSQN withValorISSQN(String string);

    public ISSQN withCodigoMunicipio(String string);

    public ISSQN withCodigoListaServicos(String string);
}