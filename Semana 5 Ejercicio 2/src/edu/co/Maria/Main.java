package edu.co.Maria;

import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        // Mostrar el encabezado con la historia de usuario
        mostrarEncabezado();

        // Crear un usuario usando el patrón Builder
        Usuario usuario = new Usuario.UsuarioBuilder("Juan Pérez")
                .setEdad(30)
                .setDireccion("Av. Principal 123")
                .setTelefono("123456789")
                .build();

        // Mostrar la información del usuario
        System.out.println(usuario);

        // Ejecutar los métodos getIdentidad() y getPatron() al final
        System.out.println("\nInformación adicional:");
        System.out.println("Identidad codificada: " + getIdentidad());
        System.out.println(getPatron());
    }

    // Método para mostrar el encabezado con la historia de usuario
    public static void mostrarEncabezado() {
        System.out.println("🚀============================🚀");
        System.out.println("👩‍💻 Nombre: María José");
        System.out.println("🏫 Universidad: Universidad Cooperativa de Colombia");
        System.out.println("📍 Campus: Cali");
        System.out.println("📂 Repositorio Git: https://github.com/mariajosenore/Semana-3-Patrones-de-Dise-o-.git");
        System.out.println("📜 Historia de usuario:");
        System.out.println("   Como desarrollador,");
        System.out.println("   quiero implementar un sistema de vehículos que utilice el patrón Factory Method");
        System.out.println("   para eliminar la creación manual de objetos,");
        System.out.println("   y además agregar métodos para obtener la identidad del desarrollador y el patrón implementado,");
        System.out.println("   para que el código sea más claro y mantenible.");
        System.out.println("🚀============================🚀");
    }

    // Método para obtener la identidad del desarrollador codificada en Base64
    public static String getIdentidad() {
        String nombreCompleto = "María José"; // Cambia esto por tu nombre completo
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    // Método para obtener el patrón implementado
    public static String getPatron() {
        return "Patrón implementado: Builder";
    }
}

// Clase Usuario con el patrón Builder
class Usuario {
    private String nombre;
    private int edad;
    private String direccion;
    private String telefono;

    private Usuario(UsuarioBuilder builder) {
        this.nombre = builder.nombre;
        this.edad = builder.edad;
        this.direccion = builder.direccion;
        this.telefono = builder.telefono;
    }

    public static class UsuarioBuilder {
        private String nombre;
        private int edad;
        private String direccion;
        private String telefono;

        public UsuarioBuilder(String nombre) {
            this.nombre = nombre;
        }

        public UsuarioBuilder setEdad(int edad) {
            this.edad = edad;
            return this;
        }

        public UsuarioBuilder setDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public UsuarioBuilder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }

    @Override
    public String toString() {
        return "Usuario: " + nombre + ", Edad: " + edad + ", Dirección: " + direccion + ", Teléfono: " + telefono;
    }
}