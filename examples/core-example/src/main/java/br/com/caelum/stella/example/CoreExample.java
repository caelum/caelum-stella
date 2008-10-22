package br.com.caelum.stella.example;

import java.util.Locale;
import java.util.ResourceBundle;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ResourceBundleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class CoreExample {
    public static void main(String[] args) {
        String cnpj = "26.637.142/0001-48";
        ResourceBundle resourceBundle = ResourceBundle.getBundle("StellaValidationMessages", new Locale("pt", "BR"));
        MessageProducer messageProducer = new ResourceBundleMessageProducer(resourceBundle);
        boolean isFormatted = true;
        CNPJValidator validator = new CNPJValidator(messageProducer, isFormatted);
        try {
            // lógica de negócio ...
            validator.assertValid(cnpj);
            // continuação da lógica de negócio ...
        } catch (InvalidStateException e) {
            for (ValidationMessage message : e.getInvalidMessages()) {
                System.out.println(message.getMessage());
            }
        }
    }
}
