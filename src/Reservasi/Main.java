package Reservasi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import Pengguna.Customer;
import Pengguna.User;
import Pengguna.Admin;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Kamar kamar = new Kamar();
    static PesananKamar pesanan = new PesananKamar();
    static Admin admin = new Admin(kamar);
    static Customer customer = new Customer(kamar, pesanan);

    static User userSaatIni = null;

    public static void main(String[] args) {
        runApp();
    }

    public static void runApp() {
        System.out.println("------------------------------------------");
        System.out.println("Username Admin :  admin, Pass : admin123");
        System.out.println("Username Customer :  cust, Pass : cust123");
        System.out.println("------------------------------------------");
        while (userSaatIni == null) {
            System.out.print("Username: ");
            String username = input.next();
            System.out.print("Password: ");
            String password = input.next();

            if (admin.login(username, password)) {
                userSaatIni = admin;
                System.out.println("Log in sebagai Admin");
                adminMenu();
            } else if (customer.login(username, password)) {
                userSaatIni = customer;
                System.out.println("Log in sebagai Customer");
                customerMenu();
            } else {
                System.out.println("Username atau Pass salah. Silakan coba lagi.");
            }
        }
    }

    public static void logout() {
        System.out.println("Terimakasih telah mengunjungi Hotel! \n");
        userSaatIni = null;
        runApp();
    }

    public static void adminMenu() {
        int choice;
        int choiceEdit;

        do {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Lihat Data Kamar");
            System.out.println("2. Edit Kamar");
            System.out.println("3. Lihat Data Reservasi");
            System.out.println("4. Log out");
            System.out.print("Masukkan Pilihan: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    kamar.cekKamar();
                    break;
                case 2:
                    do {
                        System.out.println("\n--- Edit Kamar ---");
                        System.out.println("1. Tambah Kamar");
                        System.out.println("2. Hapus Kamar");
                        System.out.println("3. Edit Harga Kamar");
                        System.out.print("Masukkan Pilihan: ");
                        choiceEdit = input.nextInt();

                        switch (choiceEdit) {
                            case 1:
                                admin.tambahKamar();
                                break;
                            case 2:
                                admin.hapusKamar();
                                break;
                            case 3:
                                admin.editHargaKamar();
                                break;
                            default:
                                System.out.println("Pilihan tidak valid!");
                                break;
                        }
                    } while (choiceEdit < 1 || choiceEdit > 3);
                    break;
                case 3:
                    pesanan.getDetail(true);
                    break;
                case 4:
                    logout();
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (choice != 4);
    }

    public static void customerMenu() {
        int choice;
        do {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. Pesan Kamar");
            System.out.println("2. Cek Kamar Tersedia");
            System.out.println("3. Log out");
            System.out.print("Masukkan pilihan: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    customer.pesanKamar();
                    break;
                case 2:
                    kamar.cekKamar();
                    break;
                case 3:
                    logout();
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (choice != 4);
    }
}
