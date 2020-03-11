package com.juliarmanumar.kedaiwebsite;

public class Paket {


    private String nama_paket;
    private String harga_paket;
    private String deskripsi_paket;
    private String jenis_paket;

    public Paket(){

    }

    public Paket(String nama_paket, String harga_paket, String deskripsi_paket, String jenis_paket) {
        this.nama_paket = nama_paket;
        this.harga_paket = harga_paket;
        this.deskripsi_paket = deskripsi_paket;
        this.jenis_paket = jenis_paket;
    }


    public String getJenis_paket() {
        return jenis_paket;
    }

    public String getNama_paket() {
        return nama_paket;
    }

    public String getHarga_paket() {
        return harga_paket;
    }

    public String getDeskripsi_paket() {
        return deskripsi_paket;
    }


}
