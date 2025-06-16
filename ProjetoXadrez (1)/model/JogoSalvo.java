package model;

import java.io.*;

public class JogoSalvo {
    public static void salvarEstado(EstadoJogo estado, String caminho) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(caminho))) {
            out.writeObject(estado);
        }
    }

    public static EstadoJogo carregarEstado(String caminho) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(caminho))) {
            return (EstadoJogo) in.readObject();
        }
    }
}