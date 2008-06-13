package br.com.caelum.stella.faces.validation;

import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.util.Locale;

/**
 * StellaCPFValidator integration tests
 *
 * @author Fabio Kung
 */
public class StellaCPFValidatorTest {

    private Mockery mockery;
    private StellaCPFValidator validator;
    private FacesContextMocker facesContextMocker;

    @Before
    public void init() {
        mockery = new Mockery();
        mockery.setImposteriser(ClassImposteriser.INSTANCE);
        facesContextMocker = new FacesContextMocker(mockery);
        this.validator = new StellaCPFValidator();
    }

    @Test
    public void shouldNotThrowValidatorExceptionForValidCPF() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", Locale.getDefault());

        validator.validate(context, component, "75885366160");
        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldGiveMessagesFromBrazilianResourceBundleForInvalidCpfAndPtBRLocale() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", new Locale("pt", "BR"));

        try {
            validator.validate(context, component, "1234567765");
            fail();
        } catch (ValidatorException e) {
            // it should throw exception for invalid cpf
            FacesMessage message = e.getFacesMessage();
            assertEquals("CPF Invalido", message.getSummary());
            mockery.assertIsSatisfied();
        }
    }


    @Test
    public void shouldGiveMessagesFromDefaultResourceBundleForInvalidCpfAndEnUSLocale() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", new Locale("en"));

        try {
            validator.validate(context, component, "1234567765");
            fail();
        } catch (ValidatorException e) {
            // it should throw exception for invalid cpf
            FacesMessage message = e.getFacesMessage();
            assertEquals("Invalid CPF", message.getSummary());
            mockery.assertIsSatisfied();
        }
    }
}
