package br.com.caelum.stella.inwords;

import java.text.DecimalFormat;

/**
 * @author Victor dos Santos Pereira
 * @author Leonardo Bessa
 * 
 */
public class NumericToWordsConverter {

    private final FormatoDeExtenso formato;

    public NumericToWordsConverter(FormatoDeExtenso formato) {
        this.formato = formato;
    }

    private String getString(String paramMessage) {
        return Messages.getString("Extenso." + paramMessage);
    }

    private String getUnit(boolean isUnitary, boolean isFraction) {
        String result;
        if (isFraction) {
            result = (isUnitary ? formato.getDecimal() : formato.getDecimais());
        } else {
            result = (isUnitary ? formato.getUnidade() : formato.getUnidades());
        }
        return result;
    }

    private String getAndSeparator() {
        return this.getString("sep");
    }

    private String getThousandSeparator(boolean isFirstGroup) {
        return (isFirstGroup ? getAndSeparator() : this
                .getString("sep.mil"));
    }

    private String getNumberInWords(int power, int algarism) {
        return this.getString(power + "." + algarism);
    }

    private String getThousandSuffixInWords(int thousandPower,
            boolean isUnitary, boolean isFraction) {
        return (thousandPower == 0 ? this.getUnit(isUnitary, isFraction) : this
                .getString("mil." + thousandPower + "."
                        + (isUnitary ? '1' : '2')));
    }

    private String getThousandBlockInWords(int number) {
        String result;
        if (number == 0) {
            result = this.getNumberInWords(0, 0);
        } else if (number == 100) {
            result = this.getNumberInWords(2, 0);
        } else {
            result = "";
            int power = 0;
            int algarism = 0;
            int actualValue = number;
            for (int i = 0; i < 3; i++) {
                // testa se são numeros de 11 a 19
                if ((i == 1) && ((actualValue % 10) == 1) && (algarism != 0)) {
                    power = 3;
                    result = "";
                } else {
                    power = i;
                    algarism = (actualValue % 10);
                }
                if (algarism != 0) {
                    if (!"".equals(result)) {
                        result = this.getAndSeparator() + result;
                    }
                    result = this.getNumberInWords(power, algarism) + result;
                }
                actualValue /= 10;
            }
        }
        return result;
    }

    private String getThousandBlockWithSuffixInWords(int thousandGroup,
            int thousandPower, boolean isUnitary, boolean isFraction) {
        String result;
        if (thousandPower == 0) {
            result = this.getThousandSuffixInWords(thousandPower, isUnitary,
                    isFraction);
        } else {
            result = this.getThousandSuffixInWords(thousandPower,
                    thousandGroup == 1, isFraction);
        }
        if ((thousandPower != 1) || (thousandGroup != 1)) {
            result = (this.getThousandBlockInWords(thousandGroup) + " " + result)
                    .trim();
        }
        return result;
    }

    private String getFullLongNumberInWords(long number, boolean isFraction) {
        String result;
        if (number == 0) {
            result = this.getThousandBlockInWords(0);
        } else {
            result = "";
            boolean isFirstThousandGroup = true;
            int thousandPower = 0;
            long currentWorkingValue = number;
            while (currentWorkingValue > 0) {
                int thousandGroup = (int) (currentWorkingValue % 1000);
                if ((thousandGroup != 0)) {
                    if (!result.equals("")) {
                        result = this
                                .getThousandSeparator(isFirstThousandGroup)
                                + result;
                        isFirstThousandGroup = false;
                    }
                    if (result.equals("") && !formato.getUnidade().equals("")) {
                        if (thousandPower > 0) {
                            result = (thousandPower == 1 ? " " : " de ")
                                    + this.getUnit(false, isFraction);
                        }
                    }
                    result = this.getThousandBlockWithSuffixInWords(
                            thousandGroup, thousandPower, currentWorkingValue == 1,
                            isFraction)
                            + result;
                }
                thousandPower++;
                currentWorkingValue /= 1000;
            }
        }
        return result;
    }

    private void validateArguments() {
        if ((formato.getUnidade() == null) || (formato.getUnidades() == null)) {
            throw new IllegalArgumentException(this
                    .getString("erro.getUnidade().nulo"));
        } else if ((formato.getDecimal() == null)
                || (formato.getDecimais() == null)) {
            throw new IllegalArgumentException(this
                    .getString("erro.getDecimal().nulo"));
        } else if ((formato.getCasasDecimais() < 0)
                || (formato.getCasasDecimais() > 6)) {
            throw new IllegalArgumentException(this
                    .getString("erro.getCasasDecimais().invalido"));
        }
    }

    private void validateLong(long number) {
        if (number < 0) {
            throw new IllegalArgumentException(this
                    .getString("erro.numero.negativo"));
        }
    }

    private void validateDouble(double number) {
        if (number < 0) {
            throw new IllegalArgumentException(this
                    .getString("erro.numero.negativo"));
        }
        if (number > Long.MAX_VALUE) {
            throw new IllegalArgumentException(this
                    .getString("erro.numero.maior.que.long"));
        }
    }

    public String toWords(long numero) {
        this.validateArguments();
        this.validateLong(numero);
        return this.getFullLongNumberInWords(numero, false);
    }

    public String toWords(long inteiro, long fracionado) {
        if (Long.valueOf(fracionado).toString().length() > formato
                .getCasasDecimais()) {
            throw new IllegalArgumentException(this
                    .getString("erro.numero.casas.excedido"));
        }
        String result = "";
        if (inteiro != 0 || fracionado == 0) {
            result = this.toWords(inteiro);
        }
        if (inteiro != 0 && fracionado != 0) {
            result += getAndSeparator();
        }
        if (fracionado != 0) {
            this.validateLong(fracionado);
            result += this.getFullLongNumberInWords(fracionado, true);
        }
        return result;
    }

    public String toWords(double number) {

        // valida se o numero é maior que long
        this.validateDouble(number);

        // formata o numero no padrao: 0.0###### e o separa em duas partes
        final DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.applyPattern("0.0######");
        final char decimalSeparator = decimalFormat.getDecimalFormatSymbols()
                .getDecimalSeparator();
        String[] parts = (decimalFormat.format(number)).split("["
                + decimalSeparator + "]");

        // se a parte fracionada for "0" altera para ""
        parts[1] = (parts[1].equals("0") ? "" : parts[1]);

        // verifica se parte Inteira + parte Fracionada tem mais algarismos
        // significativos que o permitido
        if (parts[0].length() + parts[1].length() > 15) {
            throw new IllegalArgumentException(this
                    .getString("erro.numero.muito.grande"));
        }

        // formata o fracionado com o numero de casas decimais especificas
        for (int i = parts[1].length(); i < formato.getCasasDecimais(); i++) {
            parts[1] += "0";
        }

        // retorna o extenso passando os parametros: parte inteira e fracionada
        return this.toWords(Long.parseLong(parts[0]), Long.parseLong(parts[1]));
    }

}