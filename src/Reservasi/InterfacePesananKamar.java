package Reservasi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

public interface InterfacePesananKamar {
    public void setDetailPesanan(String nama, String alamat, int noKtp, int noHp, 
            String tipeKamar, int lamaMenginap, int totalBayar);
    public void getDetail(boolean isAdmin);
    public void getDetail();
    public boolean isBooked();
}
