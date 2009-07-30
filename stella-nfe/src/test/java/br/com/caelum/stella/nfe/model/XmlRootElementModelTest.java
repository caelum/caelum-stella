package br.com.caelum.stella.nfe.model;

import javax.xml.bind.annotation.XmlRootElement;

import junit.framework.Assert;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import br.com.caelum.stella.nfe.modelo.TAtuCadEmiDFe;
import br.com.caelum.stella.nfe.modelo.TCadEmiDFe;
import br.com.caelum.stella.nfe.modelo.TCancNFe;
import br.com.caelum.stella.nfe.modelo.TConsCad;
import br.com.caelum.stella.nfe.modelo.TConsReciNFe;
import br.com.caelum.stella.nfe.modelo.TConsSitNFe;
import br.com.caelum.stella.nfe.modelo.TConsStatServ;
import br.com.caelum.stella.nfe.modelo.TEnviNFe;
import br.com.caelum.stella.nfe.modelo.TInutNFe;
import br.com.caelum.stella.nfe.modelo.TProcCancNFe;
import br.com.caelum.stella.nfe.modelo.TProcInutNFe;

/**
 * @author jonasabreu
 * 
 */
@RunWith(Theories.class)
final public class XmlRootElementModelTest {

    @DataPoint
    public Class<?> tCadEmiDFe = TCadEmiDFe.class;
    @DataPoint
    public Class<?> tAtuCadEmiDFe = TAtuCadEmiDFe.class;
    @DataPoint
    public Class<?> pedidoDeAutorizacaoDaNFE = TEnviNFe.class;
    @DataPoint
    public Class<?> tConsSitNFe = TConsSitNFe.class;
    @DataPoint
    public Class<?> tConsStatServ = TConsStatServ.class;
    @DataPoint
    public Class<?> pedidoDeConsultaDoRecidoDoLoteDeNFE = TConsReciNFe.class;
    @DataPoint
    public Class<?> tConsCad = TConsCad.class;
    @DataPoint
    public Class<?> tProcCancNFe = TProcCancNFe.class;
    @DataPoint
    public Class<?> tCancNFe = TCancNFe.class;
    @DataPoint
    public Class<?> tProcInutNFe = TProcInutNFe.class;
    @DataPoint
    public Class<?> tInutNFe = TInutNFe.class;

    @Theory
    public void testThatIsAnnotatedByXmlRootElement(final Class<?> type) {
        Assert.assertTrue("type " + type.getName() + " should be annotated by @XmlRootElement", type
            .isAnnotationPresent(XmlRootElement.class));
    }

}
