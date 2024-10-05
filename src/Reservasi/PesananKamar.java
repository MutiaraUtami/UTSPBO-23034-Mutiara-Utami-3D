package Reservasi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class PesananKamar implements InterfacePesananKamar {
    String nama, alamat, tipeKamar;
    int noKtp, noHp, lamaMenginap, totalBayar;
    static int reservationCount = 0;

    static PesananKamar[] reservations = new PesananKamar[10];

    @Override
    public void setDetailPesanan(String nama, String alamat, int noKtp, int noHp, String tipeKamar, int lamaMenginap, int totalBayar) {
        this.nama = nama;
        this.alamat = alamat;
        this.noKtp = noKtp;
        this.noHp = noHp;
        this.tipeKamar = tipeKamar;
        this.lamaMenginap = lamaMenginap;
        this.totalBayar = totalBayar;

        if (reservationCount < reservations.length) {
            reservations[reservationCount] = this;
            reservationCount++;
        } else {
            System.out.println("Reservasi sudah penuh.");
        }
    }

    @Override
    public void getDetail(boolean isAdmin) {
        if (isAdmin) {
            if (reservationCount == 0) {
                System.out.println("Tidak ada reservasi.");
                return;
            }

            System.out.println("\n--- Daftar Semua Reservasi ---");
            for (int i = 0; i < reservationCount; i++) {
                PesananKamar pesanan = reservations[i];
                if (pesanan != null) {
                    System.out.println("Nama              : " + pesanan.nama);
                    System.out.println("Alamat            : " + pesanan.alamat);
                    System.out.println("No KTP            : " + pesanan.noKtp);
                    System.out.println("No HP             : " + pesanan.noHp);
                    System.out.println("Tipe Kamar        : " + pesanan.tipeKamar);
                    System.out.println("Lama Menginap     : " + pesanan.lamaMenginap + " hari");
                    System.out.println("Total Pembayaran  : Rp. " + pesanan.totalBayar);
                    System.out.println("-------------------------------");
                }
            }
        } else {
            getDetail();
        }
    }

    @Override
    public void getDetail() {
            System.out.println("\n--- Detail Pesanan Kamar Anda ---");
            System.out.println("Nama              : " + nama);
            System.out.println("Alamat            : " + alamat);
            System.out.println("No KTP            : " + noKtp);
            System.out.println("No HP             : " + noHp);
            System.out.println("Tipe Kamar        : " + tipeKamar);
            System.out.println("Lama Menginap     : " + lamaMenginap + " hari");
            System.out.println("Total Pembayaran  : Rp. " + totalBayar);
            System.out.println("-------------------------------");
    }

    @Override
    public boolean isBooked() {
        return nama != null;
    }
}

