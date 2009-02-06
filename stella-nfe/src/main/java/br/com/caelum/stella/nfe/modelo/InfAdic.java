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
@XmlType(name = "InfAdic ", propOrder = { "infAdFisco", "infCpl", "obsCont", "obsFisco", "procRef" })
public class InfAdic {

    protected String infAdFisco;

    protected String infCpl;

    protected List<ObsCont> obsCont;

    protected List<ObsFisco> obsFisco;

    protected List<ProcRef> procRef;

    public String getInfAdFisco() {
        return infAdFisco;
    }

    public void setInfAdFisco(final String value) {
        infAdFisco = value;
    }

    public String getInfCpl() {
        return infCpl;
    }

    public void setInfCpl(final String value) {
        infCpl = value;
    }

    public List<ObsCont> getObsCont() {
        if (obsCont == null) {
            obsCont = new ArrayList<ObsCont>();
        }
        return obsCont;
    }

    public List<ObsFisco> getObsFisco() {
        if (obsFisco == null) {
            obsFisco = new ArrayList<ObsFisco>();
        }
        return obsFisco;
    }

    public List<ProcRef> getProcRef() {
        if (procRef == null) {
            procRef = new ArrayList<ProcRef>();
        }
        return procRef;
    }

    public void setObsCont(final List<ObsCont> obsCont) {
        this.obsCont = obsCont;
    }

    public void setObsFisco(final List<ObsFisco> obsFisco) {
        this.obsFisco = obsFisco;
    }

    public void setProcRef(final List<ProcRef> procRef) {
        this.procRef = procRef;
    }

}