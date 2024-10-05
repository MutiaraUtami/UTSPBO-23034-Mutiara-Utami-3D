package Pengguna;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Reservasi.PesananKamar;
import Reservasi.Kamar;

import java.util.Scanner;

public class Admin extends User {
    Scanner input = new Scanner(System.in);
    Kamar kamar;

    public Admin(Kamar kamar) {
        super("admin", "admin123", "admin");
        this.kamar = kamar;
    }

    String tipeKamar;
    int jumlah;

    public void tambahKamar() {
        System.out.print("Masukkan tipe kamar (single/double/suite): ");
        tipeKamar = input.nextLine().toLowerCase();
        System.out.print("Masukkan jumlah kamar yang ingin ditambahkan: ");
        if (input.hasNextInt()) {
            jumlah = input.nextInt();
            input.nextLine();
        }

        switch (tipeKamar) {
            case "single" -> {
                kamar.kamarSingle += jumlah;
                System.out.println(jumlah + " kamar single ditambahkan.");
                System.out.println("Total kamar single sekarang: " + kamar.kamarSingle);
            }
            case "double" -> {
                kamar.kamarDouble += jumlah;
                System.out.println(jumlah + " kamar double ditambahkan.");
                System.out.println("Total kamar double sekarang: " + kamar.kamarDouble);
            }
            case "suite" -> {
                kamar.kamarSuite += jumlah;
                System.out.println(jumlah + " kamar suite ditambahkan.");
                System.out.println("Total kamar suite sekarang: " + kamar.kamarSuite);
            }
            default -> System.out.println("Tipe kamar tidak valid!");
        }
    }

    public void hapusKamar() {
        System.out.print("Masukkan tipe kamar (single/double/suite): ");
        tipeKamar = input.nextLine().toLowerCase();
        System.out.print("Masukkan jumlah kamar yang ingin dihapus: ");
        if (input.hasNextInt()) {
            jumlah = input.nextInt();
            input.nextLine();
        }

        switch (tipeKamar) {
            case "single" -> {
                if (kamar.kamarSingle >= jumlah) {
                    kamar.kamarSingle -= jumlah;
                    System.out.println(jumlah + " kamar single dihapus.");
                    System.out.println("Total kamar single sekarang: " + kamar.kamarSingle);
                } else {
                    System.out.println("Jumlah kamar single tidak mencukupi untuk dihapus.");
                }
            }
            case "double" -> {
                if (kamar.kamarDouble >= jumlah) {
                    kamar.kamarDouble -= jumlah;
                    System.out.println(jumlah + " kamar double dihapus.");
                    System.out.println("Total kamar double sekarang: " + kamar.kamarDouble);
                } else {
                    System.out.println("Jumlah kamar double tidak mencukupi untuk dihapus.");
                }
            }
            case "suite" -> {
                if (kamar.kamarSuite >= jumlah) {
                    kamar.kamarSuite -= jumlah;
                    System.out.println(jumlah + " kamar suite dihapus.");
                    System.out.println("Total kamar suite sekarang: " + kamar.kamarSuite);
                } else {
                    System.out.println("Jumlah kamar suite tidak mencukupi untuk dihapus.");
                }
            }
            default -> System.out.println("Tipe kamar tidak valid!");
        }
    }

    public void editHargaKamar() {
        System.out.print("Masukkan tipe kamar (single/double/suite): ");
        tipeKamar = input.nextLine().toLowerCase();
        System.out.print("Masukkan harga baru: ");
        int hargaBaru = 0;
        if (input.hasNextInt()) {
            hargaBaru = input.nextInt();
            input.nextLine();
        }

        switch (tipeKamar) {
            case "single" -> {
                kamar.hargaSingle = hargaBaru;
                System.out.println("Harga kamar Single diubah menjadi Rp. " + hargaBaru);
            }
            case "double" -> {
                kamar.hargaDouble = hargaBaru;
                System.out.println("Harga kamar Double diubah menjadi Rp. " + hargaBaru);
            }
            case "suite" -> {
                kamar.hargaSuite = hargaBaru;
                System.out.println("Harga kamar Suite diubah menjadi Rp. " + hargaBaru);
            }
            default -> System.out.println("Tipe kamar tidak valid!");
        }
    }
    
    
}