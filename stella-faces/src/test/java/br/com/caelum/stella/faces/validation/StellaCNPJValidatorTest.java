package br.com.caelum.stella.faces.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

/**
 * StellaCPFValidator integration tests
 * 
 * @author Leonardo Bessa
 * @author Fabio Kung
 */
public class StellaCNPJValidatorTest {

    private Mockery mockery;
    private FacesContextMocker facesContextMocker;
    private StellaCNPJValidator validator;

    @Before
    public void init() {
        mockery = new Mockery();
        facesContextMocker = new FacesContextMocker(mockery);
        this.validator = new StellaCNPJValidator();
    }

    @Test
    public void shouldNotThrowValidatorExceptionForValidCNPJ() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", Locale.getDefault());

        validator.validate(context, component, "18358139000177");
        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldGiveMessagesFromBrazilianResourceBundleForInvalidCNPJAndPtBRLocale() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", new Locale("pt", "BR"));

        try {
            validator.validate(context, component, "183581390001760");
            fail();
        } catch (ValidatorException e) {
            // it should throw exception for invalid CNPJ
            FacesMessage message = e.getFacesMessage();
            assertEquals("CNPJ Invalido", message.getSummary());
            mockery.assertIsSatisfied();
        }
    }

    @Test
    public void shouldGiveMessagesFromDefaultResourceBundleForInvalidCNPJAndEnUSLocale() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", new Locale("en"));

        try {
            validator.validate(context, component, "088322120001480");
            fail();
        } catch (ValidatorException e) {
            // it should throw exception for invalid CNPJ
            FacesMessage message = e.getFacesMessage();
            assertEquals("Invalid CNPJ", message.getSummary());
            mockery.assertIsSatisfied();
        }
    }

    @Test
    public void shouldNotThrowNullPointerExceptionWhenCNPJIsNull() {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", Locale.getDefault());

        try {
            validator.validate(context, component, null);
            mockery.assertIsSatisfied();
        } catch (ValidatorException e) {
            fail("shouldn't throw exception for null cnpj");
        } catch (NullPointerException e) {
        	fail("shouldn't throw exception for null cnpj");
        }
    }

    @Test
    public void shouldNotThrowValidatorExceptionWhenCNPJIsEmpty() {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", Locale.getDefault());

        try {
            validator.validate(context, component, "");
            mockery.assertIsSatisfied();
        } catch (ValidatorException e) {
            fail("shouldn't throw exception for empty cnpj");
        }
    }
}
