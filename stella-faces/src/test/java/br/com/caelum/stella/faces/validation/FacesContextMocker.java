package br.com.caelum.stella.faces.validation;

import java.util.Locale;

import javax.faces.application.Application;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;

/**
 * @author Fabio Kung
 */
public class FacesContextMocker {
    private final Mockery mockery;

    public FacesContextMocker(Mockery mockery) {
        this.mockery = mockery;
        mockery.setImposteriser(ClassImposteriser.INSTANCE);
    }

    public void mockMessageBundle(final FacesContext context, final String bundleName, final Locale locale) {
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
