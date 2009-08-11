package br.com.caelum.stella.nfe.fluid;

import junit.framework.Assert;
import net.vidageek.fluid.proxy.ObjectCreator;
import net.vidageek.mirror.dsl.Mirror;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import br.com.caelum.stella.nfe.builder.NFe;
import br.com.caelum.stella.nfe.builder.impl.NFeWebServiceWrapperImpl;

/**
 * @author jonasabreu
 * 
 */
@RunWith(Theories.class)
final public class GetInstanceReturnsNFeWebServiceWrapperImplTest {

    @DataPoint public NFe cancelamentoDeNota = new NFe().deCancelamento().deNota().withCabecalho().build().withCorpo().build();
    
    @DataPoint public NFe cancelamentoDeNotaProcessada = new NFe().deCancelamento().deNotaProcessada().withCabecalho().build().withCorpo().build();
    
    @DataPoint public NFe atualizacaoDeEmissor = new NFe().deAtualizacaoDeEmissor().withCabecalho().build().withCorpo().build();
    
    @DataPoint public NFe cadastroDeEmissor = new NFe().deCadastroDeEmissor().withCabecalho().build().withCorpo().build();
    
    @DataPoint public NFe consultaDeCadastro = new NFe().deConsulta().deCadastro().withCabecalho().build().withCorpo().build();
    
    @DataPoint public NFe consultaDeRecibo = new NFe().deConsulta().deRecibo().withCabecalho().build().withCorpo().build();
    
    @DataPoint public NFe consultaDeSituacao = new NFe().deConsulta().deSituacao().withCabecalho().build().withCorpo().build();
    
    @DataPoint public NFe consultaDeStatusDeServico = new NFe().deConsulta().deStatusDeServico().withCabecalho().build().withCorpo().build();
    
    @DataPoint public NFe envioDeLote = new NFe().deEnvioDeLote().withCabecalho().build().withCorpo().build();
    
    @DataPoint public NFe inutilizacaodeNota = new NFe().deInutilizacao().deNota().withCabecalho().build().withCorpo().build();
    
    @DataPoint public NFe inutilizacaoDeNoteProcessada = new NFe().deInutilizacao().deNotaProcessada().withCabecalho().build().withCorpo().build();
    
    @Theory
    public void testNFe(NFe nfe) {
        ObjectCreator creator = (ObjectCreator) new Mirror().on(nfe).get().field("creator");
        Assert.assertEquals(NFeWebServiceWrapperImpl.class, creator.getInstance().getClass());        
    }
    
}
