package co.edu.ucc.MARIA.patron_abstract_factory;

import java.util.Base64;

// 🔹 Producto abstracto: Cuenta
interface Cuenta {
    void abrir();
}

// 🔹 Producto concreto: Cuenta Corriente
class CuentaCorriente implements Cuenta {
    @Override
    public void abrir() {
        System.out.println("✅ Abriendo cuenta corriente.");
    }
}

// 🔹 Producto concreto: Cuenta Ahorros
class CuentaAhorros implements Cuenta {
    @Override
    public void abrir() {
        System.out.println("✅ Abriendo cuenta de ahorros.");
    }
}

// 🔹 Producto abstracto: Tarjeta
interface Tarjeta {
    void emitir();
}

// 🔹 Producto concreto: Tarjeta Débito
class TarjetaDebito implements Tarjeta {
    @Override
    public void emitir() {
        System.out.println("💳 Emitiendo tarjeta de débito.");
    }
}

// 🔹 Producto concreto: Tarjeta Crédito
class TarjetaCredito implements Tarjeta {
    @Override
    public void emitir() {
        System.out.println("💳 Emitiendo tarjeta de crédito.");
    }
}

// 🔹 Fábrica abstracta: Define métodos para crear productos abstractos
interface FabricaFinanciera {
    Cuenta crearCuenta();
    Tarjeta crearTarjeta();
}

// 🔹 Fábrica concreta: Banco A (ofrece Cuenta Corriente y Tarjeta Crédito)
class BancoAFactory implements FabricaFinanciera {
    @Override
    public Cuenta crearCuenta() {
        return new CuentaCorriente();
    }

    @Override
    public Tarjeta crearTarjeta() {
        return new TarjetaCredito();
    }
}

// 🔹 Fábrica concreta: Banco B (ofrece Cuenta Ahorros y Tarjeta Débito)
class BancoBFactory implements FabricaFinanciera {
    @Override
    public Cuenta crearCuenta() {
        return new CuentaAhorros();
    }

    @Override
    public Tarjeta crearTarjeta() {
        return new TarjetaDebito();
    }
}
