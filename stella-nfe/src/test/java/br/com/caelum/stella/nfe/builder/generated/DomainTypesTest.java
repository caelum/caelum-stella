package br.com.caelum.stella.nfe.builder.generated;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import junit.framework.Assert;
import net.vidageek.mirror.Mirror;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.stella.nfe.builder.generator.ClassEnumerator;
import br.com.caelum.stella.nfe.builder.generator.JAXBBuilderPropertiesGenerator;

public class DomainTypesTest {

    private final Logger log = Logger.getLogger(DomainTypesTest.class.getCanonicalName());
    private static Properties expectedProperties;
    private final JAXBBuilderPropertiesGenerator propertiesGenerator = new JAXBBuilderPropertiesGenerator();

    @BeforeClass
    public static void loadProperties() throws IOException {
        expectedProperties = new Properties();
        java.net.URL url = ClassLoader.getSystemResource("stella-nfe.properties");
        expectedProperties.load(url.openStream());
    }

    @Test
    public void interfacesShouldHaveTypesDefinedByFieldNameConventions() throws ClassNotFoundException,
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
                    String extractedFieldName = propertiesGenerator.extractAnnotatedFieldName(field);
                    String key = wrappedClass.getSimpleName() + "."
                    + extractedFieldName;
                    String expectedValue = (String) expectedProperties.get(key);
                    if (expectedValue == null) {
                        throw new IllegalStateException(String
                                .format("Key %s must exist in stella-nfe.properties", key));
                    }

                    String methodName = "with" + capitalize(expectedValue);
                    if (existsTypeConvetionFor(extractedFieldName)) {
                        Class<?> expectedArgument = getArgumentTypeFor(extractedFieldName);
                        Method method = Mirror.on(type).reflect().method(methodName).withArgs(expectedArgument);
                        if (method == null) {
                            errors++;
                            log.info(String.format("%s method %s should receive type %s as argument.\n (key=%s)", type,
                                    methodName, expectedArgument, key));
                        }
                    }
                }
            }
        }
        Assert.assertEquals(String.format("%d metodos recebendo um tipo inadequado.", errors), 0, errors);

    }

    private Class<?> getArgumentTypeFor(String fieldName) {
        Set<Pattern> keySet = typesMap.keySet();
        for (Pattern pattern : keySet) {
            if (pattern.matcher(fieldName).matches()) {
                return typesMap.get(pattern);
            }
        }
        return null;
    }

    private Map<Pattern, Class<?>> typesMap = new HashMap<Pattern, Class<?>>();

    {
        typesMap.put(Pattern.compile("^p[A-Z]\\w*"), BigDecimal.class);
    }


    private boolean existsTypeConvetionFor(String s) {
        Set<Pattern> keySet = typesMap.keySet();
        for (Pattern pattern : keySet) {
            if (pattern.matcher(s).matches()) {
                return true;
            }
        }
        return false;
    }

    private String capitalize(final String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

}
