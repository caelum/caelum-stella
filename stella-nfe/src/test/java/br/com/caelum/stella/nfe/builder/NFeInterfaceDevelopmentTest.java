package br.com.caelum.stella.nfe.builder;

import org.junit.Test;

final public class NFeInterfaceDevelopmentTest {

    @Test
    public void test() {
        new NFe().deCancelamento()
            .withCabecalho()
                .build()
            .withDados()
                .build()
            .build();
        
        
//        new NFe().deConsulta()
//            .withCabecalho()
//                    .build()
//                .withDados()
//                    .build()
//                .build();
//        
//        new NFe().deInutilizacao();
//        new NFe().deRecepcaoLote();
//        new NFe().deRetRecepcao();
//        new NFe().deStatusServico();
    }
}
