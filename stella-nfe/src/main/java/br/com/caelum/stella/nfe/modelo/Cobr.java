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
@XmlType(name = "Cobr ", propOrder = { "fat", "dup" })
public class Cobr {

    protected Fat fat;

    protected List<Dup> dup;

    public Fat getFat() {
        return fat;
    }

    public void setFat(Fat value) {
        this.fat = value;
    }

    public List<Dup> getDup() {
        if (dup == null) {
            dup = new ArrayList<Dup>();
        }
        return this.dup;
    }

}