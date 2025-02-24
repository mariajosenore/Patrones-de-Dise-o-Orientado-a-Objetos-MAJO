package co.edu.ucc.MARIA.patron_factory_method;

import java.util.Base64;

// Producto abstracto
interface Medicamento {
    void administrar();
    String getIdentidad();
    String getPatron();
}

// Producto concreto: Analgésico
class Analgesico implements Medicamento {
    @Override
    public void administrar() {
        System.out.println("Administrando analgésico para el dolor.");
    }

    @Override
    public String getIdentidad() {
        String nombreCompleto = "PRIMER_NOMBRE APELLIDO";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    @Override
    public String getPatron() {
        return "Factory Method";
    }
}

// Producto concreto: Antibiótico
class Antibiotico implements Medicamento {
    @Override
    public void administrar() {
        System.out.println("Administrando antibiótico para la infección.");
    }

    @Override
    public String getIdentidad() {
        String nombreCompleto = "María José Noreña Rodriguez";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    @Override
    public String getPatron() {
        return "Factory Method";
    }
}

// Interfaz Factory
interface MedicamentoFactory {
    Medicamento crearMedicamento();
}

// Factory concreto para Analgésico
class AnalgesicoFactory implements MedicamentoFactory {
    @Override
    public Medicamento crearMedicamento() {
        return new Analgesico();
    }
}

// Factory concreto para Antibiótico
class AntibioticoFactory implements MedicamentoFactory {
    @Override
    public Medicamento crearMedicamento() {
        return new Antibiotico();
    }
}

