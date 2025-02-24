package co.edu.ucc.MARIA.patron_singleton;

public class Main {
    public static void main(String[] args) {
        Banco banco = Banco.getInstance();
        banco.mostrarNombre();
        System.out.println("Identidad codificada: " + banco.getIdentidad());
        System.out.println("Patrón implementado: " + banco.getPatron());
    }
}
