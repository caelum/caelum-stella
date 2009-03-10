package br.com.caelum.stella.nfe.builder.generated;

public interface Volume {
    public Volume withQuantidade(Long string);

    public Volume withEspecie(String string);

    public Volume withMarca(String string);

    public Volume withNumeracao(String string);

    public Volume withPesoLiquido(String string);

    public Volume withPesoBruto(String string);

    public Volume withLacres(Lacres... lacres);
}