package br.com.caelum.stella.inwords;

import br.com.caelum.stella.annotations.GwtCompatible;
import com.google.gwt.i18n.client.NumberFormat;

import java.util.MissingResourceException;

/**
 * Responsável por transformar um número em sua representação por extenso.
 *
 * Portabilidade da classe original para GWT
 *
 * @author Danilo Reinert
 *
 * Classe Original
 *
 * @author Victor dos Santos Pereira
 * @author Leonardo Bessa
 * 
 */
@GwtCompatible(emulated = true)
public class NumericToWordsConverter {

    private final FormatoDeExtenso formato;

    /**
     * @param formato
     *            formato desejado para a transfomação por extenso
     */
    public NumericToWordsConverter(FormatoDeExtenso formato) {
        this.formato = formato;
    }

    /**
     * @param number
     *            número a ser transformado
     * @return Representação do número por extenso.
     */
    public String toWords(long number) {
        try {
            if (number < 0) {
                throw new IllegalArgumentException("Não é possível transformar números negativos.");
            }
            StringBuffer result = new StringBuffer();
            if (number == 0) {
                result.append(getNumber(0));
            } else {
                NumberFormat formatter = NumberFormat.getFormat("###,###");
                String formattedInt = formatter.format(number).replace(",",".");
                String[] ints = formattedInt.split("[,]");
                ThousandBlock[] blocks = new ThousandBlock[ints.length];
                for (int i = 0; i < blocks.length; i++) {
                    String block = ints[i];
                    blocks[i] = new ThousandBlock(block);
                }

                appendIntegers(result, blocks);
                appendIntegersUnits(number, result, blocks);
            }
            return result.toString();
        } catch (MissingResourceException e) {
            throw new IllegalArgumentException("Número muito grande para ser transformado em extenso.");
        }
    }

    /**
     * @param number
     *            número a ser transformado
     * @return Representação do número por extenso.
     */
    public String toWords(double number) {
        try {
            if (number < 0) {
                throw new IllegalArgumentException("Não é possível transformar números negativos.");
            }
            StringBuffer result = new StringBuffer();
            if (number == 0) {
                result.append(getNumber(0));
            } else {

                String[] parts = split(number);
                String formattedInt = parts[0];
                String[] ints = formattedInt.split("[,]");
                ThousandBlock[] blocks = new ThousandBlock[ints.length];
                for (int i = 0; i < blocks.length; i++) {
                    String block = ints[i];
                    blocks[i] = new ThousandBlock(block);
                }
                String formattedMod = parts[1];
                ThousandBlock modBlock = new ThousandBlock(formattedMod);

                boolean hasMod = !modBlock.isZero();
                boolean hasInteger = (blocks.length > 1) || (!blocks[blocks.length - 1].isZero());

                if (hasInteger) {
                    appendIntegers(result, blocks);
                    appendIntegersUnits(number, result, blocks);
                }
                if (hasInteger && hasMod) {
                    result.append(getAndSeparator());
                }
                if (hasMod) {
                    appendIntegers(result, modBlock);
                    appendDecimalUnits(result, modBlock);
                }
            }
            return result.toString();
        } catch (MissingResourceException e) {
            throw new IllegalArgumentException("Número muito grande para ser transformado em extenso.");
        }
    }

    private void appendDecimalUnits(StringBuffer result, ThousandBlock modBlock) {
        result.append(" ");
        if (modBlock.isUnitary()) {
            result.append(formato.getUnidadeDecimalNoSingular());
        } else {
            result.append(formato.getUnidadeDecimalNoPlural());
        }
    }

    private String[] split(double number) {
        final StringBuilder pattern = new StringBuilder();
        pattern.append("###,000.");
        for (int i = 1; i <= formato.getCasasDecimais(); i++) {
            pattern.append("0");
        }
        NumberFormat decimalFormat = NumberFormat.getFormat(pattern.toString());
        String formatted = decimalFormat.format(number).replace(".","@").replace(",",".").replace("@",",");
        String[] parts = formatted.split("[.]");
        return parts;
    }

    private void appendIntegersUnits(double number, StringBuffer result, ThousandBlock[] blocks) {
        if (blocks.length != 1 || !blocks[0].isZero()) {
            if (number >= 2) {
                String unit = formato.getUnidadeInteiraNoPlural();
                if( !unit.isEmpty() ) {
                    result.append(" ");
                    int length = blocks.length;
                	if (length > 2 && blocks[length - 1].isZero() && blocks[length - 2].isZero()) {
                        result.append("de ");
                    }
                	result.append(unit);
                }
            } else {
                String unit = formato.getUnidadeInteiraNoSingular();
                if( !unit.isEmpty() ) {
                    result.append(" ").append(unit);
                }
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
                    result.append(this.getString("1e" + 3 * thousandPower + "."
                            + (thousandBlock.isUnitary() ? "singular" : "plural")));
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
                throw new IllegalArgumentException("ThousandBlock deve conter numeros" + " de no maximo 3 digitos.");
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
                result = getNumberUnder100(numberValue);
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
                    result = centena + getAndSeparator() + getNumberUnder100(resto);
                }
            }
            return result;
        }

        private String getNumberUnder100(int number) {
            String result = null;
            if (number <= 20) {
                result = getNumber(number);
            } else if (number <= 99) {
                int d = number / 10;
                int u = number % 10;
                String dezena = getNumber(d * 10);
                if (u == 0) {
                    result = dezena;
                } else {
                    String unidade = getNumber(u);
                    result = dezena + getAndSeparator() + unidade;
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
        NumberFormat formater = NumberFormat.getFormat("000");
        String formatted = formater.format(number).replace(",",".");
        return Messages.getString("Extenso." + formatted);
    }
}