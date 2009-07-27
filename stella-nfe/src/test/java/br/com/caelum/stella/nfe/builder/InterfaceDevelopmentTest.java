package br.com.caelum.stella.nfe.builder;

import org.junit.Test;

/**
 * @author jonasabreu
 * 
 */
final public class InterfaceDevelopmentTest {

    @Test
    public void testInterfaceDeConsultaDeSituacao() {
        new NFe().deConsulta().deSituacao();
    }

    @Test
    public void testInterfaceDeConsultaDeServico() {
        new NFe().deConsulta().deStatusDeServico();
    }

    @Test
    public void testInterfaceDeConsultaDeRecibo() {
        new NFe().deConsulta().deRecibo();
    }

    @Test
    public void testInterfaceDeConsultaDeCadastro() {
        new NFe().deConsulta().deCadastro();
    }

    @Test
    public void testInterfaceDeCadastroDeEmissor() {
        new NFe().deCadastroDeEmissor();
    }

    @Test
    public void testInterfaceDeCancelamento() {
        new NFe().deCancelamento().deNotaProcessada();
        new NFe().deCancelamento().deNota();
    }

    @Test
    public void testInterfaceDeAtualizacao() {
        new NFe().deAtualizacaoDeEmissor();
    }

    @Test
    public void testInterfaceDeInutilizacao() {
        new NFe().deInutilizacao().deNotaProcessada();
        new NFe().deInutilizacao().deNota();
    }
}
