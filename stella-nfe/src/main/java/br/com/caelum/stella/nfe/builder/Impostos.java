package br.com.caelum.stella.nfe.builder;

import java.lang.reflect.Field;

import net.vidageek.fluid.proxy.ObjectCreator;
import net.vidageek.mirror.Mirror;
import br.com.caelum.stella.nfe.builder.icms.ICMS;
import br.com.caelum.stella.nfe.modelo.Imposto;

public class Impostos {

    private final Imposto imposto;

    public Impostos() {
        imposto = new Imposto();
    }

    public Impostos withIPI(final IPI<?> ipi) {
        imposto.setIPI((br.com.caelum.stella.nfe.modelo.IPI) ((ObjectCreator) ipi).getInstance());
        return this;
    }

    public Impostos withII(final II ii) {
        imposto.setII((br.com.caelum.stella.nfe.modelo.II) ((ObjectCreator) ii).getInstance());
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

    public Impostos withISSQN(final ISS<?> issqn) {
        imposto.setISSQN((br.com.caelum.stella.nfe.modelo.ISSQN) ((ObjectCreator) issqn).getInstance());
        return this;
    }

    public Impostos withICMS(final ICMS... icms) {
        br.com.caelum.stella.nfe.modelo.ICMS modelICMS = new br.com.caelum.stella.nfe.modelo.ICMS();
        for (ICMS i : icms) {
            Object instance = ((ObjectCreator) i).getInstance();
            for (Field f : Mirror.on(br.com.caelum.stella.nfe.modelo.ICMS.class).reflectAll().fields()) {
                if (instance.getClass().equals(f.getType())) {
                    Mirror.on(modelICMS).set().field(f).withValue(instance);
                }
            }
        }
        imposto.setICMS(modelICMS);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) imposto;
    }

}
