package br.com.caelum.stella.faces.validation;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.jmock.Mockery;

/**
 * @author Fabio Kung
 */
public class ResourceBundleFinderTest {
    private Mockery mockery;

    @Before
    public void mockery() {
        mockery = new Mockery();
        new FacesContextMocker(mockery);
    }

    @Test
    public void deveRetornarMessageBundleDoFacesConfigSeExistir() {
        fail("pendente");
    }

    @Test
    public void deveRetornarMessageBundleDoStellaCasoNaoExistaNoFacesConfig() {
        fail("pendente");
    }
}
