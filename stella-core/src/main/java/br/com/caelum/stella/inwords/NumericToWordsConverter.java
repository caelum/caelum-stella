package br.com.caelum.stella.inwords;


/**
 * @author Victor dos Santos Pereira
 * @author Leonardo Bessa
 * 
 */
public class NumericToWordsConverter {

	private FormatoDeExtenso formato;

	public NumericToWordsConverter(FormatoDeExtenso formato) {
		this.formato = formato;
	}

	private String getUnit(boolean isUnitary, boolean isFraction) {
		return (isFraction ? (isUnitary ? formato.getDecimal() : formato
				.getDecimais()) : (isUnitary ? formato.getUnidade() : formato
				.getUnidades()));
	}

	private String getAndSeparator() {
		return Messages.getString("Extenso.sep");
	}

	private String getThousandSeparator(boolean firstThousandGroup) {
		return (firstThousandGroup ? getAndSeparator() : getThousandSepator());
	}

	private String getThousandSepator() {
		return Messages.getString("Extenso.sep.mil");
	}

	private String getNumberInWords(int power, int algarism) {
		return Messages.getString("Extenso." + power + '.' + algarism);
	}

	private String getThousandSuffixInWords(int millionPower,
			boolean isUnitary, boolean isFraction) {
		return (millionPower == 0 ? this.getUnit(isUnitary, isFraction)
				: Messages.getString("Extenso.mil." + millionPower + '.'
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
			for (int i = 0; i < 3; i++) {
				if ((i == 1) && ((number % 10) == 1) && (algarism != 0)) {// trata
					// 11 a
					// 19
					power = 3;
					result = "";
				} else {
					power = i;
					algarism = (number % 10);
				}
				if (algarism != 0) {
					if (!result.equals("")) {
						result = this.getAndSeparator() + result;
					}
					result = this.getNumberInWords(power, algarism) + result;
				}
				number /= 10;
			}
		}
		return result;
	}

	private String getThousandBlockWithSuffixInWords(int number,
			int millionPower, boolean isFraction) {
		String result;
		result = this.getThousandSuffixInWords(millionPower, number == 1,
				isFraction);
		if ((millionPower != 1) || (number != 1)) {
			result = (this.getThousandBlockInWords(number) + ' ' + result)
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
			int potMil = 0;
			while (number > 0) {
				int n = (int) (number % 1000);
				if ((n != 0)) {
					if (!result.equals("")) {
						result = this
								.getThousandSeparator(isFirstThousandGroup)
								+ result;
						isFirstThousandGroup = false;
					}
					if ((result.equals(""))
							&& (!formato.getUnidade().equals(""))) {
						if (potMil > 0) {
							result = (potMil == 1 ? ' ' : " de ")
									+ this.getUnit(false, isFraction);
						}
					}
					result = this.getThousandBlockWithSuffixInWords(n, potMil,
							isFraction)
							+ result;
				}
				potMil++;
				number /= 1000;
			}
		}
		return result;
	}

	private void validateLong(long num) {
		if (num < 0) {
			throw new IllegalArgumentException(Messages
					.getString("Extenso.erro.numero.negativo"));
		}
	}

	private void validateDouble(double num) {
		if (num > Long.MAX_VALUE) {
			throw new IllegalArgumentException(Messages
					.getString("Extenso.erro.numero.maior.que.long"));
		}
	}

	private void validateArguments() {
		if ((formato.getUnidade() == null) || (formato.getUnidades() == null)) {
			throw new IllegalArgumentException(Messages
					.getString("Extenso.erro.getUnidade().nulo"));
		} else if ((formato.getDecimal() == null)
				|| (formato.getDecimais() == null)) {
			throw new IllegalArgumentException(Messages
					.getString("Extenso.erro.getDecimal().nulo"));
		} else if ((formato.getCasasDecimais() < 0)
				|| (formato.getCasasDecimais() > 6)) {
			throw new IllegalArgumentException(Messages
					.getString("Extenso.erro.getCasasDecimais().invalido"));
		}
	}

	public String toWords(long number) {
		this.validateLong(number);
		this.validateArguments();
		return this.getFullLongNumberInWords(number, false);
	}

	public String toWords(double number) {
		this.validateDouble(number);
		long longValue = (long) number;
		String longInWords = this.toWords(longValue);

		String[] partes = (new Double(number)).toString().split("[.]");
		String fractionString;
		if (partes.length == 2) {
			fractionString = partes[1];
		} else {
			fractionString = "0";
		}

		if (fractionString.length() > formato.getCasasDecimais()) {
			throw new IllegalArgumentException(
					"O numero excede a quantida de casas decimais permitidas"
							+ " para o formato especificado.");
		}
		
		for (int i = fractionString.length(); i <  formato.getCasasDecimais(); i ++){
			fractionString += "0";
		}

		long fractionValue = Long.parseLong(fractionString);

		String fractionInWords = this.getFullLongNumberInWords(fractionValue,
				true);

		String result = "";
		if ((longValue == 0 && fractionValue == 0)) {
			result = longInWords;
		} else if (longValue != 0) {
			result = longInWords;
		}

		if (longValue != 0 && fractionValue != 0) {
			result += getAndSeparator();
		}

		if (fractionValue != 0) {
			result += fractionInWords;
		}

		return result;
	}

}