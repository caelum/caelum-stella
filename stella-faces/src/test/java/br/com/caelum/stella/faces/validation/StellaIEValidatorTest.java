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

import br.com.caelum.stella.type.Estado;

/**
 * StellaIEValidator integration tests
 *
 * @author Leonardo Bessa
 */
public class StellaIEValidatorTest {

    private Mockery mockery;
    private StellaIEValidator validator;
    private FacesContextMocker facesContextMocker;

    @Before
    public void iIE() {
        mockery = new Mockery();
        facesContextMocker = new FacesContextMocker(mockery);
        this.validator = new StellaIEValidator();
    }

    @Test
    public void shouldNotThrowValidatorExceptionForValidIE() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", Locale.getDefault());
        validator.setEstado(Estado.SP);
        validator.validate(context, component, "P011004243002");
        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldGiveMessagesFromBrazilianResourceBundleForInvalidIEAndPtBRLocale() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", new Locale("pt", "BR"));

        try {
            validator.setEstado(Estado.SP);
            validator.validate(context, component, "P011004245002");
            fail();
        } catch (ValidatorException e) {
            // it should throw exception for invalid IE
            FacesMessage message = e.getFacesMessage();
            assertEquals("IE Invalido", message.getSummary());
            mockery.assertIsSatisfied();
        }
    }


    @Test
    public void shouldGiveMessagesFromDefaultResourceBundleForInvalidIEAndEnUSLocale() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", new Locale("en"));

        try {
            validator.setEstado(Estado.SP);
            validator.validate(context, component, "P011004245002");
            fail();
        } catch (ValidatorException e) {
            // it should throw exception for invalid IE
            FacesMessage message = e.getFacesMessage();
            assertEquals("Invalid IE", message.getSummary());
            mockery.assertIsSatisfied();
        }
    }

}
