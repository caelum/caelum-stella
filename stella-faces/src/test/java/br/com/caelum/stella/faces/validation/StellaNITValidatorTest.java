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
 * StellaNITValidator integration tests
 * 
 * @author Leonardo Bessa
 * @author Fabio Kung
 */
public class StellaNITValidatorTest {

    private Mockery mockery;
    private StellaNITValidator validator;
    private FacesContextMocker facesContextMocker;

    @Before
    public void init() {
        mockery = new Mockery();
        facesContextMocker = new FacesContextMocker(mockery);
        this.validator = new StellaNITValidator();
    }

    @Test
    public void shouldNotThrowValidatorExceptionForValidNIT() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", Locale.getDefault());

        validator.validate(context, component, "34608514300");
        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldGiveMessagesFromBrazilianResourceBundleForInvalidNITAndPtBRLocale() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", new Locale("pt", "BR"));

        try {
            validator.validate(context, component, "1234567765");
            fail();
        } catch (ValidatorException e) {
            // it should throw exception for invalid NIT
            FacesMessage message = e.getFacesMessage();
            assertEquals("NIT Invalido", message.getSummary());
            mockery.assertIsSatisfied();
        }
    }

    @Test
    public void shouldGiveMessagesFromDefaultResourceBundleForInvalidNITAndEnUSLocale() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", new Locale("en"));

        try {
            validator.validate(context, component, "1234567765");
            fail();
        } catch (ValidatorException e) {
            // it should throw exception for invalid NIT
            FacesMessage message = e.getFacesMessage();
            assertEquals("Invalid NIT", message.getSummary());
            mockery.assertIsSatisfied();
        }
    }

}
