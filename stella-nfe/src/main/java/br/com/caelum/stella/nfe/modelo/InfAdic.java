/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "infAdFisco", "infCpl", "obsCont", "obsFisco", "procRef" })
public class InfAdic {

    protected String infAdFisco;
    protected String infCpl;
    protected List<ObsCont> obsCont;
    protected List<ObsFisco> obsFisco;
    protected List<ProcRef> procRef;

    public String getInfAdFisco() {
        return infAdFisco;
    }

    public void setInfAdFisco(String value) {
        this.infAdFisco = value;
    }

    public String getInfCpl() {
        return infCpl;
    }

    public void setInfCpl(String value) {
        this.infCpl = value;
    }

    public List<ObsCont> getObsCont() {
        if (obsCont == null) {
            obsCont = new ArrayList<ObsCont>();
        }
        return this.obsCont;
    }

    public List<ObsFisco> getObsFisco() {
        if (obsFisco == null) {
            obsFisco = new ArrayList<ObsFisco>();
        }
        return this.obsFisco;
    }

    public List<ProcRef> getProcRef() {
        if (procRef == null) {
            procRef = new ArrayList<ProcRef>();
        }
        return this.procRef;
    }

}