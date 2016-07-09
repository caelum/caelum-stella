package br.com.caelum.stella.type;

import static br.com.caelum.stella.type.Estado.*;

import java.util.EnumSet;
import java.util.Set;

/**
 * Representa as divisões regionais do território brasileiro.
 *
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public enum Regiao {
	CENTRO_OESTE(DF, GO, MT, MS),
	NORDESTE(AL, BA, CE, MA, PB, PE, PI, RN, SE),
	NORTE(AC, AM, AP, PA, RO, RR, TO),
	SUDESTE(ES, MG, RJ, SP),
	SUL(PR, RS, SC);

	private final Set<Estado> estados;

	private Regiao(Estado... estados) {
		this.estados = EnumSet.of(estados[0], estados);
	}

	/**
	 * A lista de estados que compõem essa região.
	 *
	 * @return Retorna uma lista dos estados que compõem essa região.
	 */
	public Set<Estado> estados() {
		return estados;
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
