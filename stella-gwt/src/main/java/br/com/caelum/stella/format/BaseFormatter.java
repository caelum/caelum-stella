package br.com.caelum.stella.format;

import br.com.caelum.stella.annotations.GwtCompatible;
import com.google.gwt.regexp.shared.RegExp;

@GwtCompatible(emulated = true)
public class BaseFormatter implements Formatter {

    private final RegExp formatted;

    private final String formattedReplacement;

    private final RegExp unformatted;

    private final String unformattedReplacement;

    public String format(String value) throws IllegalArgumentException {
        String result;
        if (value == null) {
            throw new IllegalArgumentException("Value may not be null.");
        }
        result = matchAndReplace(unformatted, value, formattedReplacement);
        return result;
    }

    public String unformat(String value) throws IllegalArgumentException {
        String result;
        if (value == null) {
            throw new IllegalArgumentException("Value may not be null.");
        }
        result = matchAndReplace(formatted, value, unformattedReplacement);
        return result;
    }

    private String matchAndReplace(RegExp matcher, String value, String replacement) {
        String result = null;
        if (matcher.test(value)) {
            result = matcher.replace(value, replacement);
        } else {
            throw new IllegalArgumentException("Value is not properly formatted.");
        }
        return result;
    }

    public BaseFormatter(RegExp formatted, String formattedReplacement, RegExp unformatted,
                         String unformattedReplacement) {
        super();
        this.formatted = formatted;
        this.formattedReplacement = formattedReplacement;
        this.unformatted = unformatted;
        this.unformattedReplacement = unformattedReplacement;
    }

}
