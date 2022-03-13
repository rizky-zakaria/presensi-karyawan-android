package com.example.presensi_karyawan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.presensi_karyawan.R;
import com.example.presensi_karyawan.api.ApiRequestData;
import com.example.presensi_karyawan.api.RetroServer;
import com.example.presensi_karyawan.model.ResponseAbsen;
import com.example.presensi_karyawan.utils.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    SessionManager sessionManager;
    ImageButton datang, pulang;
    ApiRequestData AbPulang, AbDatang;
    String id_user, flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView hello = findViewById(R.id.hello);
        sessionManager = new SessionManager(getApplicationContext());
        hello.setText("Selamat Datang, " + sessionManager.getUsername());
        datang = findViewById(R.id.btn_datang);
        datang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                absenDatang();
            }
        });

        sessionManager = new SessionManager(MainActivity.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }

        pulang = findViewById(R.id.btn_pulang);
        pulang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                absenPulang();
            }
        });

        Button laporkan = findViewById(R.id.laporkan);
        laporkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LaporkanActivity.class));
            }
        });

        ImageView profile = findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            }
        });
    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    private void absenDatang() {
        sessionManager = new SessionManager(getApplicationContext());
        id_user = sessionManager.getUserId();
        flag = "datang";
        AbDatang = RetroServer.konekRetrofit().create(ApiRequestData.class);
        Call<ResponseAbsen> responseAbsenCall = AbDatang.presensi(id_user, flag);
        responseAbsenCall.enqueue(new Callback<ResponseAbsen>() {
            @Override
            public void onResponse(Call<ResponseAbsen> call, Response<ResponseAbsen> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Anda Berhasil Melakukan Absensi Datang", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Anda Gagal Melakukan Absensi Datang", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAbsen> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void absenPulang() {
        sessionManager = new SessionManager(getApplicationContext());
        id_user = sessionManager.getUserId();
        flag = "pulang";
//        Toast.makeText(getApplicationContext(), flag, Toast.LENGTH_SHORT).show();
        AbDatang = RetroServer.konekRetrofit().create(ApiRequestData.class);
        Call<ResponseAbsen> responseAbsenCall = AbDatang.presensi(id_user, flag);
        responseAbsenCall.enqueue(new Callback<ResponseAbsen>() {
            @Override
            public void onResponse(Call<ResponseAbsen> call, Response<ResponseAbsen> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Anda Berhasil Melakukan Absensi Pulang", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Anda Gagal Melakukan Absensi Pulang", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAbsen> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}