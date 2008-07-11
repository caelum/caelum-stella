package br.com.caelum.stella.inwords;

/**
 * @author Victor Santos
 * @author Leonardo Bessa
 */
public class DimensionlessNumericToWordsConverter implements
        NumericCardinalToWordsConverter {

    private boolean fracionado;
    private String unidade = "";
    private String unidades = "";
    private String decimal = "";
    private String decimais = "";
    
    public String toWords(double number) {
        String result;
        if (number < 0) {
            throw new IllegalArgumentException();
        } else if (number == 0) {
            result = this.thousandBlocktoWords((int) number);
        } else {
            result = "";
            int seq = 0;
            int thousandBlockPosition = 0;
            while (number > 0) {
                int thousandBlockValue = (int) (number % 1000);
                if ((thousandBlockValue != 0)) {
                    if (!result.isEmpty()) {
                        result = this.getSeparadorMilhar(seq) + result;
                        seq++;
                    }
                    result = getNomeParcial(thousandBlockValue,
                            thousandBlockPosition)
                            + result;
                }
                thousandBlockPosition++;
                number /= 1000;
            }
        }
        return result;
    }

    private String thousandBlocktoWords(int number) {
        String result;
        if ((number < 0) || (number > 999)) {
            throw new IllegalArgumentException();
        } else if (number == 0) {
            result = this.getNomeNumero(0, 0);
        } else if (number == 100) {
            result = this.getNomeNumero(2, 0);
        } else {
            result = "";
            int pot = 0;
            int pos = 0;
            for (int i = 0; i < 3; i++) {
                if ((i == 1) && ((number % 10) == 1) && (pos != 0)) {
                    pot = 3;
                    result = "";
                } else {
                    pot = i;
                    pos = (number % 10);
                }
                if (pos != 0) {
                    if (!result.equals("")) {
                        result = this.getSeparador() + result;
                    }
                    result = this.getNomeNumero(pot, pos) + result;
                }
                number /= 10;
            }
        }
        return result;
    }

    private String getSeparadorMilhar(int seq) {
        return (seq == 0 ? getSeparador() : Messages
                .getString("Extenso.sep.mil"));
    }

    private String getNomeParcial(int thousandBlockValue,
            int thousandBlockPosition) {
        String result;
        result = this.getNomeMilhar(thousandBlockPosition,
                thousandBlockValue == 1);
        if ((thousandBlockPosition != 1) || (thousandBlockValue != 1)) {
            result = (this.thousandBlocktoWords(thousandBlockValue) + ' ' + result)
                    .trim();
        }
        return result;
    }

    private String getSeparador() {
        return Messages.getString("Extenso.sep");
    }

    private String getNomeNumero(int pot, int positon) {
        return Messages.getString("Extenso." + pot + '.' + positon);
    }

    private String getNomeMilhar(int potMil, boolean isUnitario) {
        return (potMil == 0 ? this.getGrandeza(isUnitario) : Messages
                .getString("Extenso.mil." + potMil + '.'
                        + (isUnitario ? '1' : '2')));
    }

    

    private String getGrandeza(boolean isUnitario) {
        return (isUnitario ? (this.fracionado ? this.decimal : this.unidade)
                : (this.fracionado ? this.decimais : this.unidades));
    }

}
