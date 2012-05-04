package br.com.caelum.stella.nfe.ws.sp;

import javax.xml.ws.Holder;

import br.com.caelum.stella.nfe.Estados;
import br.com.caelum.stella.nfe.VersaoNFE;
import br.com.caelum.stella.nfe.xsd.schema.generated.TConsStatServ;
import br.com.caelum.stella.nfe.xsd.schema.generated.TRetConsStatServ;

public class ConsultaStatusSaoPauloHomolog {

	private final VersaoNFE versao;
	private final Estados sp = Estados.SP;

	public ConsultaStatusSaoPauloHomolog(VersaoNFE versao) {
		this.versao = versao;
	}

	public NfeStatusServicoNF2Result consulta() {

		ObjectFactory objectFactoryWS = new ObjectFactory();
		br.com.caelum.stella.nfe.xsd.schema.generated.ObjectFactory objectFactoryXSD = new br.com.caelum.stella.nfe.xsd.schema.generated.ObjectFactory();

		NfeCabecMsg cabec = objectFactoryWS.createNfeCabecMsg();
		cabec.setCUF(sp.getCodigo());
		cabec.setVersaoDados(versao.getVersao());
		Holder<NfeCabecMsg> holderCab = new Holder<NfeCabecMsg>(cabec);

		NfeDadosMsg dados = objectFactoryWS.createNfeDadosMsg();

		TConsStatServ status = new TConsStatServ();
		status.setCUF(sp.getCodigo());
		status.setTpAmb("2");
		status.setVersao(versao.getVersao());
		status.setXServ("STATUS");

		dados.getContent().add(objectFactoryXSD.createConsStatServ(status));
		NfeStatusServico2Soap12 servico = new NfeStatusServico2().getNfeStatusServico2Soap12();
		return servico.nfeStatusServicoNF2(dados, holderCab);
		
//		return (TRetConsStatServ) result.getContent().get(0);
	}

}
