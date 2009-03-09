package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.CondicaoDoVeiculo;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoOperacao;

public interface VeicProd {
    public VeicProd withTpOp(TipoOperacao tipoOperacao);

    public VeicProd withChassi(String string);

    public VeicProd withCCor(String string);

    public VeicProd withXCor(String string);

    public VeicProd withPot(String string);

    public VeicProd withCM3(String string);

    public VeicProd withPesoL(String string);

    public VeicProd withPesoB(String string);

    public VeicProd withNSerie(String string);

    public VeicProd withTpComb(String string);

    public VeicProd withNMotor(String string);

    public VeicProd withCMKG(String string);

    public VeicProd withDist(String string);

    public VeicProd withRENAVAM(String string);

    public VeicProd withAnoMod(String string);

    public VeicProd withAnoFab(String string);

    public VeicProd withTpPint(String string);

    public VeicProd withTpVeic(String string);

    public VeicProd withEspVeic(String string);

    public VeicProd withVIN(String string);

    public VeicProd withCondVeic(CondicaoDoVeiculo condicao);

    public VeicProd withCMod(String string);
}