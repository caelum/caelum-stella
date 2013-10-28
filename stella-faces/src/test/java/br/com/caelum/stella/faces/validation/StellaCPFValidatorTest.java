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
 * @author Fabio Kung
 */
public class StellaCPFValidatorTest {

    private Mockery mockery;
    private StellaCPFValidator validator;
    private FacesContextMocker facesContextMocker; 

    @Before
    public void init() {
        mockery = new Mockery();
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

    @Test
    public void shouldAcceptCPFWithLeadingZeros() {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", Locale.getDefault());

        try {
            validator.validate(context, component, "01169538452");
            mockery.assertIsSatisfied();
        } catch (ValidatorException e) {
            fail("shouldn't throw exception for valid cpf with leading zeros");
        }
    }

    @Test
    public void shouldNotThrowNullPointerExceptionWhenCPFIsNull() {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", Locale.getDefault());

        try {
            validator.validate(context, component, null);
            mockery.assertIsSatisfied();
        } catch (ValidatorException e) {
            fail("shouldn't throw exception for null cpf");
        } catch (NullPointerException e) {
        	fail("shouldn't throw exception for null cpf");
        }
    }

    @Test
    public void shouldNotThrowValidatorExceptionWhenCPFIsEmpty() {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", Locale.getDefault());

        try {
            validator.validate(context, component, "");
            mockery.assertIsSatisfied();
        } catch (ValidatorException e) {
            fail("shouldn't throw exception for empty cpf");
        }
    }
}
