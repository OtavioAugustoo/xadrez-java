package controller;

import model.*;
import view.*;

import java.io.*;

public class JogoController {
    private Tabuleiro tabuleiro;
    private TabuleiroGUI tabuleiroGUI;
    private boolean turnoBranco = true;
    private final String caminhoSalvar = "estado_jogo.dat";

    public JogoController(TabuleiroGUI tabuleiroGUI) {
        this.tabuleiroGUI = tabuleiroGUI;
        this.tabuleiro = carregarEstado();
        if (this.tabuleiro == null) {
            this.tabuleiro = new Tabuleiro();
            salvarEstado();
        }
        this.tabuleiroGUI.setController(this);
        this.tabuleiroGUI.atualizarComTabuleiro(tabuleiro);
    }

    public void processarClique(int x, int y) {
        tabuleiroGUI.destacarOuMover(x, y, tabuleiro, turnoBranco, (jogadaFeita) -> {
            if (jogadaFeita) {
                turnoBranco = !turnoBranco;
                salvarEstado();
            }
        });
    }

    private void salvarEstado() {
        try {
            JogoSalvo.salvarEstado(new EstadoJogo(tabuleiro, turnoBranco), caminhoSalvar);
        } catch (IOException e) {
            Mensagens.mostrarErro("Erro ao salvar o estado do jogo.");
        }
    }

    private Tabuleiro carregarEstado() {
        try {
            EstadoJogo estado = JogoSalvo.carregarEstado(caminhoSalvar);
            this.turnoBranco = estado.isTurnoBranco();
            return estado.getTabuleiro();
        } catch (Exception e) {
            return null;
        }
    }
}