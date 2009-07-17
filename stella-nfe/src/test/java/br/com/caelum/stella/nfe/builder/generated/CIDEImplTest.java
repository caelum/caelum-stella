package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class CIDEImplTest {
    @org.junit.Test
    public void testCIDEInterface() {
        CIDESobreCombustiveis<Object> cIDE = new CIDESobreCombustiveisImpl<Object>(new Object()).withBaseDeCalculo(
                new BigDecimal("1")).withAliquota(new BigDecimal("1")).withValor(new BigDecimal("1"));
        BuilderTestHelper.assertModelWasFilled(cIDE);
    }

}