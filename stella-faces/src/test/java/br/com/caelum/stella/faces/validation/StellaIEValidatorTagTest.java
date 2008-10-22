package br.com.caelum.stella.faces.validation;

import static org.junit.Assert.assertTrue;

import javax.el.ELContext;
import javax.faces.validator.Validator;

import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;

/**
 * @author Leonardo Bessa
 */
public class StellaIEValidatorTagTest {

    @SuppressWarnings("serial")
    @Test
    public void shouldReturnTheStellaValidator() throws Exception {
        Mockery mockery = new Mockery();
        mockery.setImposteriser(ClassImposteriser.INSTANCE);

        final ELContext elContext = mockery.mock(ELContext.class);
        StellaIEValidatorTag tag = new StellaIEValidatorTag() {
            @Override
            protected ELContext getELContext() {
                return elContext;
            }
        };

        Validator validator = tag.createValidator();
        assertTrue(validator instanceof StellaIEValidator);
    }
}
