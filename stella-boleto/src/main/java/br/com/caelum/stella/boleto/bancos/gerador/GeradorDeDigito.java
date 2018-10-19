package br.com.caelum.stella.boleto.bancos.gerador;

import java.io.Serializable;

public interface GeradorDeDigito extends Serializable {

	int geraDigitoMod11(String codigoDeBarras);

	int geraDigitoMod(String codigoDeBarras, int inicio, int fim, int numMOD);

	int geraDigitoMod10(String campo);

	int geraDigitoBloco1(String bloco);

	int geraDigitoBloco2(String bloco);

	int geraDigitoBloco3(String bloco);

	int geraDigitoMod11AceitandoRestoZero(String codigoDeBarras);

	int geraDigitoModAceitandoRestoZero(String codigoDeBarras, int inicio, int fim, int numMod);

}