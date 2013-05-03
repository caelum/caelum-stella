package br.com.caelum.stella.nfe.schema;

import java.io.File;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.com.caelum.stella.nfe.xsd.status.TRetConsStatServ;

public class StatusServicoSchemaValidatorTest {

	@Test
	@Ignore
	public void retornoDeStatusDeServicoDeveSerValido() throws Exception {

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		File schemaFile = new File("xsds/PL_006j/retConsStatServ_v2.00.xsd");
		Schema schema = sf.newSchema(schemaFile);

		JAXBContext context = JAXBContext.newInstance(TRetConsStatServ.class);
		Unmarshaller um = context.createUnmarshaller();
		um.setSchema(schema);

		SchemaValidationEventHandler validator = new SchemaValidationEventHandler();
		um.setEventHandler(validator);

		String xml = "" +
				"<retConsStatServ versao=\"2.00\" xmlns:ns2=\"http://www.portalfiscal.inf.br/nfe\">" +
				"	<ns2:tpAmb>2</ns2:tpAmb>" +
				"	<ns2:verAplic>SP_NFE_PL_006j</ns2:verAplic>" +
				"	<ns2:cStat>107</ns2:cStat>" +
				"	<ns2:xMotivo>Serviço em Operação</ns2:xMotivo>" +
				"	<ns2:cUF>35</ns2:cUF>" +
				"	<ns2:dhRecbto>2012-05-04T18:25:03</ns2:dhRecbto>" +
				"	<ns2:tMed>1</ns2:tMed>" +
				"</retConsStatServ>";
		
		um.unmarshal(new StringReader(xml));

		Assert.assertTrue(validator.isValid());

	}

}
