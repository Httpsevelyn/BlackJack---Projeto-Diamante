package br.com.joaocarloslima.vinteum.model;

public class Arriscada implements EstiloDeJogo {
    public String getNome() { return "Arriscada"; }
    public boolean querCarta(Mao mao) { return mao.getPontos() < 19; }
}
