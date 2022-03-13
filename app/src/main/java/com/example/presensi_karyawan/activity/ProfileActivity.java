package com.example.presensi_karyawan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.presensi_karyawan.R;
import com.example.presensi_karyawan.utils.SessionManager;

public class ProfileActivity extends AppCompatActivity {

    TextView username, nama, jabatan, tgl_lahir, alamat, jk, no_telp;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        username = findViewById(R.id.username);
        nama = findViewById(R.id.nama);
        jabatan = findViewById(R.id.jabatan);
        tgl_lahir = findViewById(R.id.tgl_lahir);
        alamat = findViewById(R.id.alamat);
        jk = findViewById(R.id.jk);
        no_telp = findViewById(R.id.no_telp);
        SessionManager sessionManager = new SessionManager(getApplicationContext());
        username.setText(sessionManager.getUsername());
        nama.setText(sessionManager.getNama());
        jabatan.setText(sessionManager.getJabatan());
        tgl_lahir.setText(sessionManager.getTtl());
        alamat.setText(sessionManager.getAlamat());
        jk.setText(sessionManager.getJk());
        no_telp.setText(sessionManager.getNoTelp());

        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logoutSession();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });
    }
}