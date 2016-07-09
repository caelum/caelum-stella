package br.com.caelum.stella.type;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Set;

import org.junit.Test;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class RegiaoTest {
	@Test
	public void statesOfSouthRegion() throws Exception {
		Set<Estado> estados = Regiao.SUL.estados();

		assertThat(estados.size(), is(3));
		assertThat(estados, hasItems(Estado.PR, Estado.RS, Estado.SC));
	}

	@Test
	public void statesOfSoutheastRegion() throws Exception {
		Set<Estado> estados = Regiao.SUDESTE.estados();

		assertThat(estados.size(), is(4));
		assertThat(estados, hasItems(Estado.SP, Estado.RJ, Estado.ES, Estado.MG));
	}

	@Test
	public void statesOfMidWestRegion() throws Exception {
		Set<Estado> estados = Regiao.CENTRO_OESTE.estados();

		assertThat(estados.size(), is(4));
		assertThat(estados, hasItems(Estado.MT, Estado.MS, Estado.GO, Estado.DF));
	}

	@Test
	public void statesOfNortheastRegion() throws Exception {
		Set<Estado> estados = Regiao.NORDESTE.estados();

		assertThat(estados.size(), is(9));
		assertThat(estados, hasItems(Estado.MA, Estado.PI, Estado.CE, Estado.RN, Estado.PE, Estado.PB, Estado.SE, Estado.AL, Estado.BA));
	}

	@Test
	public void statesOfNorthRegion() throws Exception {
		Set<Estado> estados = Regiao.NORTE.estados();

		assertThat(estados.size(), is(7));
		assertThat(estados, hasItems(Estado.AM, Estado.RR, Estado.AP, Estado.PA, Estado.TO, Estado.RO, Estado.AC));
	}

	@Test
	public void regionsAreComposedOfTheirOwnStates() throws Exception {
		Regiao[] regions = Regiao.values();

		for (Regiao region : regions) {
			for (Estado state : region.estados()) {
				assertThat("O estado " + state + " faz parte da região " + region, region.compostaPor(state), is(true));
			}
		}
	}

	@Test
	public void regionIsNotComposedOfStatesFromOtherRegions() throws Exception {
		Estado[] states = Estado.values();
		Regiao[] regions = Regiao.values();

		for (Estado state : states) {
			for (Regiao region : regions) {
				if(state.regiao() != region) {
					assertThat("O estado " + state + " não faz parte da região " + region, region.compostaPor(state), is(false));
				}
			}
		}
	}
}
