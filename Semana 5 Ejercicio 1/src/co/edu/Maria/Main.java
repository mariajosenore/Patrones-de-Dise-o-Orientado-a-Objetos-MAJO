package src.co.edu.Maria;

import java.util.Base64;

// Interfaz común para Botón
interface Boton {
    void render();
}

// Interfaz común para Ventana
interface Ventana {
    void mostrar();
}

// Implementaciones para Light Mode
class BotonLight implements Boton {
    public void render() { System.out.println("Renderizando botón Light"); }
}

class VentanaLight implements Ventana {
    public void mostrar() { System.out.println("Mostrando ventana Light"); }
}

// Implementaciones para Dark Mode
class BotonDark implements Boton {
    public void render() { System.out.println("Renderizando botón Dark"); }
}

class VentanaDark implements Ventana {
    public void mostrar() { System.out.println("Mostrando ventana Dark"); }
}

// Abstract Factory
interface GUIFactory {
    Boton crearBoton();
    Ventana crearVentana();
}

// Fábricas concretas
class LightFactory implements GUIFactory {
    public Boton crearBoton() { return new BotonLight(); }
    public Ventana crearVentana() { return new VentanaLight(); }
}

class DarkFactory implements GUIFactory {
    public Boton crearBoton() { return new BotonDark(); }
    public Ventana crearVentana() { return new VentanaDark(); }
}

// Cliente
public class Main {
    public static void main(String[] args) {
        mostrarEncabezado(); // Mostrar el encabezado al inicio

        GUIFactory factory = new DarkFactory(); // Puede cambiarse por LightFactory
        Boton boton = factory.crearBoton();
        Ventana ventana = factory.crearVentana();
        boton.render();
        ventana.mostrar();

        // Ejecutar métodos getIdentidad() y getPatron() al final
        Logger.log("\nInformación adicional:");
        Logger.log("Identidad codificada: " + getIdentidad());
        Logger.log(getPatron());
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
        System.out.println("   quiero implementar un sistema de interfaces gráficas que utilice el patrón Abstract Factory");
        System.out.println("   para crear familias de objetos relacionados (como botones y ventanas)");
        System.out.println("   sin especificar sus clases concretas,");
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
        return "Patrón implementado: Abstract Factory";
    }
}

// Clase para manejar el logueo
class Logger {
    public static void log(String mensaje) {
        System.out.println("[LOG] " + mensaje);
    }
}