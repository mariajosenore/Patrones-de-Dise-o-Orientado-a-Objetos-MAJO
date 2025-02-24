package co.edu.ucc.MARIA.patron_prototipo;

// Clase Cliente que utiliza el prototipo
public class Main {
    public static void main(String[] args) {
        // Crear una cuenta de ahorros original
        CuentaAhorros cuentaOriginal = new CuentaAhorros("María José Noreña Rodriguez", 5000.0);
        System.out.println("Cuenta Original:");
        cuentaOriginal.mostrarInfo();

        // Usar el prototipo para clonar la cuenta
        CuentaAhorros cuentaClonada = (CuentaAhorros) cuentaOriginal.clonar();
        System.out.println("\nCuenta Clonada:");
        cuentaClonada.mostrarInfo();
    }
}
