package co.edu.ucc.MARIA.patron_builder;

import java.util.Base64;

class Paciente {
    private String nombre;
    private int edad;
    private String diagnostico;

    // Constructor privado para forzar el uso del Builder
    private Paciente(Builder builder) {
        this.nombre = builder.nombre;
        this.edad = builder.edad;
        this.diagnostico = builder.diagnostico;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    // Método para obtener la identidad en Base64
    public String getIdentidad() {
        if (nombre == null || nombre.isEmpty()) {
            return "Identidad no disponible";
        }
        return Base64.getEncoder().encodeToString(nombre.getBytes());
    }

    // Método que indica el patrón de diseño usado
    public String getPatron() {
        return "Builder";
    }

    // Sobrescribir toString() para mostrar información del paciente
    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", diagnostico='" + diagnostico + '\'' +
                '}';
    }

    // Clase estática interna Builder
    public static class Builder {
        private String nombre;
        private int edad;
        private String diagnostico;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setEdad(int edad) {
            if (edad < 0) {
                throw new IllegalArgumentException("La edad no puede ser negativa");
            }
            this.edad = edad;
            return this;
        }

        public Builder setDiagnostico(String diagnostico) {
            this.diagnostico = diagnostico;
            return this;
        }

        public Paciente build() {
            return new Paciente(this);
        }
    }

    public static void main(String[] args) {
        // Crear un objeto Paciente usando el patrón Builder
        Paciente paciente = new Paciente.Builder()
                .setNombre("María José Noreña Rodriguez")
                .setEdad(19)
                .setDiagnostico("Diabetica")
                .build();

        // Mostrar información del paciente
        System.out.println(paciente);

        // Mostrar la identidad en Base64
        System.out.println("Identidad (Base64): " + paciente.getIdentidad());

        // Mostrar el patrón utilizado
        System.out.println("Patrón de diseño: " + paciente.getPatron());
    }
}
