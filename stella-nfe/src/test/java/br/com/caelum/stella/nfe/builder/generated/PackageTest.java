package br.com.caelum.stella.nfe.builder.generated;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.datatype.XMLGregorianCalendar;

import net.vidageek.mirror.Mirror;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.stella.nfe.modelo.TNFe;

public class PackageTest {

    private final Set<Class<?>> types = new HashSet<Class<?>>();

    @Test
    public void shouldNotHaveAnyXMLGregorianCalendarTypesInModel() throws ClassNotFoundException {
        List<Class<?>> classes = new ClassEnumerator().getAllClassesInTheSamePackageAs(TNFe.class);
        types.addAll(classes);
        Assert.assertTrue(types.size() == 91);
        assertXMLGregorianCalendarAvoidanceOn(types);
    }

    private void assertXMLGregorianCalendarAvoidanceOn(final Set<Class<?>> types) {
        for (Class<?> type : types) {
            for (Field field : Mirror.on(type).reflectAll().fields()) {
                String message = String.format("O atributo [%s] da classe [%s] não deve ser um [%s]", field.getName(),
                        field.getDeclaringClass().getCanonicalName(), XMLGregorianCalendar.class.getCanonicalName());
                Assert.assertNotSame(message, XMLGregorianCalendar.class, field.getType());
            }
        }
    }

}
