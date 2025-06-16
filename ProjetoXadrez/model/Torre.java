package model;

public class Torre extends Peca {
    public Torre(boolean branca) {
        super(branca);
    }

    @Override
    public String getSimbolo() {
        return branca ? "♖" : "♜";
    }

    @Override
    public boolean movimentoValido(int ox, int oy, int dx, int dy, Peca[][] tabuleiro) {
        return (ox == dx || oy == dy);
    }
}