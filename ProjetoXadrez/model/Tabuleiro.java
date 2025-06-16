package model;

public class Tabuleiro {
    private Peca[][] pecas = new Peca[8][8];

    public Tabuleiro() {
        iniciarTabuleiro();
    }

    private void iniciarTabuleiro() {
        for (int i = 0; i < 8; i++) {
            pecas[1][i] = new Peao(false);
            pecas[6][i] = new Peao(true);
        }

        pecas[0][0] = new Torre(false); pecas[0][7] = new Torre(false);
        pecas[7][0] = new Torre(true);  pecas[7][7] = new Torre(true);

        pecas[0][1] = new Cavalo(false); pecas[0][6] = new Cavalo(false);
        pecas[7][1] = new Cavalo(true);  pecas[7][6] = new Cavalo(true);

        pecas[0][2] = new Bispo(false); pecas[0][5] = new Bispo(false);
        pecas[7][2] = new Bispo(true);  pecas[7][5] = new Bispo(true);

        pecas[0][3] = new Rainha(false);
        pecas[0][4] = new Rei(false);
        pecas[7][3] = new Rainha(true);
        pecas[7][4] = new Rei(true);
    }

    public Peca getPeca(int x, int y) {
        return pecas[x][y];
    }

    public boolean moverPeca(int ox, int oy, int dx, int dy) {
        Peca p = pecas[ox][oy];
        if (p != null && p.movimentoValido(ox, oy, dx, dy, pecas)) {
            pecas[dx][dy] = p;
            pecas[ox][oy] = null;
            return true;
        }
        return false;
    }

    public Peca[][] getPecas() {
        return pecas;
    }
}