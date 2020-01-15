package com.ppsi.crudpegawai;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Dibawah ini merupakan perintah untuk mendefinikan View
    private EditText editTextNama;
    private EditText editTextPosisi;
    private EditText editTextGaji;

    private Button buttonTambah;
    private Button buttonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi dari View
        editTextNama = (EditText) findViewById(R.id.editTextNama);
        editTextPosisi = (EditText) findViewById(R.id.editTextPosisi);
        editTextGaji = (EditText) findViewById(R.id.editTextGaji);

        buttonTambah = (Button) findViewById(R.id.buttonTambah);
        buttonList = (Button) findViewById(R.id.buttonList);

        //Setting listeners to button
        buttonTambah.setOnClickListener(this);
        buttonList.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(v == buttonTambah){
            addEmployee();
        }

        if(v == buttonList){
            startActivity(new Intent(this,TampilSemuaPegawaiActivity.class));
        }
    }

    //Dibawah ini merupakan perintah untuk Menambahkan Pegawai (CREATE)
    private void addEmployee(){

        final String namaL = editTextNama.getText().toString().trim();
        final String posisiL = editTextPosisi.getText().toString().trim();
        final String gajiL = editTextGaji.getText().toString().trim();

        class AddEmployee extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }
//ini doang yang wajib!!!
            @Override                       
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_PEG_NAMA,namaL);
                params.put(Konfigurasi.KEY_PEG_POSISI,posisiL);
                params.put(Konfigurasi.KEY_PEG_GAJI,gajiL);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Konfigurasi.URL_ADD, params);

                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }




}
