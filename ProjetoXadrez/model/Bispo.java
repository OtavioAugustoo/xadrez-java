package model;

public class Bispo extends Peca {
    public Bispo(boolean branca) {
        super(branca);
    }

    @Override
    public String getSimbolo() {
        return branca ? "♗" : "♝";
    }

    @Override
    public boolean movimentoValido(int ox, int oy, int dx, int dy, Peca[][] tabuleiro) {
        return Math.abs(dx - ox) == Math.abs(dy - oy);
    }
}