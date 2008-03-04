package br.com.caelum.stella.example.validator;

import org.hibernate.validator.NotNull;

/**
 * @author Fabio Kung
 */
public class Dog {

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
