package co.edu.ucc.MARIA.patron_factory_method;

// Cliente
public class Main {
    public static void main(String[] args) {
        MedicamentoFactory factory = new AnalgesicoFactory();
        Medicamento medicamento = factory.crearMedicamento();
        medicamento.administrar();
        System.out.println("Identidad: " + medicamento.getIdentidad());
        System.out.println("Patrón: " + medicamento.getPatron());

        factory = new AntibioticoFactory();
        medicamento = factory.crearMedicamento();
        medicamento.administrar();
        System.out.println("Identidad: " + medicamento.getIdentidad());
        System.out.println("Patrón: " + medicamento.getPatron());
    }
}
