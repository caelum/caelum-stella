package br.com.caelum.stella.hibernate.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @Author Fabio Kung
 */
public class StellaCPFValidatorTest {

    @Test
    public void shouldOnlyValidateStrings() {
        StellaCPFValidator validator = new StellaCPFValidator();
        {
            boolean valid = validator.isValid(new Object());
            assertFalse(valid);
        }
        {
            boolean valid = validator.isValid(14);
            assertFalse(valid);
        }
        {
            boolean valid = validator.isValid("03118383402");
            assertTrue(valid);
        }
    }

    @Test
    public void shouldValidateNull(){
    	StellaCPFValidator validator = new StellaCPFValidator();
    	boolean valid = validator.isValid(null);
    	assertTrue(valid);
    }

    @Test
    public void shouldValidateEmpty(){
    	StellaCPFValidator validator = new StellaCPFValidator();
    	boolean valid = validator.isValid(null);
    	assertTrue(valid);
    }
}
