package br.com.caelum.stella.nfe.builder.generator;

import java.util.ArrayList;
import java.util.List;

import net.vidageek.fluid.proxy.ObjectCreator;

/**
 * @author jonasabreu
 * @author leonardobessa
 * 
 */
final public class ClassObject {

    private String packageName;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(final String packageName) {
        this.packageName = packageName;
    }

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

    public String getImplementation() {
        String res = implementationHeader();
        res += constructor();
        res += objectCreator();
        for (MethodObject method : methodList) {
            res += method.getImplementation();
        }
        return res + "}";
    }

    private String implementationHeader() {
        return getPackageDeclaration() + "public final class " + getInterfaceName() + "Impl implements "
                + getInterfaceName() + ", " + getObjectCreatorClassName() + " { "
                + "private final br.com.caelum.stella.nfe.modelo." + source.getSimpleName() + " "
                + asVariable(source.getSimpleName()) + ";";
    }

    private String getObjectCreatorClassName() {
        return ObjectCreator.class.getCanonicalName();
    }

    private String asVariable(final String simpleName) {
        return simpleName.toLowerCase().charAt(0) + simpleName.substring(1);
    }

    private String interfaceHeader() {
        return getPackageDeclaration() + "public interface " + getInterfaceName() + " {";
    }

    public String getInterfaceName() {
        return source.getSimpleName();
    }

    private String constructor() {
        return "public " + getImplementationName() + " () { this." + asVariable(source.getSimpleName())
                + " = new br.com.caelum.stella.nfe.modelo." + source.getSimpleName() + "();}";
    }

    public String getImplementationName() {
        return getInterfaceName() + "Impl";
    }

    public String getInterfaceTestName() {
        return getImplementationName() + "Test";
    }

    private String objectCreator() {
        return "public br.com.caelum.stella.nfe.modelo." + source.getSimpleName() + " getInstance() {" + "return this."
                + asVariable(source.getSimpleName()) + ";}";
    }

    public String getInterfaceTest() {
        return getPackageDeclaration() + "public final class " + getInterfaceTestName() + " { " + getTestMethods()
                + " }";
    }

    private String getPackageDeclaration() {
        if (packageName != null) {
            return "package " + packageName + "; ";
        } else {
            return "";
        }
    }

    private String getTestMethods() {
        String result = "";
        String annotation = " @org.junit.Test ";
        String signature = "public void test" + getInterfaceName() + "Interface() ";
        String body = getInterfaceName() + " " + asVariable(getInterfaceName()) + " = new " + getImplementationName()
                + "()";
        String methodChain = "";
        for (MethodObject method : methodList) {
            methodChain += method.getCall();
        }
        methodChain += "; ";
        String assertMethodCall = String.format("assertModelWasFilled(%s);", asVariable(getInterfaceName()));
        body += methodChain + assertMethodCall;
        String testMethod = String.format("%s %s { %s }", annotation, signature, body);

        String assertWasFilledTestMethod = String.format("private void assertModelWasFilled(%s %s) { "
                + "new %s (%2$s).assertModelWasFilled();" + "}", getInterfaceName(), asVariable(getInterfaceName()),
                "br.com.caelum.stella.nfe.builder.BuilderTestHelper");

        result = testMethod + assertWasFilledTestMethod;
        return result;
    }
}
