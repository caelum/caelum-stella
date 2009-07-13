/**
 * 
 */
package br.com.caelum.stella.nfe.builder.icms;

import java.lang.reflect.Field;

import javax.xml.bind.annotation.XmlElement;

import junit.framework.Assert;
import net.vidageek.mirror.Mirror;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import br.com.caelum.stella.nfe.modelo.ICMS00;
import br.com.caelum.stella.nfe.modelo.ICMS10;
import br.com.caelum.stella.nfe.modelo.ICMS20;
import br.com.caelum.stella.nfe.modelo.ICMS30;
import br.com.caelum.stella.nfe.modelo.ICMS40;
import br.com.caelum.stella.nfe.modelo.ICMS51;
import br.com.caelum.stella.nfe.modelo.ICMS60;
import br.com.caelum.stella.nfe.modelo.ICMS70;
import br.com.caelum.stella.nfe.modelo.ICMS90;

/**
 * @author jonasabreu
 * 
 */
@RunWith(Theories.class)
public class ICMSStructuralTest {

    @DataPoint
    public Class<?> icms00 = ICMS00.class;

    @DataPoint
    public Class<?> icms10 = ICMS10.class;

    @DataPoint
    public Class<?> icms20 = ICMS20.class;

    @DataPoint
    public Class<?> icms30 = ICMS30.class;

    @DataPoint
    public Class<?> icms40 = ICMS40.class;

    @DataPoint
    public Class<?> icms51 = ICMS51.class;

    @DataPoint
    public Class<?> icms60 = ICMS60.class;

    @DataPoint
    public Class<?> icms70 = ICMS70.class;

    @DataPoint
    public Class<?> icms90 = ICMS90.class;

    @Theory
    public void testThatAllFieldsAreAnnotatedByXmlElement(final Class<?> clazz) {
        for (Field f : Mirror.on(clazz).reflectAll().fields()) {
            Assert.assertTrue("Field " + f.getName() + " from class " + clazz.getSimpleName()
                    + " should be annotated by @XmlElement",
                    Mirror.on(f).reflect().annotation(XmlElement.class) != null);
        }
    }

    @Theory
    public void testThatAllFieldsHaveNameSetted(final Class<?> clazz) {
        for (Field f : Mirror.on(clazz).reflectAll().fields()) {
            XmlElement ann = (XmlElement) Mirror.on(f).reflect().annotation(XmlElement.class);
            Assert.assertFalse("Field " + f.getName() + " from class " + clazz.getSimpleName()
                    + " should have @XmlElement property name setted", ann.name().equals("##default"));
        }
    }
}
