package br.com.caelum.stella.nfe.builder.generator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jonasabreu
 * @author leonardobessa
 * 
 */
final public class MethodObject {

    private final String name;

    private final String parameter;

    private final String className;

    public MethodObject(final String name, final String parameter, final String className) {
        this.name = name;
        if (parameter.equals("XMLGregorianCalendar")) {
            this.parameter = "Calendar";
        } else {
            this.parameter = parameter;
        }
        this.className = className;
    }

    public String getInterfaceSignature() {
        return getSignature() + ";";
    }

    public String getImplementation() {
        return getSignature() + "{ this." + asVariable(className) + ".set" + asClass(name) + "("
        + asVariable(parameter) + "); return this; }";
    }

    public String getCall(){
        return ".with"+asClass(name)+"("+getDefaultArgumentFor(parameter)+")";
    }

    private Map<String, String> map = new HashMap<String, String>(){
        private static final long serialVersionUID = 1L;

        {
            this.put("String", "\"abc\"");
            this.put("TUf", "TUf.AC");
            this.put("Calendar", "Calendar.getInstance()");
        }
    };

    private String getDefaultArgumentFor(String type) {
        String result = map.get(type);
        return result;
    }

    private String asClass(final String parameter) {
        return parameter.toUpperCase().charAt(0) + parameter.substring(1);
    }

    private String getSignature() {
        return "public " + className + " with" + asClass(name) + "(" + parameter + " " + asVariable(parameter) + ")";
    }

    private String asVariable(final String simpleName) {
        return simpleName.toLowerCase().charAt(0) + simpleName.substring(1);
    }
}
