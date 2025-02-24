package co.edu.ucc.MARIA.patron_prototipo;
// Interfaz Prototipo
interface CuentaBancaria extends Cloneable {
    CuentaBancaria clonar();
    void mostrarInfo();
}

// Clase Concreta que implementa el prototipo
class CuentaAhorros implements CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaAhorros(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    // Implementación del método de clonación
    @Override
    public CuentaBancaria clonar() {
        try {
            return (CuentaAhorros) super.clone();
        } catch (CloneNotSupportedException e) {
            return new CuentaAhorros(this.titular, this.saldo);
        }
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Titular: " + titular + ", Saldo: " + saldo);
    }
}