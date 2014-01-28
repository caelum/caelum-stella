package br.com.caelum.stella.boleto.example;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.bancos.Bradesco;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;

public class BoletosToPdfExample {
    public static void main(String[] args) {
        GeradorDeBoleto gerador = new GeradorDeBoleto(getBoletoBancoDoBrasil(),
                getBoletoBradesco(), getBoletoBancoDoBrasil());

        // Para gerar um boleto em PDF
        gerador.geraPDF("Boletos.pdf");
    }

    private static Boleto getBoletoBancoDoBrasil() {
        Datas datas = Datas.novasDatas()
            .comDocumento(1, 5, 2008)
            .comProcessamento(1, 5, 2008)
            .comVencimento(2, 5, 2008);

        Emissor emissor = Emissor.novoEmissor()
            .comCedente("Fulano de Tal")
            .comAgencia(2345)
            .comDigitoAgencia('6')
            .comContaCorrente(12345)
            .comNumeroConvenio(1234567)
            .comDigitoContaCorrente('1')
            .comCarteira(22)
            .comNossoNumero(9050987);

        Sacado sacado = Sacado.novoSacado()
            .comNome("Fulano da Silva")
            .comCpf("111.222.333-12")
            .comEndereco("Av dos testes, 111 apto 333")
            .comBairro("Bairro Teste")
            .comCep("01234-111")
            .comCidade("São Paulo")
            .comUf("SP");

        Banco banco = new BancoDoBrasil();

        Boleto boleto = Boleto.novoBoleto()
            .comBanco(banco)
            .comDatas(datas)
            .comDescricoes("descricao 1", "descricao 2", "descricao 3",
                        "descricao 4", "descricao 5")
            .comEmissor(emissor)
            .comSacado(sacado)
            .comValorBoleto("200.00")
            .comNumeroDoDocumento("1234")
            .comInstrucoes("instrucao 1", "instrucao 2",
                        "instrucao 3", "instrucao 4", "instrucao 5")
            .comLocaisDePagamento("local 1", "local 2")
            .comNumeroDoDocumento("4343");
        return boleto;
    }

    private static Boleto getBoletoBradesco() {
        Datas datas = Datas.novasDatas()
            .comDocumento(1, 5, 2008)
            .comProcessamento(1, 5, 2008)
            .comVencimento(2, 5, 2008);

        Emissor emissor = Emissor.novoEmissor()
            .comCedente("Fulano de Tal")
            .comAgencia(2345)
            .comDigitoAgencia('6')
            .comContaCorrente(12345)
            .comNumeroConvenio(1234567)
            .comDigitoContaCorrente('1')
            .comCarteira(22)
            .comNossoNumero(9050987);

        Sacado sacado = Sacado.novoSacado()
            .comNome("Fulano da Silva")
            .comCpf("111.222.333-12")
            .comEndereco("Av dos testes, 111 apto 333")
            .comBairro("Bairro Teste")
            .comCep("01234-111")
            .comCidade("São Paulo")
            .comUf("SP");

        Banco banco = new Bradesco();

        Boleto boleto = Boleto.novoBoleto()
            .comBanco(banco)
            .comDatas(datas)
            .comDescricoes("descricao 1", "descricao 2", "descricao 3",
                        "descricao 4", "descricao 5")
            .comEmissor(emissor)
            .comSacado(sacado)
            .comValorBoleto("200.00")
            .comNumeroDoDocumento("1234")
            .comInstrucoes("instrucao 1", "instrucao 2",
                        "instrucao 3", "instrucao 4", "instrucao 5")
            .comLocaisDePagamento("local 1", "local 2")
            .comNumeroDoDocumento("4343");
        return boleto;
    }
}
