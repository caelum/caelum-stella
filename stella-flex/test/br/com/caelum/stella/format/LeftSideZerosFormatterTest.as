package br.com.caelum.stella.format
{
	import org.flexunit.asserts.assertEquals;

	public class LeftSideZerosFormatterTest {
		
		[Test]
		public function testFormat():void {
			var formatter:LeftSideZerosFormatter = new LeftSideZerosFormatter(14);
			var actual:String = formatter.format('1234567890');
			assertEquals('00001234567890', actual);
		}
		
		[Test]
		public function testUnformat():void {
			var formatter:LeftSideZerosFormatter = new LeftSideZerosFormatter(14);
			var actual:String = formatter.unformat('000567890');
			assertEquals('567890', actual);
		}
	}
}