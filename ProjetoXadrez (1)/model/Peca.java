package model;

import java.io.Serializable;

public abstract class Peca implements Serializable {
    protected boolean branca;

    public Peca(boolean branca) {
        this.branca = branca;
    }

    public boolean isBranca() {
        return branca;
    }

    public abstract String getSimbolo();

    public abstract boolean movimentoValido(int ox, int oy, int dx, int dy, Peca[][] tabuleiro);
}