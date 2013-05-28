package br.com.caelum.stella.validation.ie
{
	import br.com.caelum.stella.MessageProducer;
	import br.com.caelum.stella.exceptions.InvalidStateException;
	import br.com.caelum.stella.validation.StellaValidator;
	
	import org.flexunit.asserts.assertEquals;
	import org.flexunit.asserts.assertTrue;
	import org.flexunit.asserts.fail;

	public class IEMatoGrossoValidatorTest extends IEValidatorTest {
		
		/*
		* IE validas 0013193686-7 0013053551-6 0013056071-5 0013076269-5
		* 0013015257-9 0013125061-2 0013146383-7 0013151173-4 0013198869-7
		* 0013198868-9 0013191575-4 0013178718-7 0013191879-6 0013197541-2
		* 0013197542-0 0013197556-0 0013198333-4 0013198870-0 0013198872-7
		* 0013205160-5 0013199075-6 0013199463-8 0013198871-9 0013199464-6
		* 0013210743-0 0013211337-6 0013210747-3 0013236559-6 0013236558-8
		* 0013241890-8 0013246644-9 0013256554-4 0013284135-5 0013286376-6
		* 0013286372-3 "133357406", "133296598", "133252388", "133217795",
		* "133166317", "133159868", "133142531", "133118649", "133070255",
		* "133069737", "133048306", "133034860", "132941201", "132907224",
		* "132839245", "132814145", "132779277", "132656922", "132631946",
		* "132624354", "132602741", "132498766", "132470985", "132411598",
		* "132275864", "1303656300", "1302342000", "1301815443", "1301815419",
		* "1301815370", "1301815354", "1301815346", "1301815338", "1301815320",
		* "1301815311", "1301815303", "1301815290", "1301815281", "1301815273",
		* "1301815265", "1301815257", "1301815249", "1301815230", "1301815222",
		* "1301815214", "1301815206", "1301815192", "1301815184", "1301815176",
		* "1301815168"
		*/
		private static const wrongCheckDigitString:String = '00132466444';
		
		// Este validador permite de 8 a 10 caracteres!!!
		private static const validUnformattedString:String = '130152579';
		private static const validFormattedString:String = '0013198872-7';
		private static const validValues:Array = ['0013193686-7', '0013193686-7', '0013053551-6', '0013056071-5',
			'0013076269-5', '0013015257-9', '0013125061-2', '0013146383-7', '0013151173-4', '0013198869-7',
			'0013198868-9', '0013191575-4', '0013178718-7', '0013191879-6', '0013197541-2', '0013197542-0',
			'0013197556-0', '0013198333-4', '0013198870-0', '0013198872-7', '0013205160-5', '0013199075-6',
			'0013199463-8', '0013198871-9', '0013199464-6', '0013210743-0', '0013211337-6', '0013210747-3',
			'0013236559-6', '0013236558-8', '0013241890-8', '0013246644-9', '0013256554-4', '0013284135-5',
			'0013286376-6', '0013286372-3', '13335740-6', '13329659-8', '13325238-8', '13321779-5', '13316631-7',
			'13315986-8', '13314253-1', '13311864-9', '13307025-5', '13306973-7', '13304830-6', '13303486-0',
			'13294120-1', '13290722-4', '13283924-5', '13281414-5', '13277927-7', '13265692-2', '13263194-6',
			'13262435-4', '13260274-1', '13249876-6', '13247098-5', '13241159-8', '13227586-4', '130365630-0',
			'130234200-0', '130181544-3', '130181541-9', '130181537-0', '130181535-4', '130181534-6', '130181533-8',
			'130181532-0', '130181531-1', '130181530-3', '130181529-0', '130181528-1', '130181527-3', '130181526-5',
			'130181525-7', '130181524-9', '130181523-0', '130181522-2', '130181521-4', '130181520-6', '130181519-2',
			'130181518-4', '130181517-6', '130181516-8'];
		
		public function IEMatoGrossoValidatorTest() {
			super(wrongCheckDigitString, validUnformattedString, validFormattedString, validValues);
		}
		
		override protected function getValidator(messageProducer:MessageProducer, isFormatted:Boolean):StellaValidator {
			return new IEMatoGrossoValidator(isFormatted,  messageProducer);
		}
		
		// Este validador permite de 8 a 10 caracteres, por isso este metodo
		// precisou ser sobrescrito
		override public function shouldNotValidateIEWithMoreDigitsThanAlowed():void {
			_messageProducer.expects('getMessage').times(1).withArg(IEErrors.INVALID_DIGITS);
			
			var validator:StellaValidator = getValidator(_messageProducer, false);
			
			try {
				var value:String = validUnformattedString + '578';
				validator.assertValid(value);
				fail();
			} catch(e:InvalidStateException) {
				assertEquals(1, e.invalidMessages.length);
			}
			
			assertTrue(_messageProducer.errorMessage(), _messageProducer.success());
		}
		

	}
}