package org.example;

import java.util.Random;

public class CCC {

    private double saldoDeCuenta;
    private String nombreDelTitular;
    private long numeroDeCuenta;

    public CCC(double saldoDeCuenta, String nombreDelTitular) {
        this.saldoDeCuenta = saldoDeCuenta;
        this.nombreDelTitular = nombreDelTitular;
        Random numero = new Random();
        this.numeroDeCuenta = Math.abs(numero.nextLong());
//        this.numeroDeCuenta = (long) Math.random();
    }

    public void setIngreso(double monto){
        saldoDeCuenta += monto;
    }

    public void setReintegro(double monto){
        saldoDeCuenta -= monto;
    }

    public double getSaldoDeCuenta() {
        return saldoDeCuenta;
    }

    public void getDatosCuenta(){
        System.out.println("Num cuenta:" + numeroDeCuenta + "\n" + "Nombre titular: " + nombreDelTitular + "\n" + "Saldo: " + saldoDeCuenta);
    }

    public String getNombreDelTitular() {
        return nombreDelTitular;
    }

    public long getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setSaldoDeCuenta(double saldoDeCuenta) {
        this.saldoDeCuenta = saldoDeCuenta;
    }

    public void setNombreDelTitular(String nombreDelTitular) {
        this.nombreDelTitular = nombreDelTitular;
    }

    public void setNumeroDeCuenta(long numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public void RealizarTransferenciaEntreCuentas(CCC cuentaOrigen,CCC cuentaDestino, double cantidad) {
        if (cantidad <= saldoDeCuenta) {
            setReintegro(cantidad);
            cuentaDestino.setIngreso(cantidad);
            System.out.println("Transferencia realizada exitosamente.");
        } else {
            System.out.println("Saldo insuficiente para realizar la transferencia.");
        }
    }


}
