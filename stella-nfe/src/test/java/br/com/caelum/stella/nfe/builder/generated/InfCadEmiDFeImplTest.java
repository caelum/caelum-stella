package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class InfCadEmiDFeImplTest {

    @Test
    public void testInfCadEmiDFeInterface() {
        InfCadEmiDFe<Object> infCadEmiDFe = new InfCadEmiDFeImpl<Object>(new Object()).withDPubCad(
                Calendar.getInstance()).withEmissor(new ArrayList<TEmissor<?>>()).withId("abc");
        BuilderTestHelper.assertModelWasFilled(infCadEmiDFe);
    }

}