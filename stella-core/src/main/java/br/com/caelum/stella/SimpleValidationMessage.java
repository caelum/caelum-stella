package br.com.caelum.stella;

/**
 * @Author Fabio Kung
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
