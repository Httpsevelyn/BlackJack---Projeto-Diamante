package br.com.joaocarloslima.vinteum.model;

public class Carta {
    private final int numero;
    private final Naipe naipe;

    public Carta(int numero, Naipe naipe) {
        if (numero < 1 || numero > 13) throw new IllegalArgumentException("Número da carta deve estar entre 1 e 13.");
        if (naipe == null) throw new IllegalArgumentException("Naipe não pode ser nulo.");
        this.numero = numero;
        this.naipe = naipe;
    }

    public int getValor() {
        return numero >= 11 ? 10 : numero;
    }

    public String getImagem() {
        String nome;
        switch (numero) {
            case 1 -> nome = "Ace";
            case 11 -> nome = "Jack";
            case 12 -> nome = "Queen";
            case 13 -> nome = "King";
            default -> nome = Integer.toString(numero);
        }
        return nome + naipe.name() + ".png";
    }

    public int getNumero() { return numero; }
    public Naipe getNaipe() { return naipe; }
}
