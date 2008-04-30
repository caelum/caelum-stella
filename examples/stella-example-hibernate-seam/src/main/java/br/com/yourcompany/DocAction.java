package br.com.yourcompany;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Name("docAction")
@Scope(ScopeType.EVENT)
public class DocAction {    
    /**
     * Action method
     */
    public String send(){
        //do something real

        return ("success");
    }
}