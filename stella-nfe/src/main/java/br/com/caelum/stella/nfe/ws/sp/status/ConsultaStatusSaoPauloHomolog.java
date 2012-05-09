package br.com.caelum.stella.nfe.ws.sp.status;

import javax.xml.bind.JAXBElement;
import javax.xml.ws.Holder;

import org.w3c.dom.Node;

import br.com.caelum.stella.nfe.Estados;
import br.com.caelum.stella.nfe.JaxBHelper;
import br.com.caelum.stella.nfe.VersaoNFE;
import br.com.caelum.stella.nfe.xsd.status.TConsStatServ;
import br.com.caelum.stella.nfe.xsd.status.TRetConsStatServ;

public class ConsultaStatusSaoPauloHomolog {

	private final VersaoNFE versao;
	private final Estados sp = Estados.SP;

	public ConsultaStatusSaoPauloHomolog(VersaoNFE versao) {
		this.versao = versao;
	}

	public StatusServico consulta() {

		ObjectFactory objectFactoryWS = new ObjectFactory();
		br.com.caelum.stella.nfe.xsd.status.ObjectFactory objectFactoryXSD = new br.com.caelum.stella.nfe.xsd.status.ObjectFactory();

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
		NfeStatusServicoNF2Result result = servico.nfeStatusServicoNF2(dados, holderCab);
		
		TRetConsStatServ object = new JaxBHelper().unmarshalNode(result.getContent().get(0),TRetConsStatServ.class);
		
		return new StatusServico(object);

	}

}
