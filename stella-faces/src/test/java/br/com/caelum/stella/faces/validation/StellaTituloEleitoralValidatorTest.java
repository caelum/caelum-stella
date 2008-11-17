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
 */
public class StellaTituloEleitoralValidatorTest {

    private Mockery mockery;
    private FacesContextMocker facesContextMocker;
    private StellaTituloEleitoralValidator validator;

    @Before
    public void init() {
        mockery = new Mockery();
        facesContextMocker = new FacesContextMocker(mockery);
        this.validator = new StellaTituloEleitoralValidator();
    }

    @Test
    public void shouldNotThrowValidatorExceptionForValidTituloEleitoral() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", Locale.getDefault());

        validator.validate(context, component, "245770031481");
        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldGiveMessagesFromBrazilianResourceBundleForInvalidTituloEleitoralAndPtBRLocale() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", new Locale("pt", "BR"));

        try {
            validator.validate(context, component, "2457700314810");
            fail();
        } catch (ValidatorException e) {
            // it should throw exception for invalid TituloEleitoral
            FacesMessage message = e.getFacesMessage();
            assertEquals("TituloEleitoral Invalido", message.getSummary());
            mockery.assertIsSatisfied();
        }
    }

    @Test
    public void shouldGiveMessagesFromDefaultResourceBundleForInvalidTituloEleitoralAndEnUSLocale() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", new Locale("en"));

        try {
            validator.validate(context, component, "2457700314810");
            fail();
        } catch (ValidatorException e) {
            // it should throw exception for invalid TituloEleitoral
            FacesMessage message = e.getFacesMessage();
            assertEquals("Invalid TituloEleitoral", message.getSummary());
            mockery.assertIsSatisfied();
        }
    }
}
