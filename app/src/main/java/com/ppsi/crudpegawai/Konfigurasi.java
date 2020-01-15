package com.ppsi.crudpegawai;

public class Konfigurasi {

    //Dibawah ini merupakan Pengalamatan dimana Lokasi Skrip CRUD PHP disimpan
    //Pada tutorial Kali ini, karena kita membuat localhost maka alamatnya tertuju ke IP komputer
    //dimana File PHP tersebut berada
    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA

    public static final String URL_ADD="http://192.168.1.161/AndroidCrud/TambahPegawai.php";
    public static final String URL_GET_ALL = "http://192.168.1.161/AndroidCrud/TampilSemuaPegawai.php";
    public static final String URL_GET_PEG = "http://192.168.1.161/AndroidCrud/TampilPegawai.php?id=";
    public static final String URL_UPDATE_PEG = "http://192.168.1.161/AndroidCrud/UpdatePegawai.php";
    public static final String URL_DELETE_PEG = "http://192.168.1.161/AndroidCrud/DeletePegawai.php?id=";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_PEG_ID = "id";
    public static final String KEY_PEG_NAMA = "nama";
    public static final String KEY_PEG_POSISI = "posisi"; //desg itu variabel untuk posisi
    public static final String KEY_PEG_GAJI = "gaji"; //salary itu variabel untuk gajih

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_POSISI = "posisi";
    public static final String TAG_GAJI = "gaji";

    //ID karyawan
    //emp itu singkatan dari Employee
    public static final String PEG_ID = "id";
}
