package br.com.caelum.stella.validation.error;

import br.com.caelum.stella.validation.InvalidValue;

/**
 * Representa possíveis erros na validação do Renavam
 * 
 * @author Rafael Carvalho
 */
public enum RenavamError implements InvalidValue {

    INVALID_FORMAT, INVALID_CHECK_DIGIT, INVALID_DIGITS
}
