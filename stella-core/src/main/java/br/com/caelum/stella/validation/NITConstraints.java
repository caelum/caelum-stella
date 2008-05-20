package br.com.caelum.stella.validation;

import java.util.regex.Pattern;

/**
 * Número de Identificação do Trabalhador com 11 (onze) caracteres numéricos, no
 * formato XXX.XXXXX.XX-X.
 * 
 * O NIT corresponde ao número do PIS/PASEP/CI sendo que, no caso de
 * Contribuinte Individual (CI), pode ser utilizado o número de inscrição no
 * Sistema Único de Saúde (SUS) ou na Previdência Social.
 * 
 * @author Leonardo Bessa
 */
class NITConstraints {
    public static final Pattern NIT_FORMATED = Pattern
            .compile("(\\d{3})[.](\\d{5})[.](\\d{2})-(\\d{1})");
    public static final Pattern NIT_UNFORMATED = Pattern
            .compile("(\\d{3})(\\d{5})(\\d{2})(\\d{1})");
}
