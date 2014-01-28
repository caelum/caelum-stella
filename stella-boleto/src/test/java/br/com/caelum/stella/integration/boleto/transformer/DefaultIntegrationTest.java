package br.com.caelum.stella.integration.boleto.transformer;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

import org.junit.BeforeClass;

public class DefaultIntegrationTest {
	
	@BeforeClass
	public static void compileReports() throws JRException{
		
		String relPath = DefaultIntegrationTest.class.getResource("/br/com/caelum/stella/boleto/templates/boleto-default.jrxml").getPath();
		String subRelPath = DefaultIntegrationTest.class.getResource("/br/com/caelum/stella/boleto/templates/boleto-default_instrucoes.jrxml").getPath();
		
		JasperCompileManager.compileReportToFile(relPath,relPath.replace("jrxml", "jasper"));
		JasperCompileManager.compileReportToFile(subRelPath,subRelPath.replace("jrxml","jasper"));
	}
}
