package com.divakrishnam.learnfirebase;

import java.io.Serializable;

public class Barang implements Serializable {
    private String nama;
    private String merk;
    private String harga;
    private String key;

    public Barang() {
    }

    public Barang(String nama, String merk, String harga) {
        this.nama = nama;
        this.merk = merk;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Barang{" +
                "nama='" + nama + '\'' +
                ", merk='" + merk + '\'' +
                ", harga='" + harga + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
