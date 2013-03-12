package br.com.caelum.stella.boleto.bancos.gerador;

public interface GeradorDeDigito {

	int geraDigitoMod11(String codigoDeBarras);

	int geraDigitoMod(String codigoDeBarras, int inicio, int fim, int numMOD);

	int geraDigitoMod10(String campo);

	int geraDigitoBloco1(String bloco);

	int geraDigitoBloco2(String bloco);

	int geraDigitoBloco3(String bloco);

}