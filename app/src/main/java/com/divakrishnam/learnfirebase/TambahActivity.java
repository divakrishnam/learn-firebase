package com.divakrishnam.learnfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNama, etMerk, etHarga;
    private Button btnSimpan;
    private DatabaseReference database;

    String nama, merk, harga;
    Barang barang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNama = findViewById(R.id.et_nama);
        etMerk = findViewById(R.id.et_merk);
        etHarga = findViewById(R.id.et_harga);
        btnSimpan = findViewById(R.id.btn_simpan);

        database  = FirebaseDatabase.getInstance().getReference();

        btnSimpan.setOnClickListener(this);

        barang = (Barang) getIntent().getSerializableExtra("data");

        if (barang != null){
            etNama.setText(barang.getNama());
            etHarga.setText(barang.getHarga());
            etMerk.setText(barang.getMerk());
        }{

        }
    }

    @Override
    public void onClick(View view) {
        if (view == btnSimpan){
            nama = etNama.getText().toString();
            harga = etHarga.getText().toString();
            merk = etMerk.getText().toString();

            if (barang != null){
                barang.setNama(nama);
                barang.setMerk(merk);
                barang.setHarga(harga);
                ubah(barang);
            }else{
                simpan(new Barang(nama, harga, merk));
            }
        }
    }

    private void ubah(Barang barang) {
        database.child("barang")
                .child(barang.getKey())
                .setValue(barang)
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(), "Data berhasil diubah", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void simpan(Barang barang) {
        database.child("barang").push().setValue(barang).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etHarga.setText("");
                etMerk.setText("");
                etNama.setText("");
                Toast.makeText(getApplicationContext(), "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static Intent getActIntent(Activity activity) {
        return new Intent(activity, TambahActivity.class);
    }
}
