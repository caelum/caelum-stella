package br.com.caelum.stella.validation.error;

import br.com.caelum.stella.validation.InvalidValue;

public enum AgenciaBancariaError implements InvalidValue {
	INVALID_CHECK_DIGIT, CHECK_DIGIT_NOT_FOUND, INVALID_FORMAT
}
