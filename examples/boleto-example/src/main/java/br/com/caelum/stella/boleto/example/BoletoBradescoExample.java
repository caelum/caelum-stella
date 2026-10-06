package br.com.caelum.stella.boleto.example;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.Bradesco;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;

public class BoletoBradescoExample {
    public static void main(String[] args) {
        Datas datas = Datas.novasDatas().comDocumento(1, 5, 2008)
                .comProcessamento(1, 5, 2008).comVencimento(2, 5, 2008);

        Beneficiario beneficiario = Beneficiario.novoBeneficiario()
                .comNomeBeneficiario("Fulano de Tal")
                .comAgencia("2345")
                .comDigitoAgencia("6")
                .comCodigoBeneficiario("12345")
                .comNumeroConvenio("1234567")
                .comDigitoCodigoBeneficiario("1")
                .comCarteira("22")
                .comNossoNumero("9050987");

        Endereco enderecoPagador = new Endereco("Av dos testes, 111 apto 333", "Bairro Teste", "01234-111", "São Paulo", "SP");

        Pagador pagador = Pagador.novoPagador()
                .comNome("Fulano da Silva")
                .comDocumento("111.222.333-12")
                .comEndereco(enderecoPagador);

        Banco banco = new Bradesco();

        Boleto boleto = Boleto.novoBoleto()
                .comBanco(banco)
                .comDatas(datas)
                .comDescricoes("descricao 1", "descricao 2", "descricao 3",
                            "descricao 4", "descricao 5")
                .comBeneficiario(beneficiario)
                .comPagador(pagador)
                .comValorBoleto("200.00")
                .comNumeroDoDocumento("4343")
                .comInstrucoes("instrucao 1", "instrucao 2",
                            "instrucao 3", "instrucao 4", "instrucao 5")
                .comLocaisDePagamento("local 1", "local 2");

        GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);

        // Para gerar um boleto em PDF
        gerador.geraPDF("BoletoBradesco.pdf");

        // Para gerar um boleto em PNG
        gerador.geraPNG("BoletoBradesco.png");

        // Para gerar um array de bytes a partir de um PDF
        @SuppressWarnings("unused")
        byte[] bPDF = gerador.geraPDF();

        // Para gerar um array de bytes a partir de um PNG
        @SuppressWarnings("unused")
        byte[] bPNG = gerador.geraPNG();
    }
}
