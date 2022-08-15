package com.example.dts_minggu_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView hasil;
    EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hasil = findViewById(R.id.hasil);
        editText1 = findViewById(R.id.input_pertama);
        editText2 = findViewById(R.id.input_kedua);

        Button btn_kali = findViewById(R.id.btn_kali);
        Button btn_bagi = findViewById(R.id.btn_bagi);
        Button btn_tambah = findViewById(R.id.btn_tambah);
        Button btn_kurang = findViewById(R.id.btn_kurang);
        Button btn_reset = findViewById(R.id.btn_reset);

        btn_kali.setOnClickListener(this);
        btn_bagi.setOnClickListener(this);
        btn_tambah.setOnClickListener(this);
        btn_kurang.setOnClickListener(this);
        btn_reset.setOnClickListener(this);

    }

    protected  void operasi(String operator)
    {
        if(editText1.getText().toString().isEmpty()){
            editText1.setError("Angka pertama tidak boleh kosong !");
            editText1.isFocused();

            Toast.makeText(this, "Angka pertama tidak boleh kosong !", Toast.LENGTH_LONG).show();
            return;
        }
        else if(editText2.getText().toString().isEmpty()){
            editText2.setError("Angka kedua tidak boleh kosong !");
            editText2.isFocused();

            Toast.makeText(this, "Angka kedua tidak boleh kosong !", Toast.LENGTH_LONG).show();
            return;
        }

        int num1  = Integer.parseInt(editText1.getText().toString());
        int num2  = Integer.parseInt(editText2.getText().toString());
        int total = 0;

        switch (operator){
            case "kali" :
                total = num1 * num2;
                break;
            case "bagi" :
                total = num1 / num2;
                break;
            case "tambah" :
                total = num1 + num2;
                break;
            case "kurang":
                total = num1 - num2;
                break;
        }
        hasil.setText(Integer.toString(total));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_kali:
                operasi("kali");
                break;
            case R.id.btn_bagi:
                operasi("bagi");
                break;
            case R.id.btn_tambah:
                operasi("tambah");
                break;
            case R.id.btn_kurang:
                operasi("kurang");
                break;
            case R.id.btn_reset:
                editText1.setText("");
                editText2.setText("");
                hasil.setText("0");
                break;
        }
    }
}