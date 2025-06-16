package view;

import javax.swing.*;
import controller.JogoController;

public class JanelaPrincipal extends JFrame {
    public JanelaPrincipal() {
        setTitle("Jogo de Xadrez");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 650);
        setLocationRelativeTo(null);

        TabuleiroGUI tabuleiroGUI = new TabuleiroGUI();
        new JogoController(tabuleiroGUI);
        add(tabuleiroGUI);

        setVisible(true);
    }
}