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

    public String toWords(long numero) {
        return toWords((double) numero);
    }

    public String toWords(double number) {
        StringBuffer result = new StringBuffer();
        if (number == 0) {
            result.append(getNumber(0));
        } else {

            final StringBuffer pattern = new StringBuffer();
            pattern.append("###,000.");
            for (int i = 1; i <= formato.getCasasDecimais(); i++) {
                pattern.append("0");
            }
            DecimalFormat decimalFormat = new DecimalFormat(pattern.toString());
            String formatted = decimalFormat.format(number);
            String[] parts = formatted.split("[.]");
            String formattedInt = parts[0];
            String formattedMod = parts[1];
            String[] ints = formattedInt.split("[,]");
            ThousandBlock[] blocks = new ThousandBlock[ints.length];
            for (int i = 0; i < blocks.length; i++) {
                String block = ints[i];
                blocks[i] = new ThousandBlock(block);
            }
            ThousandBlock modBlock = new ThousandBlock(formattedMod);
            boolean hasMod = !modBlock.isZero();
            boolean hasInteger = (blocks.length > 1)
                    || (!blocks[blocks.length - 1].isZero());

            if (hasInteger) {
                appendIntegers(result, blocks);
                appendIntegersUnits(number, result, blocks);
            }
            if (hasInteger && hasMod) {
                result.append(getAndSeparator());
            }
            if (hasMod) {
                appendIntegers(result, modBlock);
                result.append(" ");
                if (modBlock.isUnitary()) {
                    result.append(formato.getDecimal());
                } else {
                    result.append(formato.getDecimais());
                }
            }
        }
        return result.toString();
    }

    private void appendIntegersUnits(double number, StringBuffer result,
            ThousandBlock[] blocks) {
        if (blocks.length != 1 || !blocks[0].isZero()) {
            result.append(" ");
            if (number >= 2) {
                int length = blocks.length;
                if (length > 2 && blocks[length - 1].isZero()
                        && blocks[length - 2].isZero()) {
                    result.append("de ");
                }
                result.append(formato.getUnidades());
            } else {
                result.append(formato.getUnidade());
            }
        }
    }

    private void appendIntegers(StringBuffer result, ThousandBlock... blocks) {
        boolean hasStarted = false;
        for (int i = 0; i < blocks.length; i++) {
            ThousandBlock thousandBlock = blocks[i];
            if (!(hasStarted && thousandBlock.isZero())) {
                int thousandPower = (blocks.length - i - 1);
                if (hasStarted) {
                    if (thousandBlock.isUnitary()) {
                        result.append(getAndSeparator());
                    } else {
                        if (thousandPower < 1) {
                            result.append(getAndSeparator());
                        } else {
                            result.append(getThousandSeparator());
                        }
                    }
                }

                result.append(thousandBlock.toWords());

                if (thousandPower > 0) {
                    result.append(" ");
                    result.append(this.getString("1e"
                            + 3
                            * thousandPower
                            + "."
                            + (thousandBlock.isUnitary() ? "singular"
                                    : "plural")));
                }
                hasStarted = true;
            }
        }
    }

    private final class ThousandBlock {

        private int numberValue;

        public ThousandBlock(String number) {
            super();
            if (number.length() > 3) {
                throw new IllegalArgumentException(
                        "ThousandBlock deve conter numeros"
                                + " de no maximo 3 digitos.");
            }
            this.numberValue = Integer.parseInt(number);
        }

        public boolean isZero() {
            return numberValue == 0;
        }

        public boolean isUnitary() {
            return numberValue == 1;
        }

        public String toWords() {
            String result;
            if (numberValue <= 20) {
                result = NumericToWordsConverter.this.getNumber(numberValue);
            } else if (numberValue <= 99) {
                int d = numberValue / 10;
                int u = numberValue % 10;
                String dezena = NumericToWordsConverter.this.getNumber(d * 10);
                if (u == 0) {
                    result = dezena;
                } else {
                    String unidade = NumericToWordsConverter.this.getNumber(u);
                    result = dezena + getAndSeparator() + unidade;
                }
            } else if (numberValue == 100) {
                result = NumericToWordsConverter.this.getNumber(100);
            } else {
                int c = (numberValue / 100) * 100;
                String centena;
                if (c == 100) {
                    centena = NumericToWordsConverter.this.getString("100+?");
                } else {
                    centena = NumericToWordsConverter.this.getNumber(c);
                }
                int resto = numberValue % 100;
                if (resto == 0) {
                    result = centena;
                } else {
                    result = centena + getAndSeparator()
                            + getThousandBlockInWords("" + resto);
                }
            }
            return result;
        }

    }

    private String getThousandSeparator() {
        return getString("sep.mil");
    }

    private String getAndSeparator() {
        return getString("sep");
    }

    private String getString(String paramMessage) {
        return Messages.getString("Extenso." + paramMessage);
    }

    private String getNumber(int number) {
        DecimalFormat formater = new DecimalFormat();
        formater.applyPattern("000");
        String formatted = formater.format(number);
        return Messages.getString("Extenso." + formatted);
    }

    private String getThousandBlockInWords(String number) {

        String result;
        int value = Integer.parseInt(number);
        if (value <= 20) {
            result = this.getNumber(value);
        } else if (value <= 99) {
            int d = value / 10;
            int u = value % 10;
            String dezena = this.getNumber(d * 10);
            if (u == 0) {
                result = dezena;
            } else {
                String unidade = this.getNumber(u);
                result = dezena + getAndSeparator() + unidade;
            }
        } else if (value == 100) {
            result = this.getNumber(100);
        } else {
            int c = (value / 100) * 100;
            String centena = (c == 100) ? this.getString("100+?") : this
                    .getNumber(c);
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
}