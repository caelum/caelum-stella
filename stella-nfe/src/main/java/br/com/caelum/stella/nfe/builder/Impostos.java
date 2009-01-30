package br.com.caelum.stella.nfe.builder;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.icms.ICMS;
import br.com.caelum.stella.nfe.modelo.Imposto;

public class Impostos {

    private Imposto imposto;

    public Impostos() {
        imposto = new Imposto();
    }
    
    public Impostos withIPI(IPI ipi) {
        imposto.setIPI((br.com.caelum.stella.nfe.modelo.IPI) ((ObjectCreator)ipi).getInstance());
        return this;
    }

    public Impostos withII(II ii) {
        imposto.setII((br.com.caelum.stella.nfe.modelo.II) ((ObjectCreator)ii).getInstance());
        return this;
    }

    public Impostos withPIS() {
        return this;
    }

    public Impostos withPISST() {
        return this;
    }

    public Impostos withCOFINS() {
        return this;
    }

    public Impostos withCOFINSST() {
        return this;
    }

    public Impostos withISSQN(ISS issqn) {
        imposto.setISSQN((br.com.caelum.stella.nfe.modelo.ISSQN) ((ObjectCreator)issqn).getInstance());
        return this;
    }

    public Impostos withICMS(final ICMS... icms) {
        return this;
    }

}
