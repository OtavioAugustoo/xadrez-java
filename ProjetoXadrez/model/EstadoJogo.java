package model;

import java.io.Serializable;

public class EstadoJogo implements Serializable {
    private Tabuleiro tabuleiro;
    private boolean turnoBranco;

    public EstadoJogo(Tabuleiro tabuleiro, boolean turnoBranco) {
        this.tabuleiro = tabuleiro;
        this.turnoBranco = turnoBranco;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public boolean isTurnoBranco() {
        return turnoBranco;
    }
}