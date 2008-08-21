package br.com.caelum.stella.faces.validation;

import static org.junit.Assert.assertTrue;

import javax.faces.validator.Validator;
import javax.faces.context.FacesContext;
import javax.el.ELContext;

import org.junit.Test;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.jmock.api.Imposteriser;

/**
 * @author Leonardo Bessa
 */
public class StellaIEValidatorTagTest {
    @Test
    public void shouldReturnTheStellaValidator() throws Exception {
        Mockery mockery = new Mockery();
        mockery.setImposteriser(ClassImposteriser.INSTANCE);

        final ELContext elContext = mockery.mock(ELContext.class);
        StellaIEValidatorTag tag = new StellaIEValidatorTag() {
            protected ELContext getELContext() {
                return elContext;
            }
        };

        Validator validator = tag.createValidator();
        assertTrue(validator instanceof StellaIEValidator);
    }
}
