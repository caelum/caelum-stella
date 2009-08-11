package br.com.caelum.stella.nfe.builder;

import org.junit.Test;

/**
 * @author jonasabreu
 * 
 */
final public class InterfaceDevelopmentTest {

    @Test
    public void testInterfaceForCancelamento() {
        NFe nfe = new NFe().deCancelamento().deNota()
                .withCabecalho()
                    .withVersao("")
                    .build()
                .withCorpo()
                    .withInfCanc()
                        .withChNFe("")
                        .build()
                    .build();
    }
    
    @Test
    public void testInterfaceForCancelamentoDeNotaProcessada() {
        NFe nfe = new NFe().deCancelamento().deNotaProcessada()
                .withCabecalho()
                    .withVersao("")
                    .build()
                .withCorpo()
                    .withCancNFe()
                        .withInfCanc()
                            .build()
                        .build()
                    .build();
    }
    
    @Test(expected=RuntimeException.class)
    public void testInterfaceForAtualizacaoDeEmissor() {
        NFe nfe = new NFe().deAtualizacaoDeEmissor()
                .withCabecalho()
                    .withVersao("")
                    .build()
                .withCorpo()
                    .withInfAtuCadEmiDFe()
                        .build()
                    .build();
    }
    
    @Test(expected=RuntimeException.class)
    public void testInterfaceForCadastroDeEmissor() {
        NFe nfe = new NFe().deCadastroDeEmissor()
                .withCabecalho()
                    .withVersao("")
                    .build()
                .withCorpo()
                    .withInfCadEmiDFe()
                        .build()
                    .build();
    }
    
    @Test
    public void testInterfaceForConsultaDeCadastro() {
        NFe nfe = new NFe().deConsulta().deCadastro()
                .withCabecalho()
                    .withVersao("")
                    .build()
                .withCorpo()
                    .withInfCons()
                        .build()
                    .build();
    }
    
    @Test
    public void testInterfaceForConsultaDeRecibo() {
        NFe nfe = new NFe().deConsulta().deRecibo()
                .withCabecalho()
                    .withVersao("")
                    .build()
                .withCorpo()
                    .withNumeroDoRecibo("")
                    .build();
    }
    
    @Test
    public void testInterfaceForConsultaDeSituacao() {
        NFe nfe = new NFe().deConsulta().deSituacao()
                .withCabecalho()
                    .withVersao("")
                    .build()
                .withCorpo()
                    .withTpAmb("")
                    .build();
    }
    
    @Test
    public void testInterfaceForConsultaDeStatusDeServico() {
        NFe nfe = new NFe().deConsulta().deStatusDeServico()
                .withCabecalho()
                    .withVersao("")
                    .build()
                .withCorpo()
                    .withTpAmb("")
                    .build();
    }
    
    @Test
    public void testInterfaceForEnvioDeLote() {
        NFe nfe = new NFe().deEnvioDeLote()
                .withCabecalho()
                    .withVersao("")
                    .build()
                .withCorpo()
                    .withIdDoLote("")
                    .build();
    }
    
    @Test
    public void testInterfaceForInutilizacaoDeNota() {
        NFe nfe = new NFe().deInutilizacao().deNota()
                .withCabecalho()
                    .withVersao("")
                    .build()
                .withCorpo()
                    .withInfInut()
                        .build()
                    .build();
    }
    
    @Test
    public void testInterfaceForInutilizacaoDeNotaProcessada() {
        NFe nfe = new NFe().deInutilizacao().deNotaProcessada()
                .withCabecalho()
                    .withVersao("")
                    .build()
                .withCorpo()
                    .withInutNFe()
                        .build()
                    .build();
    }
}
