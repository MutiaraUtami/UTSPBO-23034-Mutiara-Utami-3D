package Reservasi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Kamar implements InterfaceKamar {
    public int kamarSingle = 10, kamarDouble = 10, kamarSuite = 10;
    public int hargaSingle = 175000, hargaDouble = 225000, hargaSuite = 300000;

    @Override
    public void cekKamar() {
        System.out.println("\n--- Status Kamar ---");
        System.out.println("Kamar Single yang Tersedia: " + kamarSingle);
        System.out.println("Kamar Double yang Tersedia: " + kamarDouble);
        System.out.println("Kamar Suite yang Tersedia: " + kamarSuite);
    }

    @Override
    public boolean bookKamar(String tipeKamar) {
        switch (tipeKamar.toLowerCase()) { 
            case "single" -> {
                if (kamarSingle > 0) {
                    kamarSingle--;
                    return true;
                }
            }
            case "double" -> {
                if (kamarDouble > 0) {
                    kamarDouble--;
                    return true;
                }
            }
            case "suite" -> {
                if (kamarSuite > 0) {
                    kamarSuite--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int getHargaKamar(String tipeKamar) {
        return switch (tipeKamar.toLowerCase()) {
            case "single" -> hargaSingle;
            case "double" -> hargaDouble;
            case "suite" -> hargaSuite;
            default -> 0;
        };
    }
}

