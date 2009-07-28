package br.com.caelum.stella.gateway;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Classe utilitaria para os testes, apenas para criar paginas temporarias com
 * os htmls para postagem de formularios..
 * 
 * @author Alberto Pc
 * 
 */
public class HtmlViewerHelper {

	private StringBuilder pagina = new StringBuilder("<html>");

	/**
	 * 
	 * @param functions
	 *            ex: onload=document.all.algumacoisa
	 * @return
	 */
	public HtmlViewerHelper body(String functions) {
		pagina.append("<body " + functions + ">");
		return this;
	}

	public HtmlViewerHelper form(String action, String method, String name) {
		pagina.append("<form method='" + method + "' action='" + action
				+ "' name='" + name + "' id='" + name + "'>");
		return this;
	}

	public HtmlViewerHelper createInputsHidden(Map<String, Object> fields) {
		for (String key : fields.keySet()) {
			pagina.append(generateInput(key, fields.get(key)));
		}
		return this;
	}

	private String generateInput(String name, Object value) {
		return "<input type='hidden' name='" + name + "' value='" + value
				+ "'/>";
	}

	/**
	 * 
	 * @param path
	 * @throws RuntimeException caso não consiga gerar o arquivo.
	 */
	public void criarPaginaTemporariaNoDisco(String path) {
		pagina.append("</form>").append("</body>").append("</html>");
		File arquivo = new File(path);
		FileOutputStream writer;
		try {
			writer = new FileOutputStream(arquivo);
			writer.write(pagina.toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
}
