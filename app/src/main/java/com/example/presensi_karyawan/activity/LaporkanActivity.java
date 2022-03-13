package com.example.presensi_karyawan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.presensi_karyawan.R;
import com.example.presensi_karyawan.api.ApiRequestData;
import com.example.presensi_karyawan.api.RetroServer;
import com.example.presensi_karyawan.model.ResponseLaporan;
import com.example.presensi_karyawan.utils.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaporkanActivity extends AppCompatActivity {

    EditText edtLaporan;
    Button button;
    String laporan, id_user;
    ApiRequestData apiRequestData;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporkan);

        edtLaporan = findViewById(R.id.laporan);
        button = findViewById(R.id.simpan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                laporan = edtLaporan.getText().toString();
                sessionManager = new SessionManager(getApplicationContext());
                id_user = sessionManager.getUserId();
                if (laporan.equals("")){
                    edtLaporan.setError("Silahkan Masukan Laporan!!!");
                }else {
                    insertLaporan(laporan, id_user);
                }
            }
        });

    }

    private void insertLaporan(String laporan, String id_user) {
        apiRequestData = RetroServer.konekRetrofit().create(ApiRequestData.class);
        Call<ResponseLaporan> laporanCall = apiRequestData.laporan(laporan, id_user);

        laporanCall.enqueue(new Callback<ResponseLaporan>() {
            @Override
            public void onResponse(Call<ResponseLaporan> call, Response<ResponseLaporan> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Berhasil Memasukan Laporan", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(), "Gagal Memasukan Laporan", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLaporan> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}