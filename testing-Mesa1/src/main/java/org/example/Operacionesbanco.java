package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Operacionesbanco {
    public static void main(String[] args) {
        CCC CCC_1 = new CCC(50000, "Juani Carisima" );
        CCC CCC_2 = new CCC(12345, "Money");

        CCC_1.getDatosCuenta();
        CCC_2.getDatosCuenta();
        CCC_1.RealizarTransferenciaEntreCuentas(CCC_1,CCC_2, 2);
        CCC_1.getDatosCuenta();
        CCC_2.getDatosCuenta();

    }
}