package co.edu.ucc.MARIA.patron_singleton;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Banco {
    // Instancia única del Singleton (Eager Initialization)
    private static final Banco instance = new Banco();
    private String nombreBanco;

    // Constructor privado para evitar instancias externas
    private Banco() {
        nombreBanco = "Banco Central";
    }

    // Método estático para obtener la única instancia del banco
    public static Banco getInstance() {
        return instance;
    }

    public void mostrarNombre() {
        System.out.println("Bienvenido al " + nombreBanco);
    }

    public String getIdentidad() {
        String nombreCompleto = "María José Noreña Rodriguez";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes(StandardCharsets.UTF_8));
    }

    public String getPatron() {
        return "Singleton";
    }
}
