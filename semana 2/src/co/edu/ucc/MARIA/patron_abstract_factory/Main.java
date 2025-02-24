package co.edu.ucc.MARIA.patron_abstract_factory;

import java.util.Base64;


// 🔹 Clase principal (Cliente)
public class Main {
    public static void main(String[] args) {
        // Seleccionar una fábrica concreta (Banco A)
        FabricaFinanciera fabricaBancoA = new BancoAFactory();
        procesarFabrica(fabricaBancoA);

        System.out.println("----------------------");

        // Seleccionar otra fábrica concreta (Banco B)
        FabricaFinanciera fabricaBancoB = new BancoBFactory();
        procesarFabrica(fabricaBancoB);

        // Mostrar información adicional
        System.out.println("\n🔍 Identidad: " + getIdentidad());
        System.out.println("🏛️ Patrón: " + getPatron());
    }

    // Método para procesar cualquier fábrica financiera sin acoplarse a una concreta
    public static void procesarFabrica(FabricaFinanciera fabrica) {
        Cuenta cuenta = fabrica.crearCuenta();
        Tarjeta tarjeta = fabrica.crearTarjeta();
        cuenta.abrir();
        tarjeta.emitir();
    }

    // Método para obtener la identidad en Base64
    public static String getIdentidad() {
        String nombreCompleto = "María José Noreña Rodriguez";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    // Método para obtener el patrón utilizado
    public static String getPatron() {
        return "Patrón Abstract Factory";
    }
}
