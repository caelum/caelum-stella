package br.com.caelum.stella.faces.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Locale;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;

/**
 * StellaCPFValidator integration tests
 *
 * @author Leonardo Bessa
 */
public class StellaIESPValidatorTest {

	private Mockery mockery;
	private StellaIESPValidator validator;

	@Before
	public void init() {
		mockery = new Mockery();
		mockery.setImposteriser(ClassImposteriser.INSTANCE);
		this.validator = new StellaIESPValidator();
	}

	@Test
	public void shouldNotThrowValidatorExceptionForValidIE_SPComerccio() throws Exception {
		final FacesContext context = mockery.mock(FacesContext.class);
		final UIComponent component = mockery.mock(UIComponent.class);
		mockFacesContext(context, "messages", Locale.getDefault());

		validator.validate(context, component, "110042490114");
		mockery.assertIsSatisfied();
	}
	
	@Test
	public void shouldNotThrowValidatorExceptionForValidIE_SPRural() throws Exception {
		final FacesContext context = mockery.mock(FacesContext.class);
		final UIComponent component = mockery.mock(UIComponent.class);
		mockFacesContext(context, "messages", Locale.getDefault());

		validator.validate(context, component, "P011004243002");
		mockery.assertIsSatisfied();
	}

	@Test
	public void shouldGiveMessagesFromBrazilianResourceBundleForInvalidIE_SPAndPtBRLocale()
			throws Exception {
		final FacesContext context = mockery.mock(FacesContext.class);
		final UIComponent component = mockery.mock(UIComponent.class);
		mockFacesContext(context, "messages", new Locale("pt", "BR"));

		try {
			validator.validate(context, component, "1100424a0114");
			fail();
		} catch (ValidatorException e) {
			// it should throw exception for invalid IE SP
			FacesMessage message = e.getFacesMessage();
			assertEquals("IE Invalido", message.getSummary());
			mockery.assertIsSatisfied();
		}
	}

	@Test
	public void shouldGiveMessagesFromDefaultResourceBundleForInvalidIE_SPAndEnUSLocale()
			throws Exception {
		final FacesContext context = mockery.mock(FacesContext.class);
		final UIComponent component = mockery.mock(UIComponent.class);
		mockFacesContext(context, "messages", new Locale("en"));

		try {
			validator.validate(context, component, "1100b2490114");
			fail();
		} catch (ValidatorException e) {
			// it should throw exception for invalid IE SP
			FacesMessage message = e.getFacesMessage();
			assertEquals("Invalid IE", message.getSummary());
			mockery.assertIsSatisfied();
		}
	}

	private void mockFacesContext(final FacesContext context,
			final String bundleName, final Locale locale) {
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
