package com.divakrishnam.learnfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTambah, btnLihat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTambah = findViewById(R.id.btn_tambah);
        btnLihat = findViewById(R.id.btn_lihat);

        btnTambah.setOnClickListener(this);
        btnLihat.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnTambah){
            Intent tambah = new Intent(getApplicationContext(), TambahActivity.class);
            startActivity(tambah);

        }else if(view == btnLihat){
            Intent lihat = new Intent(getApplicationContext(), LihatActivity.class);
            startActivity(lihat);
        }
    }
}
