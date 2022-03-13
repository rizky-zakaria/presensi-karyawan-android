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
import com.example.presensi_karyawan.model.DataLogin;
import com.example.presensi_karyawan.model.ResponseLogin;
import com.example.presensi_karyawan.utils.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public Button simpan;
    public EditText etUsername, etPassword;
    String Username, Password;
    ApiRequestData apiInterface;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(LoginActivity.this);
        if(sessionManager.isLoggedIn()){
            String username = sessionManager.getUserDetail().get(SessionManager.ROLE);
            if (username.equals("")){
                Toast.makeText(getApplicationContext(), "Login Dulu Bossque", Toast.LENGTH_SHORT).show();
            }else {
                moveToMain();
            }
        }

        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);

        Button btnLogin = findViewById(R.id.btn_masuk);
        btnLogin.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_masuk:
                Username = etUsername.getText().toString();
                Password = etPassword.getText().toString();
//                Toast.makeText(getApplicationContext(), Username + Password, Toast.LENGTH_SHORT).show();
                if (Username.equals("")){
//                    Toast.makeText(getApplicationContext(), "Username Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                    etUsername.setError("Masukan Username");
                }else if (Password.equals("")){
//                    Toast.makeText(getApplicationContext(), "Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                    etPassword.setError("Masukan Password");
                }else {
                    login(Username,Password);
//                    Toast.makeText(getApplicationContext(), Username + Password, Toast.LENGTH_SHORT).show();
                }
//                Toast.makeText(LoginActivity.this, "nama : " + Username , Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void login(String username, String password) {
        apiInterface = RetroServer.konekRetrofit().create(ApiRequestData.class);
        Call<ResponseLogin> loginCall = apiInterface.loginResponse(username, password);
//        Toast.makeText(getApplicationContext(), username + " " + password, Toast.LENGTH_SHORT).show();

        loginCall.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){

                    // Ini untuk menyimpan sesi
                    sessionManager = new SessionManager(LoginActivity.this);
                    DataLogin loginData = response.body().getDataLogin();
                    sessionManager.createLoginSession(loginData);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
//                    Toast.makeText(LoginActivity.this, response.body().getMessages(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void moveToMain() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}