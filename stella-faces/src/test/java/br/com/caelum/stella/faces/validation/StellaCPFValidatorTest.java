package br.com.caelum.stella.faces.validation;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.util.ResourceBundle;
import java.util.Locale;

/**
 * StellaCPFValidator integration tests
 *
 * @author Fabio Kung
 */
public class StellaCPFValidatorTest {

    private Mockery mockery;
    private StellaCPFValidator validator;

    @Before
    public void init() {
        mockery = new Mockery();
        mockery.setImposteriser(ClassImposteriser.INSTANCE);
        this.validator = new StellaCPFValidator();
    }

    @Test
    public void shouldNotThrowValidatorExceptionForValidCPF() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        mockFacesContext(context, "messages", Locale.getDefault());

        validator.validate(context, component, "75885366160");
        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldGiveMessagesFromBrazilianResourceBundleForInvalidCpfAndPtBTLocale() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        mockFacesContext(context, "messages", new Locale("pt", "BR"));

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
        mockFacesContext(context, "messages", new Locale("en"));

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

    private void mockFacesContext(final FacesContext context, final String bundleName, final Locale locale) {
        mockery.checking(new Expectations() {
            {
                Application application = mockery.mock(Application.class);
                allowing(context).getApplication();
                will(returnValue(application));

                allowing(application).getMessageBundle();
                will(returnValue(bundleName));

                UIViewRoot viewRoot = mockery.mock(UIViewRoot.class);
                allowing(context).getViewRoot();
                will(returnValue(viewRoot));

                allowing(viewRoot).getLocale();
                will(returnValue(locale));
            }
        });
    }

}
