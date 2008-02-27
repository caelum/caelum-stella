package br.com.caelum.stella.faces.validation;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @Author Fabio Kung
 */
class SimpleMapBundle extends ResourceBundle {
    private final Map<String, Object> items;

    SimpleMapBundle() {
        this(new HashMap<String, Object>());
    }

    SimpleMapBundle(Map<String, Object> items) {
        this.items = items;
    }

    protected Object handleGetObject(String key) {
        return this.items.get(key);
    }

    public Enumeration<String> getKeys() {
        return Collections.enumeration(items.keySet());
    }
}
