package br.com.caelum.stella;

/**
 * Basic imutable implementation. Only holds the message.
 *
 * @author Fabio Kung
 */
public class SimpleValidationMessage implements ValidationMessage {
    private final String message;

    public SimpleValidationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
