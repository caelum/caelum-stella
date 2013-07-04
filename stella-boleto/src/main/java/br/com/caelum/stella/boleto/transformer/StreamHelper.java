package br.com.caelum.stella.boleto.transformer;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

import br.com.caelum.stella.boleto.exception.GeracaoBoletoException;

public class StreamHelper {

	public void escreveArquivo(File file, InputStream is) {
		ReadableByteChannel inputChannel = null;
		WritableByteChannel outputChannel = null;

		try {
			inputChannel = Channels.newChannel(is);
			outputChannel = Channels.newChannel(new FileOutputStream(file));
			ByteBuffer buffer = ByteBuffer.allocate(1024);

			while (inputChannel.read(buffer) != -1) {
				buffer.flip();
				outputChannel.write(buffer);
				buffer.clear();
			}

		} catch (Exception e) {
			throw new GeracaoBoletoException("Erro ao escrever arquivo do boleto", e);
		} finally {
			fecharSilenciosamente(outputChannel);
			fecharSilenciosamente(inputChannel);
		}
	}

	private void fecharSilenciosamente(Closeable c) {
		try {
			c.close();
		} catch (Exception e) {
		}
	}

	/**
	 * Devolve o array de bytes do boleto escrito pelo writer indicado.
	 * 
	 * @param writer
	 *            Tipo de writer para gerar o boleto
	 * @return conteúdo do boleto em bytes
	 */
	public byte[] geraBytes(InputStream is) {

		try {
			byte[] b = new byte[is.available()];
			is.read(b);

			return b;

		} catch (Exception e) {
			throw new GeracaoBoletoException("Erro na geração do boleto", e);
		} finally {
			fecharSilenciosamente(is);
		}
	}

}
