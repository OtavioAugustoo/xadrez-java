package view;

import model.*;

import javax.swing.*;

import controller.JogoController;

import java.awt.*;

public class TabuleiroGUI extends JPanel {
    private JButton[][] botoes = new JButton[8][8];
    private int[] origemSelecionada = null;
    private JogoController controller;

    public TabuleiroGUI() {
        setLayout(new GridLayout(8, 8));
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton botao = new JButton();
                botao.setFont(new Font("Serif", Font.PLAIN, 32));
                int x = i, y = j;
                botao.addActionListener(e -> {
                    if (controller != null)
                        controller.processarClique(x, y);
                });
                botoes[i][j] = botao;
                add(botao);
            }
        }
    }

    public void setController(JogoController controller) {
        this.controller = controller;
    }

    public void destacarOuMover(int x, int y, Tabuleiro tabuleiro, boolean turnoBranco, JogadaCallback callback) {
        if (origemSelecionada == null) {
            Peca p = tabuleiro.getPeca(x, y);
            if (p != null && p.isBranca() == turnoBranco) {
                origemSelecionada = new int[]{x, y};
                botoes[x][y].setBackground(Color.YELLOW);
            }
        } else {
            int ox = origemSelecionada[0];
            int oy = origemSelecionada[1];
            boolean movido = tabuleiro.moverPeca(ox, oy, x, y);
            if (!movido) Mensagens.mostrarErro("Jogada inválida!");
            origemSelecionada = null;
            resetarCores();
            atualizarComTabuleiro(tabuleiro);
            callback.jogadaConcluida(movido);
        }
    }

    private void resetarCores() {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                botoes[i][j].setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
    }

    public void atualizarComTabuleiro(Tabuleiro tabuleiro) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Peca p = tabuleiro.getPeca(i, j);
                botoes[i][j].setText(p != null ? p.getSimbolo() : "");
            }
        }
    }
}