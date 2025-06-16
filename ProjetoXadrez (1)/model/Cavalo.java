package model;

public class Cavalo extends Peca {
    public Cavalo(boolean branca) {
        super(branca);
    }

    @Override
    public String getSimbolo() {
        return branca ? "♘" : "♞";
    }

    @Override
    public boolean movimentoValido(int ox, int oy, int dx, int dy, Peca[][] tabuleiro) {
        int dxAbs = Math.abs(dx - ox);
        int dyAbs = Math.abs(dy - oy);
        return (dxAbs == 2 && dyAbs == 1) || (dxAbs == 1 && dyAbs == 2);
    }
}