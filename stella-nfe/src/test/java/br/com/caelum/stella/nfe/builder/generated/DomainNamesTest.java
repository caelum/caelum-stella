package br.com.caelum.stella.nfe.builder.generated;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Logger;

import junit.framework.Assert;
import net.vidageek.mirror.Mirror;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.stella.nfe.builder.generator.ClassEnumerator;
import br.com.caelum.stella.nfe.builder.generator.JAXBBuilderPropertiesGenerator;

public class DomainNamesTest {

    private final Logger log = Logger.getLogger(DomainNamesTest.class.getCanonicalName());
    private static Properties expectedProperties;
    private final JAXBBuilderPropertiesGenerator propertiesGenerator = new JAXBBuilderPropertiesGenerator();

    @BeforeClass
    public static void loadProperties() throws IOException {
        expectedProperties = new Properties() {
            private static final long serialVersionUID = 1L;

            @SuppressWarnings("unchecked")
            @Override
            public synchronized Enumeration keys() {
                Enumeration keysEnum = super.keys();
                Vector keyList = new Vector();
                while (keysEnum.hasMoreElements()) {
                    keyList.add(keysEnum.nextElement());
                }
                Collections.sort(keyList);
                return keyList.elements();
            }

        };
        java.net.URL url = ClassLoader.getSystemResource("stella-nfe.properties");
        expectedProperties.load(url.openStream());
    }

    @Test
    public void interfacesShouldHaveNamesDefinedInThePropertiesFile() throws ClassNotFoundException,
            FileNotFoundException, IOException {
        int errors = 0;
        ClassEnumerator classEnumerator = new ClassEnumerator();
        List<Class<?>> classList = classEnumerator.getAllTypesInTheSamePackageAs(ArmamentoImpl.class);
        for (Class<?> type : classList) {
            if (type.getSimpleName().endsWith("Impl")) {
                List<Field> builderFields = Mirror.on(type).reflectAll().fields();
                Class<?> wrappedClass = builderFields.get(0).getType();
                List<Field> fields = Mirror.on(wrappedClass).reflectAll().fields();
                for (Field field : fields) {
                    String key = wrappedClass.getSimpleName() + "."
                            + propertiesGenerator.extractAnnotatedFieldName(field);
                    String expectedValue = (String) expectedProperties.get(key);
                    if (expectedValue == null) {
                        throw new IllegalStateException(String
                                .format("Key %s must exist in stella-nfe.properties", key));
                    }

                    List<String> methodNames = getMethodNames(type);
                    String actualValue = "with" + capitalize(expectedValue);
                    if (!methodNames.contains(actualValue)) {
                        errors++;
                        log.info(String.format("Builder  %s should contain method %s", type.getSimpleName(),
                                actualValue));
                    }
                }
            }
        }
        Assert.assertEquals(String.format("%d erros\n", errors), 0, errors);

    }

    private List<String> getMethodNames(final Class<?> type) {
        List<Method> methods = Mirror.on(type).reflectAll().methods();
        List<String> methodNames = new ArrayList<String>();
        for (Method method : methods) {
            String name = method.getName();
            methodNames.add(name);
        }
        return methodNames;
    }

    private String capitalize(final String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

}
