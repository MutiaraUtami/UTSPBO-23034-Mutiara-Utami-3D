package Pengguna;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Reservasi.PesananKamar;
import Reservasi.Kamar;

import java.util.Scanner;

public class Customer extends User {
    Scanner input = new Scanner(System.in);
    Kamar kamar;
    PesananKamar pesanan;

    public Customer(Kamar kamar, PesananKamar pesanan1) {
        super("cust", "cust123", "cust");
        this.kamar = kamar;
    }

    public void pesanKamar() {
        System.out.println("Pilih tipe kamar untuk dipesan:");
        System.out.println("1. Single - Rp. 175.000 / Hari");
        System.out.println("2. Double - Rp. 225.000 / Hari");
        System.out.println("3. Suite - Rp. 300.000 / Hari");
        System.out.print("Masukkan pilihan tipe kamar: ");
        int pilihanKamar = input.nextInt();

        String tipeKamar;

        switch (pilihanKamar) {
            case 1 -> tipeKamar = "Single";
            case 2 -> tipeKamar = "Double";
            case 3 -> tipeKamar = "Suite";
            default -> {
                System.out.println("Pilihan tipe kamar tidak valid!");
                return;
            }
        }

        if (!kamar.bookKamar(tipeKamar)) {
            System.out.println("Maaf, kamar " + tipeKamar + " sudah penuh.");
            return;
        }

        System.out.print("Masukkan lama menginap (hari): ");
        int lamaMenginap = input.nextInt();
        int totalBayar = kamar.getHargaKamar(tipeKamar) * lamaMenginap;

        System.out.print("Masukkan nama: ");
        String nama = input.next();
        System.out.print("Masukkan alamat: ");
        String alamat = input.next();
        System.out.print("Masukkan No KTP: ");
        int noKtp = input.nextInt();
        System.out.print("Masukkan No HP: ");
        int noHp = input.nextInt();

        pesanan = new PesananKamar();
        pesanan.setDetailPesanan(nama, alamat, noKtp, noHp, tipeKamar, lamaMenginap, totalBayar);

        System.out.println("Pesanan diterima! Total yang harus dibayar: Rp. " + totalBayar);
        pesanan.getDetail();
    }
}
