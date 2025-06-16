package view;

import javax.swing.*;

public class Mensagens {
    public static void mostrarErro(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarInfo(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
}