/**
 * 
 */
package br.com.caelum.stella.nfe.builder.icms;

import net.vidageek.mirror.Mirror;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import br.com.caelum.stella.nfe.builder.icms.impl.ICMSBuilderDelegate;
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
public class ICMSBuilderDelegateTest {

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
    public void testThatDelegatorAutomaticallySetsCST(final Class<?> icmsClass) {
        @SuppressWarnings("unchecked")
        ICMSBuilderDelegate builder = new ICMSBuilderDelegate(icmsClass);

        Assert.assertEquals(icmsClass.getSimpleName().substring(4), Mirror.on(builder.getModelInstance()).get().field(
                "tipoTributacao"));
    }

}
