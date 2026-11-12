package br.com.joaocarloslima.vinteum.model;

import java.util.ArrayList;
import java.util.List;

public class Mao {
    private final List<Carta> cartas = new ArrayList<>();

    public void adicionar(Carta carta) {
        if (carta == null) throw new IllegalArgumentException("Carta não pode ser nula.");
        cartas.add(carta);
    }

    public int getPontos() {
        int pontos = 0;
        int ases = 0;
        for (Carta carta : cartas) {
            pontos += carta.getValor();
            if (carta.getNumero() == 1) ases++;
        }
        while (ases > 0 && pontos + 10 <= 21) {
            pontos += 10;
            ases--;
        }
        return pontos;
    }

    public boolean estourou() { return getPontos() > 21; }
    public List<Carta> getCartas() { return new ArrayList<>(cartas); }
}
