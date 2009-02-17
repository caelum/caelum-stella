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
import br.com.caelum.stella.nfe.modelo.Adi;

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
    public void classesAndFieldsShouldHaveNamesDefinedInThePropertiesFile() throws ClassNotFoundException {
        ClassEnumerator classEnumerator = new ClassEnumerator();
        List<Class<?>> classList = classEnumerator.getAllTypesInTheSamePackageAs(Adi.class);
        Properties properties = propertiesGenerator.getProperties();
        propertiesGenerator.generatePropertiesFor(classList.toArray(new Class[] {}));
        for (Object key : expectedProperties.keySet()) {
            String expectedValue = (String) expectedProperties.get(key);
            String actualValue = (String) properties.get(key);
            if (!expectedValue.equals(actualValue)) {
                // log.info(String.format("Property (or Class) %s should be named as %s",
                // actualValue, expectedValue));
            }
        }
        Assert.assertEquals(expectedProperties, properties);
    }

    @Test
    public void interfacesShouldHaveNamesDefinedInThePropertiesFile() throws ClassNotFoundException,
    FileNotFoundException, IOException {
        int errors = 0;
        ClassEnumerator classEnumerator = new ClassEnumerator();
        List<Class<?>> classList = classEnumerator.getAllTypesInTheSamePackageAs(ArmamentoImpl.class);
        for (Class<?> type : classList) {
            if (type.getSimpleName().endsWith("Impl")) {
                // System.out.println("Builder -->" + type);
                List<Field> builderFields = Mirror.on(type).reflectAll().fields();
                // System.out.println("builderFields: " + builderFields);
                Class<?> wrappedClass = builderFields.get(0).getType();
                // System.out.println("wrappedClass -->" + wrappedClass);
                List<Field> fields = Mirror.on(wrappedClass).reflectAll().fields();
                for (Field field : fields) {
                    // System.out.println("Wrapped Class Field: " +
                    // field.getName());
                    String key = wrappedClass.getSimpleName() + "."
                    + propertiesGenerator.extractAnnotatedFieldName(field);
                    // System.out.println(key);
                    String expectedValue = (String) expectedProperties.get(key);
                    if (expectedValue == null) {
                        throw new IllegalStateException(String
                                .format("Key %s must exist in stella-nfe.properties", key));
                    }

                    List<Method> methods = Mirror.on(type).reflectAll().methods();
                    List<String> methodNames = new ArrayList<String>();
                    String actualValue = "with" + capitalize(expectedValue);
                    String candidate = null;
                    for (Method method : methods) {
                        String name = method.getName();
                        methodNames.add(name);
                        if (name.equalsIgnoreCase(actualValue)) {
                            candidate = name;
                        }
                    }
                    if (!methodNames.contains(actualValue)) {
                        errors++;
                        log.info(String.format("Builder  %s should contain method %s", type.getSimpleName(),
                                actualValue));
                        if (candidate != null) {
                            String replaced = candidate.replace("with", "");
                            // System.out.println("try " + replaced);
                            expectedProperties.setProperty(key, replaced);
                        }
                    }
                }
            }
        }
        Assert.assertEquals(String.format("%d erros\n", errors), 0, errors);

    }

    private String capitalize(final String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

}
