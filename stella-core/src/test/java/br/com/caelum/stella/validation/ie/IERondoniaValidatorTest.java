package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;

public class IERondoniaValidatorTest extends IEValidatorTest {

	public IERondoniaValidatorTest() {
		super(wrongCheckDigitUnformatted, validUnformattedString, validFormattedString, validValues);
	}

	private static final String wrongCheckDigitUnformatted = "00000001721489";

	private static final String validUnformattedString = "00000001721488";

	private static final String validFormattedString = "0000000172159-3";

	private static final String[] validValues = { "0000000172159-3", "0000000172158-5", "0000000172157-7",
			"0000000172109-7", "0000000172156-9", "0000000172154-2", "0000000172155-1", "0000000172153-4",
			"0000000172152-6", "0000000172151-8", "0000000172128-3", "0000000172126-7", "0000000172150-0",
			"0000000172149-6", "0000000172148-8", "0000000172147-0", "0000000172146-1", "0000000172145-3",
			"0000000058712-5", "0000000172131-3", "0000000043700-0", "0000000050046-1", "0000000058712-5",
			"0000000172131-3", "0000000172144-5", "0000000172143-7", "0000000011784-6", "0000000002146-6"};

	@Override
	protected Validator<String> getValidator(MessageProducer messageProducer, boolean isFormatted) {
		return new IERondoniaValidator(messageProducer, isFormatted);
	}
}
