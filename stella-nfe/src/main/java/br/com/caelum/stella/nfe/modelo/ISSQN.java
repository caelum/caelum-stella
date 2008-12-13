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
    protected String vbc;

    @XmlElement(required = true)
    protected String vAliq;

    @XmlElement(name = "vISSQN", required = true)
    protected String vissqn;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cMunFG;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cListServ;

    public String getVBC() {
        return vbc;
    }

    public void setVBC(String value) {
        this.vbc = value;
    }

    public String getVAliq() {
        return vAliq;
    }

    public void setVAliq(String value) {
        this.vAliq = value;
    }

    public String getVISSQN() {
        return vissqn;
    }

    public void setVISSQN(String value) {
        this.vissqn = value;
    }

    public String getCMunFG() {
        return cMunFG;
    }

    public void setCMunFG(String value) {
        this.cMunFG = value;
    }

    public String getCListServ() {
        return cListServ;
    }

    public void setCListServ(String value) {
        this.cListServ = value;
    }

}