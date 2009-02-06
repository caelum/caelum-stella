package br.com.caelum.stella.nfe.builder.generated;

public interface Transp {
    public Transp withModFrete(String string);

    public Transp withTransporta(Transporta transporta);

    public Transp withRetTransp(RetTransp retTransp);

    public Transp withVeicTransp(TVeiculo tVeiculo);

    public Transp withReboque(TVeiculo... reboques);

    public Transp withVol(Vol... vols);
}