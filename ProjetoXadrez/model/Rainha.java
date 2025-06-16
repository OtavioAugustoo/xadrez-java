package model;

public class Rainha extends Peca {
    public Rainha(boolean branca) {
        super(branca);
    }

    @Override
    public String getSimbolo() {
        return branca ? "♕" : "♛";
    }

    @Override
    public boolean movimentoValido(int ox, int oy, int dx, int dy, Peca[][] tabuleiro) {
        return (ox == dx || oy == dy || Math.abs(dx - ox) == Math.abs(dy - oy));
    }
}