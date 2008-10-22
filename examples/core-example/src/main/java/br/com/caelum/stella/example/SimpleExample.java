package br.com.caelum.stella.example;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;

public class SimpleExample {
    public static void main(String[] args) {
        String cpf = "867.554.707-24";
        for (ValidationMessage error : new CPFValidator().invalidMessagesFor(cpf)) {
            System.out.println(error.getMessage());
        }

        new CPFValidator().assertValid("867.554.707-24");

    }
}
