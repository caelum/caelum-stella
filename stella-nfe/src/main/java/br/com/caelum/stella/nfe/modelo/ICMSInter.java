/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ICMSInter ", propOrder = { "vbcicmsstDest", "vicmsstDest" })
@FluidName("ICMSSobreOperacoesInterestaduais")
public class ICMSInter {

    @XmlElement(name = "vBCICMSSTDest", required = true)
    @FluidName("valorDaBaseDeCalculoDoICMSSubstituicaoTributariaDoDestino")
    protected String vbcicmsstDest;

    @XmlElement(name = "vICMSSTDest", required = true)
    @FluidName("valorDoICMSSubstituicaoTributariaDoDestino")
    protected String vicmsstDest;

    public String getVBCICMSSTDest() {
        return vbcicmsstDest;
    }

    public void setVBCICMSSTDest(final String value) {
        vbcicmsstDest = value;
    }

    public String getVICMSSTDest() {
        return vicmsstDest;
    }

    public void setVICMSSTDest(final String value) {
        vicmsstDest = value;
    }

}