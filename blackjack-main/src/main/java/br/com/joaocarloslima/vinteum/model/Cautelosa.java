package br.com.joaocarloslima.vinteum.model;

public class Cautelosa implements EstiloDeJogo {
    public String getNome() { return "Cautelosa"; }
    public boolean querCarta(Mao mao) { return mao.getPontos() < 15; }
}
