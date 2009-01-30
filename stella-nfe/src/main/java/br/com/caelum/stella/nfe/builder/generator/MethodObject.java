package br.com.caelum.stella.nfe.builder.generator;

/**
 * @author jonasabreu
 * 
 */
final public class MethodObject {

    private final String name;

    private final String parameter;

    private final String className;

    public MethodObject(final String name, final String parameter, final String className) {
        this.name = name;
        this.parameter = parameter;
        this.className = className;
    }

    public String getInterfaceSignature() {
        return getSignature() + ";";
    }

    public String getImplementation() {
        return getSignature() + "{ this." + asVariable(className) + ".set" + asClass(name) + "("
                + asVariable(parameter) + "); return this; }";
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
