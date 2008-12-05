package br.com.caelum.stella.nfe.xml;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public final class JAXBXmlBinder implements XmlBinder {

    private static final Map<Class<?>, JAXBContext> contextCache = new ConcurrentHashMap<Class<?>, JAXBContext>();

    private Marshaller getMarshaller(final Class<?> clazz) {
        createContext(clazz);
        final JAXBContext context = contextCache.get(clazz);
        try {
            final Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            return marshaller;
        } catch (final JAXBException e) {
            // É possivel que o contexto seja corrompido nessa exceção
            contextCache.remove(clazz);
            createContext(clazz);
            throw new RuntimeException("Erro ao criar Marshaller para classe " + clazz.getName(), e);
        }
    }

    private void createContext(final Class<?> clazz) {
        if (!JAXBXmlBinder.contextCache.containsKey(clazz)) {
            try {
                final JAXBContext context = JAXBContext.newInstance(clazz);
                contextCache.put(clazz, context);
            } catch (final JAXBException e) {
                throw new RuntimeException("Erro ao criar JAXB context para classe " + clazz.getName(), e);
            }
        }
    }

    private Unmarshaller getUnmarshaller(final Class<?> clazz) {
        createContext(clazz);
        JAXBContext context = contextCache.get(clazz);

        try {
            context = JAXBContext.newInstance(clazz);
            return context.createUnmarshaller();
        } catch (final JAXBException e) {
            // É possivel que o contexto seja corrompido nessa exceção
            contextCache.remove(clazz);
            createContext(clazz);
            throw new RuntimeException("Erro ao criar Unmarshaller para classe " + clazz.getName(), e);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T unmarshal(final Class<T> contextClazz, final String toUnmarshal) {
        try {
            return (T) getUnmarshaller(contextClazz).unmarshal(new StringReader(toUnmarshal));
        } catch (final JAXBException e) {
            throw new RuntimeException("Erro ao fazer unmarshal com contexto " + contextClazz, e);
        }
    }

    public String marshal(Object toMarshal) {
        Writer writer = new StringWriter();
        try {
            getMarshaller(toMarshal.getClass()).marshal(toMarshal, writer);
        } catch (JAXBException e) {
            throw new RuntimeException("", e);
        }
        return writer.toString();
    }

}
