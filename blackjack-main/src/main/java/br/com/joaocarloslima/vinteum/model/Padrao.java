package br.com.joaocarloslima.vinteum.model;

public class Padrao implements EstiloDeJogo {
    public String getNome() { return "Padrão"; }
    public boolean querCarta(Mao mao) { return mao.getPontos() < 17; }
}
