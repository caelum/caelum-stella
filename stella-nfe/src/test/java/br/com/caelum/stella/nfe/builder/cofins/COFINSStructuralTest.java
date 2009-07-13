/**
 * 
 */
package br.com.caelum.stella.nfe.builder.cofins;

import java.lang.reflect.Field;

import javax.xml.bind.annotation.XmlElement;

import junit.framework.Assert;
import net.vidageek.mirror.Mirror;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import br.com.caelum.stella.nfe.modelo.COFINSAliq;
import br.com.caelum.stella.nfe.modelo.COFINSNT;
import br.com.caelum.stella.nfe.modelo.COFINSOutr;
import br.com.caelum.stella.nfe.modelo.COFINSQtde;
import br.com.caelum.stella.nfe.modelo.COFINSST;

/**
 * @author jonasabreu
 * 
 */
@RunWith(Theories.class)
public class COFINSStructuralTest {

    @DataPoint
    public Class<?> cofinsAliq = COFINSAliq.class;

    @DataPoint
    public Class<?> cofinsNT = COFINSNT.class;

    @DataPoint
    public Class<?> cofinsOutr = COFINSOutr.class;

    @DataPoint
    public Class<?> cofinsQtde = COFINSQtde.class;

    @DataPoint
    public Class<?> cofinsST = COFINSST.class;

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
