package br.com.caelum.stella.faces.validation;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import java.util.ResourceBundle;

/**
 * StellaCPFValidator integration tests
 *
 * @Author Fabio Kung
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
        final ResourceBundle bundle = new SimpleMapBundle();
        final FacesContext context = mockery.mock(FacesContext.class);
        final UIComponent component = mockery.mock(UIComponent.class);
        mockery.checking(new Expectations() {
            {
                String bundleName = "any";
                Application application = mockery.mock(Application.class);

                allowing(context).getApplication();
                will(returnValue(application));

                allowing(application).getMessageBundle();
                will(returnValue(bundleName));

                allowing(application).getResourceBundle(context, bundleName);
                will(returnValue(bundle));
            }
        });

        validator.validate(context, component, "75885366160");
        mockery.assertIsSatisfied();
    }

}
