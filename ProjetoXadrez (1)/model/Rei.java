package model;

public class Rei extends Peca {
    public Rei(boolean branca) {
        super(branca);
    }

    @Override
    public String getSimbolo() {
        return branca ? "♔" : "♚";
    }

    @Override
    public boolean movimentoValido(int ox, int oy, int dx, int dy, Peca[][] tabuleiro) {
        return Math.abs(dx - ox) <= 1 && Math.abs(dy - oy) <= 1;
    }
}