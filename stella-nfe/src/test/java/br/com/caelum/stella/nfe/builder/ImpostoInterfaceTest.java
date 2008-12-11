package br.com.caelum.stella.nfe.builder;

import org.junit.Test;

public class ImpostoInterfaceTest {

    @Test
    public void testaInterfaceDeImpostos() {

        new Impostos()
                .addICMS(null)
                .addIPI()
                .addII()
                .addPIS()
                .addPISST()
                .addCOFINS()
                .addCOFINSST()
                .addISSQN();

    }
    
    @Test
    public void testaInterfaceDoICMS() {
        new ICMS();
    }

}
