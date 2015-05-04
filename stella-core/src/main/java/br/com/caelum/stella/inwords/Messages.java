package br.com.caelum.stella.inwords;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author Victor Santos
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
final class Messages {
	private static final String BUNDLE_NAME = "br.com.caelum.stella.inwords.messages";

	static final Locale LOCALE_PT_BR = new Locale("pt", "BR");

	private static final Map<String, ResourceBundle> RESOURCE_BUNDLES;

	static {
		HashMap<String, ResourceBundle> resourcesByLocale = new HashMap<String, ResourceBundle>(2);

		resourcesByLocale.put(LOCALE_PT_BR.getLanguage(), ResourceBundle.getBundle(BUNDLE_NAME, LOCALE_PT_BR));
		resourcesByLocale.put(Locale.ENGLISH.getLanguage(), ResourceBundle.getBundle(BUNDLE_NAME, Locale.ENGLISH));

		RESOURCE_BUNDLES = Collections.unmodifiableMap(resourcesByLocale);
	}

	private Messages() {
	}

	static String getString(String key) {
		return RESOURCE_BUNDLES.get(LOCALE_PT_BR.getLanguage()).getString(key);
	}

	static String getString(String key, Locale locale) {
		ResourceBundle resourceBundle = RESOURCE_BUNDLES.get(locale.getLanguage());

		if (resourceBundle == null) {
			throw new UnsupportedOperationException("Não é possivel converter números para o idioma " + locale.getDisplayLanguage(LOCALE_PT_BR));
		}

		return resourceBundle.getString(key);
	}
}
