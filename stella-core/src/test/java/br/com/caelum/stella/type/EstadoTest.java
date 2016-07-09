package br.com.caelum.stella.type;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class EstadoTest {
	@Test
	public void regionsOfStates() throws Exception {
		assertThat(Estado.AC.regiao(), is(Regiao.NORTE));
		assertThat(Estado.AL.regiao(), is(Regiao.NORDESTE));
		assertThat(Estado.AM.regiao(), is(Regiao.NORTE));
		assertThat(Estado.AP.regiao(), is(Regiao.NORTE));
		assertThat(Estado.BA.regiao(), is(Regiao.NORDESTE));
		assertThat(Estado.CE.regiao(), is(Regiao.NORDESTE));
		assertThat(Estado.DF.regiao(), is(Regiao.CENTRO_OESTE));
		assertThat(Estado.ES.regiao(), is(Regiao.SUDESTE));
		assertThat(Estado.GO.regiao(), is(Regiao.CENTRO_OESTE));
		assertThat(Estado.MA.regiao(), is(Regiao.NORDESTE));
		assertThat(Estado.MG.regiao(), is(Regiao.SUDESTE));
		assertThat(Estado.MS.regiao(), is(Regiao.CENTRO_OESTE));
		assertThat(Estado.MT.regiao(), is(Regiao.CENTRO_OESTE));
		assertThat(Estado.PA.regiao(), is(Regiao.NORTE));
		assertThat(Estado.PB.regiao(), is(Regiao.NORDESTE));
		assertThat(Estado.PE.regiao(), is(Regiao.NORDESTE));
		assertThat(Estado.PI.regiao(), is(Regiao.NORDESTE));
		assertThat(Estado.PR.regiao(), is(Regiao.SUL));
		assertThat(Estado.RJ.regiao(), is(Regiao.SUDESTE));
		assertThat(Estado.RN.regiao(), is(Regiao.NORDESTE));
		assertThat(Estado.RO.regiao(), is(Regiao.NORTE));
		assertThat(Estado.RR.regiao(), is(Regiao.NORTE));
		assertThat(Estado.RS.regiao(), is(Regiao.SUL));
		assertThat(Estado.SC.regiao(), is(Regiao.SUL));
		assertThat(Estado.SE.regiao(), is(Regiao.NORDESTE));
		assertThat(Estado.SP.regiao(), is(Regiao.SUDESTE));
		assertThat(Estado.TO.regiao(), is(Regiao.NORTE));
	}

	@Test
	public void statesAreLocatedInTheirRegions() throws Exception {
		for (Estado state : Estado.values()) {
			assertThat("O estado " + state + " está localizada na região " + state.regiao(), state.localizadoEm(state.regiao()), is(true));
		}
	}

	@Test
	public void statesAreNotLocatedInOtherRegions() throws Exception {
		for (Estado state : Estado.values()) {
			for (Regiao region : Regiao.values()) {
				if(state.regiao() != region) {
					assertThat("O estado " + state + " não está localizado na região " + region, state.localizadoEm(region), is(false));
				}
			}
		}
	}
}
