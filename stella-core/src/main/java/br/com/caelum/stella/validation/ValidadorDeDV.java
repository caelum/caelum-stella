package br.com.caelum.stella.validation;

/**
 * @author Leonardo Bessa
 */
public class ValidadorDeDV {

    private final DigitoVerificadorInfo info;

    public ValidadorDeDV(DigitoVerificadorInfo info) {
        this.info = info;
    }

    public boolean isDVValid(String digitos) {
        Integer dvCandidate = Integer.parseInt(digitos.substring(info.getPosicaoDoDv() - 1, info.getPosicaoDoDv()));
        return this.generateDV(digitos).equals(dvCandidate);
    }

    private Integer generateDV(String digitos) {
        Integer[] intDigits = extractIntegerDigits(digitos);
        Integer innerProduct = innerProduct(info.getPesos(), intDigits);
        Integer result = innerProduct;
        RotinaParameters parameters = new RotinaParameters(info, intDigits, innerProduct);
        for (RotinaDeDigitoVerificador rotina : info.getRotinas()) {
            result = rotina.transform(parameters);
            parameters.setResult(result);
        }
        return result;
    }

    private Integer[] extractIntegerDigits(String digitos) {
        Integer[] intDigits = new Integer[digitos.length()];
        for (int i = 0; i < digitos.length(); i++) {
            intDigits[i] = Integer.parseInt(digitos.substring(i, i + 1));
        }
        return intDigits;
    }

    private Integer innerProduct(Integer[] a, Integer[] b) {
        Integer result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }
}
