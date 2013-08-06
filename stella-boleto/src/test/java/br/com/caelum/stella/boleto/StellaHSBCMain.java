package br.com.caelum.stella.boleto;

import br.com.caelum.stella.boleto.bancos.HSBC;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;

public class StellaHSBCMain {

    public static void main(String[] args) {

        Double valorAcumulado = 949.62;

        Datas datas = Datas.novasDatas()
                .comDocumento(23, 05, 2013)
                //.comProcessamento(1,1, 2013)
                .comVencimento(20, 06, 2013);

        Emissor emissor = Emissor.novoEmissor()
                .comCedente("R.A. ARBEX GESTÃO IMOBILIARIA                CNPJ-07.751.642/0001-71")
                .comEndereco("CENTRO DE JUIZ DE FORA")
                .comAgencia(366)
                .comContaCorrente(326)
                .comDigitoContaCorrente('4')
                .comNumeroConvenio(3264)
                .comCarteira(18)
                .comNossoNumero(1540000201305l);

        Sacado sacado = Sacado.novoSacado()
                .comNome("CLÍNICA DE ESP. DA CRIANÇA E ADOL. LTDA")
                //.comCpf("08.248.561/0001-16")
                .comEndereco("AV. RIO BRANCO Nº 2872/513")
                .comBairro("CENTRO")
                .comCep("36010-012")
                .comCidade("JUIZ DE FORA")
                .comUf("MG");

        Banco banco = new HSBC();
        //Banco banco = new BancoDoBrasil();  

        Boleto boleto = Boleto.novoBoleto().comEspecieDocumento("DM")
                .comBanco(banco)
                .comDatas(datas)
                .comEmissor(emissor)
                .comSacado(sacado)
                .comAceite(Boolean.FALSE)
                .comValorBoleto(valorAcumulado.toString())
                //.comDescricoes("bla", "bla")
                .comInstrucoes("Juros de 0,50% ao mês após o vencimento", "Cobrar multa de 2,00% após o vencimento")
                .comLocaisDePagamento("PAGAR PREFERENCIALMENTE EM AGÊNCIA DO HSBC")
                .comNumeroDoDocumento("1540000201305")
                .comParcela("1/1");

        GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);

        // Para gerar um boleto em PDF  
        gerador.geraPDF2("HSBC.pdf");

        // Para gerar um boleto em PNG  
        gerador.geraPNG2("HSBC.png");

        // Para gerar um array de bytes a partir de um PDF  
        // byte[] bPDF = gerador.toPDF();  

        // Para gerar um array de bytes a partir de um PNG  
        // byte[] bPNG = gerador.toPNG();  
    }
}