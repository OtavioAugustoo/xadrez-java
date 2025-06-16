package model;

public class Peao extends Peca {
    public Peao(boolean branca) {
        super(branca);
    }

    @Override
    public String getSimbolo() {
        return branca ? "♙" : "♟";
    }

    @Override
    public boolean movimentoValido(int ox, int oy, int dx, int dy, Peca[][] tabuleiro) {
        int direcao = branca ? -1 : 1;
        if (ox + direcao == dx && oy == dy && tabuleiro[dx][dy] == null) {
            return true;
        }
        if ((branca && ox == 6 || !branca && ox == 1) &&
            dx == ox + 2 * direcao && oy == dy && tabuleiro[dx][dy] == null && tabuleiro[ox + direcao][dy] == null) {
            return true;
        }
        if (ox + direcao == dx && Math.abs(dy - oy) == 1 && tabuleiro[dx][dy] != null && tabuleiro[dx][dy].isBranca() != branca) {
            return true;
        }
        return false;
    }
}