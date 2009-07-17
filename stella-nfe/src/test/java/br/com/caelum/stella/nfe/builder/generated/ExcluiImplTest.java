package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.TUf;

public final class ExcluiImplTest {
    @org.junit.Test
    public void testExcluiInterface() {
        Exclui<Object> exclui = new ExcluiImpl<Object>(new Object()).withUF(TUf.AC).withCNPJ(new Object());
        BuilderTestHelper.assertModelWasFilled(exclui);
    }

}