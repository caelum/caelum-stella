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
public class StellaCNPJValidatorTest {

	private Mockery mockery;
	private StellaCNPJValidator validator;

	@Before
	public void init() {
		mockery = new Mockery();
		mockery.setImposteriser(ClassImposteriser.INSTANCE);
		this.validator = new StellaCNPJValidator();
	}

	@Test
	public void shouldNotThrowValidatorExceptionForValidCNPJ() throws Exception {
		final FacesContext context = mockery.mock(FacesContext.class);
		final UIComponent component = mockery.mock(UIComponent.class);
		mockFacesContext(context, "messages", Locale.getDefault());

		validator.validate(context, component, "18358139000177");
		mockery.assertIsSatisfied();
	}

	@Test
	public void shouldGiveMessagesFromBrazilianResourceBundleForInvalidCNPJAndPtBRLocale()
			throws Exception {
		final FacesContext context = mockery.mock(FacesContext.class);
		final UIComponent component = mockery.mock(UIComponent.class);
		mockFacesContext(context, "messages", new Locale("pt", "BR"));

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
	public void shouldGiveMessagesFromDefaultResourceBundleForInvalidCNPJAndEnUSLocale()
			throws Exception {
		final FacesContext context = mockery.mock(FacesContext.class);
		final UIComponent component = mockery.mock(UIComponent.class);
		mockFacesContext(context, "messages", new Locale("en"));

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
