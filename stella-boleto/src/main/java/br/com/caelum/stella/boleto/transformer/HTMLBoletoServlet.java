package br.com.caelum.stella.boleto.transformer;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Essa classe tem como objetivo renderizar as imagens relativas ao boleto.
 * Dessa forma o usuario não precisa colocar nenhuma imagem ou coisa relativa na
 * estrutura dele.
 * 
 * @author Alberto
 * 
 */
public class HTMLBoletoServlet extends HttpServlet {

	private static final long serialVersionUID = 2942118702706573802L;

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
			IOException {
		
		String tipoRecurso = request.getParameter("type");
		String value = request.getParameter("value");
		BufferedImage image = getCorrectImageFor(tipoRecurso, value);
		response.setContentType("image/png");
		ImageIO.write(image, "png", response.getOutputStream());
	}

	/**
	 * Retorna a imagem
	 * 
	 * @param urlSolicitada
	 * @param parametro
	 * @return
	 * @throws IOException
	 */
	private BufferedImage getCorrectImageFor(final String tipoRecurso, final String value) throws IOException {
		BufferedImage image;
		if ("img".equals(tipoRecurso)) {
			image = ImageIO.read(HTMLBoletoServlet.class.getResource("/br/com/caelum/stella/boleto/img/" + value));
		} else {
			// ainda tem que ajeitar a altura e talvez o tamanho da imagem
			// gerada. Pode receber como parametro tb...
			image = BufferedImageGenerator.generateBufferedImageFor(GeradorDeImagemDoCodigoDeBarras.geraImagemDoCodigoDeBarrasPara(value, 37.00f),
					BufferedImage.TYPE_INT_ARGB);
		}
		return image;
	}

}
