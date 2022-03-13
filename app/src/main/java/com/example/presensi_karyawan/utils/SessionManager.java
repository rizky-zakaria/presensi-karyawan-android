package com.example.presensi_karyawan.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.presensi_karyawan.model.DataLogin;

import java.util.HashMap;

public class SessionManager {

    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String USER_ID = "user_id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String ROLE = "role";
    public static final String NAMA = "nama";
    public static final String JABATAN = "jabatan";
    public static final String ALAMAT = "alamat";
    public static final String JK = "jenis_kelamin";
    public static final String NO_TELP = "no_telp";
    public static final String TTL = "tempat_tgl_lahir";

    public SessionManager (Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(DataLogin user){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(USER_ID, user.getId_user());
        editor.putString(USERNAME, user.getUsername());
        editor.putString(PASSWORD, user.getPassword());
        editor.putString(ROLE, user.getRole());
        editor.putString(NAMA, user.getNama());
        editor.putString(JABATAN, user.getJabatan());
        editor.putString(ALAMAT, user.getAlamat());
        editor.putString(JK, user.getJenis_kelamin());
        editor.putString(NO_TELP, user.getNo_telp());
        editor.putString(TTL, user.getTempat_tgl_lahir());
        editor.commit();
    }

    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(USER_ID, sharedPreferences.getString(USER_ID,null));
        user.put(USERNAME, sharedPreferences.getString(USERNAME,null));
        user.put(PASSWORD, sharedPreferences.getString(PASSWORD,null));
        user.put(ROLE, sharedPreferences.getString(ROLE, null));
        user.put(NAMA, sharedPreferences.getString(NAMA,null));
        user.put(JABATAN, sharedPreferences.getString(JABATAN,null));
        user.put(ALAMAT, sharedPreferences.getString(ALAMAT,null));
        user.put(JK, sharedPreferences.getString(JK,null));
        user.put(NO_TELP, sharedPreferences.getString(NO_TELP, null));
        user.put(TTL, sharedPreferences.getString(TTL, null));
        return user;
    }

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

    public String getRole()
    {
        return sharedPreferences.getString(ROLE, null);
    }

    public String getUserId()
    {
        return sharedPreferences.getString(USER_ID, null);
    }

    public String getUsername()
    {
        return sharedPreferences.getString(USERNAME, null);
    }

    public String getNama()
    {
        return sharedPreferences.getString(NAMA, null);
    }

    public String getJabatan()
    {
        return sharedPreferences.getString(JABATAN, null);
    }

    public String getTtl()
    {
        return sharedPreferences.getString(TTL, null);
    }

    public String getAlamat()
    {
        return sharedPreferences.getString(ALAMAT, null);
    }

    public String getJk()
    {
        return sharedPreferences.getString(JK, null);
    }

    public String getNoTelp()
    {
        return sharedPreferences.getString(NO_TELP, null);
    }
}
