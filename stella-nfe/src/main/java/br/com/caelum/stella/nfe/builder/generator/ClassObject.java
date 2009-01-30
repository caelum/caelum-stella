package br.com.caelum.stella.nfe.builder.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jonasabreu
 * 
 */
final public class ClassObject {

    private final Class<?> source;

    private final List<MethodObject> methodList;

    public ClassObject(final Class<?> source) {
        this.source = source;
        methodList = new ArrayList<MethodObject>();
    }

    public void addMethod(final String name, final Class<?> parameterType) {
        methodList.add(new MethodObject(name, parameterType.getSimpleName(), source.getSimpleName()));
    }

    public String getInterface() {
        String res = interfaceHeader();
        for (MethodObject method : methodList) {
            res += method.getInterfaceSignature();
        }
        return res + "}";
    }

    public String getImplentation() {
        String res = implementationHeader();
        res += constructor();
        res += objectCreator();
        for (MethodObject method : methodList) {
            res += method.getImplementation();
        }
        return res + "}";
    }

    private String implementationHeader() {
        return "public final class " + getInterfaceName() + "Impl implements " + getInterfaceName()
                + ", ObjectCreator { " + "private final br.com.caelum.stella.nfe.modelo." + source.getSimpleName()
                + " " + asVariable(source.getSimpleName()) + ";";
    }

    private String asVariable(final String simpleName) {
        return simpleName.toLowerCase().charAt(0) + simpleName.substring(1);
    }

    private String interfaceHeader() {
        return "public interface " + getInterfaceName() + " {";
    }

    private String getInterfaceName() {
        return source.getSimpleName();
    }

    private String constructor() {
        return "public " + getInterfaceName() + "Impl () { this." + asVariable(source.getSimpleName())
                + " = new br.com.caelum.stella.nfe.modelo." + source.getSimpleName() + "();}";
    }

    private String objectCreator() {
        return "public br.com.caelum.stella.nfe.modelo." + source.getSimpleName() + " getInstance() {" + "return this."
                + asVariable(source.getSimpleName()) + ";}";
    }
}
