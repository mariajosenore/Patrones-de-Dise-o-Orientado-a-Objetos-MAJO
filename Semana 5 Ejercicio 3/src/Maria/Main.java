package Maria;

import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        mostrarEncabezado(); // Mostrar el encabezado al inicio

        try {
            // Crear un documento original
            Documento docOriginal = new Documento("Plantilla Base");
            
            // Clonar el documento
            Documento docClonado = docOriginal.clone();

            // Mostrar el contenido de ambos documentos
            docOriginal.mostrar();
            docClonado.mostrar();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // Ejecutar métodos getIdentidad() y getPatron() al final
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
        System.out.println("   quiero implementar un sistema de clonación de documentos");
        System.out.println("   utilizando el patrón Prototype,");
        System.out.println("   para evitar la creación manual de objetos y mejorar la eficiencia,");
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
        return "Patrón implementado: Prototype";
    }
}

// Clase Documento que implementa Cloneable para permitir la clonación
class Documento implements Cloneable {
    private String contenido;

    // Constructor
    public Documento(String contenido) {
        this.contenido = contenido;
    }

    // Método para mostrar el contenido del documento
    public void mostrar() {
        System.out.println("Contenido del documento: " + contenido);
    }

    // Método para clonar el documento
    @Override
    protected Documento clone() throws CloneNotSupportedException {
        return (Documento) super.clone();
    }
}