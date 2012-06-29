package flexUnitTests
{
	import br.com.caelum.stella.format.LeftSideZerosFormatterTest;
	import br.com.caelum.stella.validation.ie.IEAcreValidatorTest;
	import br.com.caelum.stella.validation.ie.IEAlagoasValidatorTest;
	import br.com.caelum.stella.validation.ie.IEAmapaValidatorTest;
	import br.com.caelum.stella.validation.ie.IEAmazonasValidatorTest;
	import br.com.caelum.stella.validation.ie.IEBahiaValidatorTest;
	import br.com.caelum.stella.validation.ie.IECearaValidatorTest;
	import br.com.caelum.stella.validation.ie.IEDistritoFederalValidatorTest;
	import br.com.caelum.stella.validation.ie.IEEspiritoSantoValidatorTest;
	import br.com.caelum.stella.validation.ie.IEGoiasValidatorTest;
	import br.com.caelum.stella.validation.ie.IEMaranhaoValidatorTest;
	import br.com.caelum.stella.validation.ie.IEMatoGrossoDoSulValidatorTest;
	import br.com.caelum.stella.validation.ie.IEMatoGrossoValidatorTest;
	import br.com.caelum.stella.validation.ie.IEMinasGeraisValidatorTest;
	import br.com.caelum.stella.validation.ie.IEParaValidatorTest;
	import br.com.caelum.stella.validation.ie.IEParaibaValidatorTest;
	import br.com.caelum.stella.validation.ie.IEParanaValidatorTest;
	import br.com.caelum.stella.validation.ie.IEPernambucoAntigaValidatorTest;
	import br.com.caelum.stella.validation.ie.IEPernambucoNovaValidatorTest;
	import br.com.caelum.stella.validation.ie.IEPernambucoValidatorAntigoFormatoTest;
	import br.com.caelum.stella.validation.ie.IEPernambucoValidatorNovoFormatoTest;
	import br.com.caelum.stella.validation.ie.IEPiauiValidatorTest;
	import br.com.caelum.stella.validation.ie.IERioDeJaneiroValidatorTest;
	import br.com.caelum.stella.validation.ie.IERioGrandeDoNorteValidatorTest;
	import br.com.caelum.stella.validation.ie.IERioGrandeDoSulValidatorTest;
	import br.com.caelum.stella.validation.ie.IERondoniaValidatorCasoDoisTest;
	import br.com.caelum.stella.validation.ie.IERondoniaValidatorCasoUmTest;
	import br.com.caelum.stella.validation.ie.IERondoniaValidatorFormatoDoisTest;
	import br.com.caelum.stella.validation.ie.IERondoniaValidatorFormatoUmTest;
	import br.com.caelum.stella.validation.ie.IERoraimaValidatorTest;
	import br.com.caelum.stella.validation.ie.IESantaCatarinaValidatorTest;
	import br.com.caelum.stella.validation.ie.IESaoPauloComercioIndustriaValidatorTest;
	import br.com.caelum.stella.validation.ie.IESaoPauloProdutorRuralValidatorTest;
	import br.com.caelum.stella.validation.ie.IESaoPauloValidatorComercioIndustriaTest;
	import br.com.caelum.stella.validation.ie.IESaoPauloValidatorProdutorRuralTest;
	import br.com.caelum.stella.validation.ie.IESergipeValidatorTest;
	import br.com.caelum.stella.validation.ie.IETocantinsAntigaValidatorTest;
	import br.com.caelum.stella.validation.ie.IETocantinsNovaValidatorTest;
	import br.com.caelum.stella.validation.ie.IETocantinsValidatorAntigaTest;
	import br.com.caelum.stella.validation.ie.IETocantinsValidatorNovaTest;

	[Suite]
	[RunWith("org.flexunit.runners.Suite")]
	public class AllTests {
		public var leftSideZerosFormatterTest:LeftSideZerosFormatterTest;
		public var ieAcreValidatorTest:IEAcreValidatorTest;
		public var ieAlagoasValidatorTest:IEAlagoasValidatorTest;
		public var ieAmapaValidatorTest:IEAmapaValidatorTest;
		public var ieAmazonasValidatorTest:IEAmazonasValidatorTest;
		public var ieBahiaValidatorTest:IEBahiaValidatorTest;
		public var ieCearaValidatorTest:IECearaValidatorTest;
		public var ieDistritoFederalValidatorTest:IEDistritoFederalValidatorTest;
		public var ieEspiritoSantoValidatorTest:IEEspiritoSantoValidatorTest;
		public var ieGoiasValidatorTest:IEGoiasValidatorTest;
		public var ieMaranhaoValidatorTest:IEMaranhaoValidatorTest;
		public var ieMatoGrossoDoSulValidatorTest:IEMatoGrossoDoSulValidatorTest;
		public var ieMatoGrossoValidatorTest:IEMatoGrossoValidatorTest;
		public var ieMinasGeraisValidatorTest:IEMinasGeraisValidatorTest;
		public var ieParaibaValidatorTest:IEParaibaValidatorTest;
		public var ieParanaValidatorTest:IEParanaValidatorTest;
		public var ieParaValidatorTest:IEParaValidatorTest;
		public var iePernambucoAntigaValidatorTest:IEPernambucoAntigaValidatorTest;
		public var iePernambucoNovaValidatorTest:IEPernambucoNovaValidatorTest;
		public var iePernambucoValidatorAntigoFormatoTest:IEPernambucoValidatorAntigoFormatoTest;
		public var iePernambucoValidatorNovoFormatoTest:IEPernambucoValidatorNovoFormatoTest;		
		public var iePiauiValidatorTest:IEPiauiValidatorTest;
		public var ieRioDeJaneiroValidatorTest:IERioDeJaneiroValidatorTest;
		public var ieRioGrandeDoNorteValidatorTest:IERioGrandeDoNorteValidatorTest;
		public var ieRioGrandeDoSulValidatorTest:IERioGrandeDoSulValidatorTest;
		public var ieRondoniaValidatorCasoDoisTest:IERondoniaValidatorCasoDoisTest;
		public var ieRondoniaValidatorCasoUmTest:IERondoniaValidatorCasoUmTest;
		public var ieRondoniaValidatorFormatoDoisTest:IERondoniaValidatorFormatoDoisTest;
		public var ieRondoniaValidatorFormatoUmTest:IERondoniaValidatorFormatoUmTest;		
		public var ieRoraimaValidatorTest:IERoraimaValidatorTest;
		public var ieSantaCatarinaValidatorTest:IESantaCatarinaValidatorTest;
		public var ieSaoPauloComercioIndustriaValidatorTest:IESaoPauloComercioIndustriaValidatorTest;
		public var ieSaoPauloProdutorRuralValidatorTest:IESaoPauloProdutorRuralValidatorTest;
		public var ieSaoPauloValidatorComercioIndustriaTest:IESaoPauloValidatorComercioIndustriaTest;
		public var ieSaoPauloValidatorProdutorRuralTest:IESaoPauloValidatorProdutorRuralTest;				
		public var ieSergipeValidatorTest:IESergipeValidatorTest;
		public var ieTocantinsAntigaValidatorTest:IETocantinsAntigaValidatorTest;
		public var ieTocantinsNovaValidatorTest:IETocantinsNovaValidatorTest;
		public var ieTocantinsValidatorAntigaTest:IETocantinsValidatorAntigaTest;
		public var ieTocantinsValidatorNovaTest:IETocantinsValidatorNovaTest;
	}
}