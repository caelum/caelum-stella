package br.com.caelum.stella.faces.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    public void init() {
        mockery = new Mockery();
        facesContextMocker = new FacesContextMocker(mockery);
        this.validator = new StellaIEValidator();
    }

    @After
    public void end() {
        mockery.assertIsSatisfied();
    }

    @Test
    public void shouldIgnoreComponentIdWhenEstadoIsFilled() {
        // estado tem prioridade sobre o estadoComponentId
        FacesContext context = mockery.mock(FacesContext.class);
        facesContextMocker.mockMessageBundle(context, "messages", Locale.getDefault());
        UIComponent component = mockery.mock(UIComponent.class);
        validator.setEstado("SP");
        validator.validate(context, component, "P011004243002");
    }

    @Test
    public void shouldNotThrowValidatorExceptionForValidIE() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        final UIInput valueHolder = mockery.mock(UIInput.class);
        final String estadoComponentId = "form:estado";
        facesContextMocker.mockMessageBundle(context, "messages", Locale.getDefault());
        mockery.checking(new Expectations() {
            {
                one(context.getViewRoot()).findComponent(estadoComponentId);
                will(returnValue(valueHolder));
                one(valueHolder).getValue();
                will(returnValue("SP"));
            }
        });
        validator.setEstadoComponentId(estadoComponentId);
        validator.validate(context, component, "P011004243002");
    }

    @Test
    public void shouldGiveMessagesFromBrazilianResourceBundleForInvalidIEAndPtBRLocale() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", new Locale("pt", "BR"));
        final UIInput valueHolder = mockery.mock(UIInput.class);
        final String estadoComponentId = "form:estado";
        mockery.checking(new Expectations() {
            {
                one(context.getViewRoot()).findComponent(estadoComponentId);
                will(returnValue(valueHolder));
                one(valueHolder).getValue();
                will(returnValue("SP"));
            }
        });
        try {
            validator.setEstadoComponentId(estadoComponentId);
            validator.validate(context, component, "P011004245002");
            fail();
        } catch (ValidatorException e) {
            // it should throw exception for invalid IE
            FacesMessage message = e.getFacesMessage();
            assertEquals("IE Invalido", message.getSummary());
        }
    }

    @Test
    public void shouldGiveMessagesFromDefaultResourceBundleForInvalidIEAndEnUSLocale() throws Exception {
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        facesContextMocker.mockMessageBundle(context, "messages", new Locale("en"));
        final UIInput valueHolder = mockery.mock(UIInput.class);
        final String estadoComponentId = "form:estado";
        mockery.checking(new Expectations() {
            {
                one(context.getViewRoot()).findComponent(estadoComponentId);
                will(returnValue(valueHolder));
                one(valueHolder).getValue();
                will(returnValue("SP"));
            }
        });
        try {
            validator.setEstadoComponentId(estadoComponentId);
            validator.validate(context, component, "P011004245002");
            fail();
        } catch (ValidatorException e) {
            // it should throw exception for invalid IE
            FacesMessage message = e.getFacesMessage();
            assertEquals("Invalid IE", message.getSummary());
        }
    }

}
