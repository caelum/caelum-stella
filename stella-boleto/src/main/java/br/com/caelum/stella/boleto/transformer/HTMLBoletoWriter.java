package br.com.caelum.stella.boleto.transformer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.CriacaoBoletoException;
import br.com.caelum.stella.boleto.GeracaoBoletoException;
import br.com.caelum.stella.boleto.bancos.LinhaDigitavelGenerator;
import br.com.caelum.stella.boleto.bancos.Real;

public class HTMLBoletoWriter implements BoletoWriter {

	private String urlImagens;
	private Template template;
	private Collection<Boleto> boletos;
	private VelocityEngine velocityEngine;

	/**
	 * 
	 * @param urlImagens
	 *            url, fisica(e\home\...) ou
	 *            online(http://www.site.com.br/imgBoleto/), onde estão as
	 *            imagens.
	 * 
	 */
	public HTMLBoletoWriter(String urlImagens) {
		this.urlImagens = urlImagens;
		this.boletos = new ArrayList<Boleto>();
		this.velocityEngine = new VelocityEngine();
		Properties config = new Properties();
		config
				.setProperty("file.resource.loader.class",
						"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		try {
			this.velocityEngine.init(config);
			this.template = velocityEngine
					.getTemplate("/br/com/caelum/stella/boleto/html/template_html.vm");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new GeracaoBoletoException(
					"Não foi possivel iniciar a configuração do Velocity", e);
		}
	}

	/**
	 * 
	 * @param boleto
	 * 
	 */
	public void write(Boleto boleto) {
		this.boletos.add(boleto);
	}

	public boolean newPage() {
		// TODO Auto-generated method stub
		return false;
	}

	public InputStream toInputStream() {
		// TODO Auto-generated method stub

		StringWriter writer = new StringWriter();
		VelocityContext context = new VelocityContext();
		context.put("boletos", boletos);
		context.put("urlImagens", urlImagens);
		context.put("boletoHelper", new TemplateHelper());
		context.put("writer",this);
		try {
			template.merge(context, writer);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			throw new CriacaoBoletoException("Erro na criação do boleto", e);
		} catch (ParseErrorException e) {
			// TODO Auto-generated catch block
			throw new CriacaoBoletoException("Erro na criação do boleto", e);
		} catch (MethodInvocationException e) {
			// TODO Auto-generated catch block
			throw new CriacaoBoletoException("Erro na criação do boleto", e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new CriacaoBoletoException("Erro na criação do boleto", e);
		}
		return new ByteArrayInputStream(writer.toString().getBytes());
	}

	/**
	 * Apenas para ajudar com algumas coisas que ficam meio complicadas se
	 * colocadas diretas no template
	 * 
	 * @author Alberto Pc
	 * 
	 */
	public class TemplateHelper {		
		private BoletoFormatter formatter;
		private LinhaDigitavelGenerator linhaDigitavelGenerator;

		/**
		 * Como a classe tinha que ter visibilidade pública, pois o template fica em outro pacote, deixei o construtor
		 * privado para não correr o risco de alguém usar.
		 */
		private TemplateHelper() {
			this.formatter = new BoletoFormatter();
			this.linhaDigitavelGenerator = new LinhaDigitavelGenerator();
		}

		public char aceite(Boleto boleto) {
			return boleto.getAceite() ? 'S' : 'N';
		}

		public String formataData(Calendar data) {
			return formatter.formatDate(data);
		}

		public String formataValor(BigDecimal valor) {
			return formatter.formatValue(valor.doubleValue());
		}

		public String nossoNumero(Boleto boleto) {
			return boleto.getBanco().getNossoNumeroDoEmissorFormatado(
					boleto.getEmissor());
		}

		public String carteira(Boleto boleto) {
			return boleto.getBanco().getCarteiraDoEmissorFormatado(
					boleto.getEmissor());
		}

		public String contaCorrente(Boleto boleto) {
			return boleto.getBanco().getContaCorrenteDoEmissorFormatado(
					boleto.getEmissor());
		}

		public String linhaDigitavel(Boleto boleto) {
			return this.linhaDigitavelGenerator.geraLinhaDigitavelPara(boleto);
		}
	}
}
