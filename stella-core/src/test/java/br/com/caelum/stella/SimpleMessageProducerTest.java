package br.com.caelum.stella;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.stella.validation.InvalidValue;

public class SimpleMessageProducerTest {

    private enum DocumentoError implements InvalidValue {
        INVALID_DIGITS, INVALID_CHECK_DIGITS;
    }

    @Test
    public void testGetMessage() {
        SimpleMessageProducer messageProducer = new SimpleMessageProducer();
        ValidationMessage message = messageProducer.getMessage(DocumentoError.INVALID_CHECK_DIGITS);
        assertEquals("DocumentoError : INVALID CHECK DIGITS", message.getMessage());
    }

}
