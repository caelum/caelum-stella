package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class DupImplTest {
    @org.junit.Test
    public void testDupInterface() {
        Duplicata<Object> dup = new DuplicataImpl<Object>(new Object()).withNumero("abc").withDataDeVencimento(
                Calendar.getInstance()).withValorDaDuplicata("abc");
        BuilderTestHelper.assertModelWasFilled(dup);
    }

}