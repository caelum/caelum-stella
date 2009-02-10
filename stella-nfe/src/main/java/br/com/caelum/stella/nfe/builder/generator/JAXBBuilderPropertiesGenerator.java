package br.com.caelum.stella.nfe.builder.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import net.vidageek.mirror.Mirror;
import br.com.caelum.stella.nfe.modelo.Adi;

/**
 * @author leobessa
 * 
 *         Objeto que usa um pouco de magia preta pra gerar um properties com as
 *         chaves (extraídas das classes geradas pelo JAX-B) e os valores com os
 *         nomes adequados para a interface fluente.
 */
final public class JAXBBuilderPropertiesGenerator {

    @SuppressWarnings("serial")
    private Properties properties = new Properties() {
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

    public static void main(final String[] args) throws IOException, ClassNotFoundException {
        ClassEnumerator classEnumerator = new ClassEnumerator();
        List<Class<?>> classList = classEnumerator.getAllClassesInTheSamePackageAs(Adi.class);
        Class<?>[] sources = classList.toArray(new Class[0]);
        JAXBBuilderPropertiesGenerator builder = new JAXBBuilderPropertiesGenerator();
        builder.generatePropertiesFor(sources);
        String resourcePath = "src/main/resources/";
        String fileName = resourcePath + "stella-nfe.properties";
        OutputStream out = new FileOutputStream(new File(fileName));
        String comments =  "Stella NFe";
        builder.getProperties().store(out, comments );
    }

    public Properties getProperties() {
        return properties;
    }

    private void generatePropertiesFor(final Class<?>... sources) throws FileNotFoundException {
        for (Class<?> type : sources) {
            generatePropertiesFor(type);
        }
    }

    private void generatePropertiesFor(final Class<?> source) throws FileNotFoundException {
        addClassNameProperty(source);

        addClassFieldsProperties(source);



    }

    private void addClassFieldsProperties(final Class<?> source) {
        List<Field> fields = Mirror.on(source).reflectAll().fields();
        for (Field field : fields) {
            String name = extractAnnotatedFieldName(field);
            String key = String.format("%s.%s", extractAnnotatedTypeName(source).trim(), name);
            properties.setProperty(key, field.getName());
        }
    }

    private String extractAnnotatedFieldName(Field field) {
        String name = field.getName();
        XmlElement annotation = field.getAnnotation(XmlElement.class);
        if ((annotation != null) && !"##default".equals(annotation.name())) {
            name = annotation.name();
        }
        return name;
    }

    private void addClassNameProperty(final Class<?> source) {
        String extractedTypeName = extractAnnotatedTypeName(source);
        properties.setProperty(extractedTypeName.trim(), source.getSimpleName());
    }

    private String extractAnnotatedTypeName(final Class<?> source) {
        String typeName = source.getSimpleName();
        XmlType classAnnotation = source.getAnnotation(XmlType.class);
        if ((classAnnotation != null) && !"##default".equals(classAnnotation.name())) {
            typeName = classAnnotation.name();
        }
        return typeName;
    }


}
