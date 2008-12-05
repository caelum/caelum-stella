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
@XmlType(name = "Compra ", propOrder = { "xnEmp", "xPed", "xCont" })
public class Compra {

    @XmlElement(name = "xNEmp")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xnEmp;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xPed;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xCont;

    public String getXNEmp() {
        return xnEmp;
    }

    public void setXNEmp(String value) {
        this.xnEmp = value;
    }

    public String getXPed() {
        return xPed;
    }

    public void setXPed(String value) {
        this.xPed = value;
    }

    public String getXCont() {
        return xCont;
    }

    public void setXCont(String value) {
        this.xCont = value;
    }

}