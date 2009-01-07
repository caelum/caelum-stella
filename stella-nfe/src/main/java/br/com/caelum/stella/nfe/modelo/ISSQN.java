/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ISSQN ", propOrder = { "vbc", "vAliq", "vissqn", "cMunFG", "cListServ" })
public class ISSQN {

    @XmlElement(name = "vBC", required = true)
    protected String valorBaseCalculo;

    @XmlElement(required = true, name = "vAliq")
    protected String aliquota;

    @XmlElement(name = "vISSQN", required = true)
    protected String valorISSQN;

    @XmlElement(required = true, name = "cMunFG")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String codigoMunicipio;

    @XmlElement(required = true, name = "cListServ")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String codigoListaServicos;

    public String getValorBaseCalculo() {
        return valorBaseCalculo;
    }

    public void setValorBaseCalculo(String valorBaseCalculo) {
        this.valorBaseCalculo = valorBaseCalculo;
    }

    public String getAliquota() {
        return aliquota;
    }

    public void setAliquota(String aliquota) {
        this.aliquota = aliquota;
    }

    public String getValorISSQN() {
        return valorISSQN;
    }

    public void setValorISSQN(String valorISSQN) {
        this.valorISSQN = valorISSQN;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getCodigoListaServicos() {
        return codigoListaServicos;
    }

    public void setCodigoListaServicos(String codigoListaServicos) {
        this.codigoListaServicos = codigoListaServicos;
    }

}