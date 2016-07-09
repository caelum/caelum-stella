package br.com.caelum.stella.type;

import static br.com.caelum.stella.type.Estado.AC;
import static br.com.caelum.stella.type.Estado.AL;
import static br.com.caelum.stella.type.Estado.AM;
import static br.com.caelum.stella.type.Estado.AP;
import static br.com.caelum.stella.type.Estado.BA;
import static br.com.caelum.stella.type.Estado.CE;
import static br.com.caelum.stella.type.Estado.DF;
import static br.com.caelum.stella.type.Estado.ES;
import static br.com.caelum.stella.type.Estado.GO;
import static br.com.caelum.stella.type.Estado.MA;
import static br.com.caelum.stella.type.Estado.MG;
import static br.com.caelum.stella.type.Estado.MS;
import static br.com.caelum.stella.type.Estado.MT;
import static br.com.caelum.stella.type.Estado.PA;
import static br.com.caelum.stella.type.Estado.PB;
import static br.com.caelum.stella.type.Estado.PE;
import static br.com.caelum.stella.type.Estado.PI;
import static br.com.caelum.stella.type.Estado.PR;
import static br.com.caelum.stella.type.Estado.RJ;
import static br.com.caelum.stella.type.Estado.RN;
import static br.com.caelum.stella.type.Estado.RO;
import static br.com.caelum.stella.type.Estado.RR;
import static br.com.caelum.stella.type.Estado.RS;
import static br.com.caelum.stella.type.Estado.SC;
import static br.com.caelum.stella.type.Estado.SE;
import static br.com.caelum.stella.type.Estado.SP;
import static br.com.caelum.stella.type.Estado.TO;
import static java.util.Arrays.asList;

import java.util.List;

/**
 * Representa as divisões regionais do território brasileiro.
 *
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public enum Regiao {
	CENTRO_OESTE,
	NORDESTE,
	NORTE,
	SUDESTE,
	SUL;


	/**
	 * A lista de estados que compõem essa região.
	 *
	 * @return Retorna uma lista dos estados que compõem essa região.
	 */
	public List<Estado> estados() {
		switch (this) {
		case CENTRO_OESTE:
			return asList(MT, MS, GO, DF);
		case NORDESTE:
			return asList(MA, PI, CE, RN, PE, PB, SE, AL, BA);
		case NORTE:
			return asList(AM, RR, AP, PA, TO, RO, AC);
		case SUDESTE:
			return asList(SP, RJ, ES, MG);
		case SUL:
			return asList(PR, RS, SC);
		default:
			throw new IllegalStateException("Não é possível determinar os estados que compõem a região " + this);
		}
	}

	/**
	 * Verifica se o estado informado faz parte dessa região.
	 *
	 * @param estado Um estado do território brasileiro.
	 * @return Retorna {@code true} se o estado fizer parte dessa região ou {@code false} caso contrário.
	 */
	public boolean compostaPor(Estado estado) {
		return estados().contains(estado);
	}
}
