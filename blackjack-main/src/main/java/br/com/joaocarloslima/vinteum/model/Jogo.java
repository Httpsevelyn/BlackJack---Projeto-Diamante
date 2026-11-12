package br.com.joaocarloslima.vinteum.model;

public class Jogo {
    private final Monte monte;
    private final Jogador jogador;
    private final Mesa mesa;

    public Jogo() {
        monte = new Monte();
        jogador = new Jogador();
        mesa = new Mesa();
        // Distribuição alternada: jogador, mesa, jogador, mesa.
        jogador.receberCarta(monte.virar());
        mesa.receberCarta(monte.virar());
        jogador.receberCarta(monte.virar());
        mesa.receberCarta(monte.virar());
    }

    public void pedirCarta() {
        if (acabou() || !jogador.querCarta()) return;
        jogador.receberCarta(monte.virar());
        if (jogador.estourou()) jogador.parar();
    }

    public void parar() {
        if (acabou()) return;
        jogador.parar();
        while (mesa.querCarta() && monte.getQuantidade() > 0) {
            mesa.receberCarta(monte.virar());
        }
        mesa.parar();
    }

    public boolean acabou() {
        return jogador.estourou() || (jogador.parou() && mesa.parou());
    }

    public String resultado() {
        if (!acabou()) return "";
        if (jogador.estourou()) return "Você perdeu";
        if (mesa.estourou()) return "Você ganhou";
        if (jogador.getPontos() > mesa.getPontos()) return "Você ganhou";
        if (jogador.getPontos() < mesa.getPontos()) return "Você perdeu";
        return "Empate";
    }

    public Jogador getJogador() { return jogador; }
    public Mesa getMesa() { return mesa; }
    public Monte getMonte() { return monte; }
}
