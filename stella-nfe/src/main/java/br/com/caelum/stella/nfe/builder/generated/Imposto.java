package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.II;
import br.com.caelum.stella.nfe.builder.icms.ICMS;

public interface Imposto {
    public Imposto withICMS(ICMS iCMS);

    public Imposto withIPI(IPI iPI);

    public Imposto withII(II iI);

    public Imposto withPIS(PIS pIS);

    public Imposto withPISST(PISST pISST);

    public Imposto withCOFINS(COFINS cOFINS);

    public Imposto withCOFINSST(COFINSST cOFINSST);

    public Imposto withISSQN(ISSQN iSSQN);
}