package br.com.caelum.stella.inwords;

import java.text.DecimalFormat;

import br.com.caelum.stella.format.Formatter;

/**
 * @author Victor dos Santos Pereira
 * @author Leonardo Bessa
 * 
 */
public class NumericToWordsConverter implements Formatter {

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
        return (isFirstGroup ? getAndSeparator() : this.getString("sep.mil"));
    }

    private String getThousandSuffixInWords(int thousandPower,
            boolean isUnitary, boolean isFraction) {
        return (thousandPower == 0 ? this.getUnit(isUnitary, isFraction) : this
                .getString("mil." + thousandPower + "."
                        + (isUnitary ? '1' : '2')));
    }

    private String getThousandBlockInWords(String number) {
        if (number.length() > 3) {
            throw new IllegalArgumentException(
                    "O número está fora do intervalo pemitido [0,999].");
        }
        String result;
        int value = Integer.parseInt(number);
        if (value <= 20) {
            result = Messages.getString("Extenso." + number);
        } else if (value <= 99) {
            int d = value / 10;
            int u = value % 10;
            String dezena = Messages.getString("Extenso." + d * 10);
            if (u == 0) {
                result = dezena;
            } else {
                String unidade = Messages.getString("Extenso." + u);
                result = dezena + getAndSeparator() + unidade;
            }
        } else if (value == 100) {
            result = Messages.getString("Extenso.100");
        } else {
            int c = (value / 100) * 100;
            String centena = (c == 100) ? Messages.getString("Extenso.100+?")
                    : Messages.getString("Extenso." + c);
            int resto = value % 100;
            if (resto == 0) {
                result = centena;
            } else {
                result = centena + getAndSeparator()
                        + getThousandBlockInWords("" + resto);
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
            result = (this.getThousandBlockInWords(""+thousandGroup) + " " + result)
                    .trim();
        }
        return result;
    }

    private String getFullLongNumberInWords(long number, boolean isFraction) {
        String result;
        if (number == 0) {
            result = this.getThousandBlockInWords("0");
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
                            thousandGroup, thousandPower,
                            currentWorkingValue == 1, isFraction)
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
            throw new IllegalArgumentException(
                    "Retorno de getUnidade() não pode ser nulo");
        } else if ((formato.getDecimal() == null)
                || (formato.getDecimais() == null)) {
            throw new IllegalArgumentException(
                    "Retorno de getDecimal() não pode ser nulo");
        } else if ((formato.getCasasDecimais() < 0)
                || (formato.getCasasDecimais() > 6)) {
            throw new IllegalArgumentException(
                    "Retorno de getCasasDecimais() inválido");
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
            throw new IllegalArgumentException("Número negativo não permitido");
        }
        if (number > Long.MAX_VALUE) {
            throw new IllegalArgumentException("Número maior que o permitido");
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
            throw new IllegalArgumentException(
                    "Quantidade de algarismos significativos excede o permitido.");
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
            throw new IllegalArgumentException(
                    "O numero excede a quantidade de casas decimais permitidas para o formato especificado");
        }

        // formata o fracionado com o numero de casas decimais especificas
        for (int i = parts[1].length(); i < formato.getCasasDecimais(); i++) {
            parts[1] += "0";
        }

        // retorna o extenso passando os parametros: parte inteira e fracionada
        return this.toWords(Long.parseLong(parts[0]), Long.parseLong(parts[1]));
    }

    public String format(String value) {
        return null;
    }

    public String unformat(String value) {
        return null;
    }

}