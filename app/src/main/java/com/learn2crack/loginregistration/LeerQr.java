package com.learn2crack.loginregistration;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class LeerQr extends AppCompatActivity {

    private Button btn_escanner;
    private TextView txt_lectura_qr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer_qr2);

        btn_escanner = findViewById(R.id.btn_escanner_recoleccion_segregacion);
        txt_lectura_qr = findViewById(R.id.txt_lectura_qr);
        btn_escanner.setOnClickListener(mOnClickListener);

        btn_escanner = findViewById(R.id.btn_escanner_recepcion_base);
        txt_lectura_qr = findViewById(R.id.txt_lectura_qr);
        btn_escanner.setOnClickListener(mOnClickListener);

        btn_escanner = findViewById(R.id.btn_recepcion_cr);
        txt_lectura_qr = findViewById(R.id.txt_lectura_qr);
        btn_escanner.setOnClickListener(mOnClickListener);

        btn_escanner = findViewById(R.id.btn_recoleccion_mdc);
        txt_lectura_qr = findViewById(R.id.txt_lectura_qr);
        btn_escanner.setOnClickListener(mOnClickListener);

        btn_escanner = findViewById(R.id.btn_recoleccion_valija);
        txt_lectura_qr = findViewById(R.id.txt_lectura_qr);
        btn_escanner.setOnClickListener(mOnClickListener);

        btn_escanner = findViewById(R.id.btn_recoleccion_entregado);
        txt_lectura_qr = findViewById(R.id.txt_lectura_qr);
        btn_escanner.setOnClickListener(mOnClickListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null)
            if (result.getContents() != null) {
                txt_lectura_qr.setText("El codigo qr es:\n" + result.getContents());
                separacionQr(result.getContents());
            } else {
                txt_lectura_qr.setText("Error De Lectura Volver A Leer Al Codigo QR");
            }
    }

    String codigo = "";

    //split separa las cadenas de texto y las pone en un arrgelo de strings
    public void separacionQr(String text) {
        String[] separated = text.split("\\|");
        String codigo = separated[0];
        Log.e("codigo", codigo);
        this.codigo=codigo;
        txt_lectura_qr.setText("id de venta:\n" + codigo);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_escanner_recoleccion_segregacion:
                    new IntentIntegrator(LeerQr.this).initiateScan();
                    break;
            }
            switch (v.getId()) {
                case R.id.btn_escanner_recepcion_base:
                    new IntentIntegrator(LeerQr.this).initiateScan();
                    break;
            }
            switch (v.getId()) {
                case R.id.btn_recepcion_cr:
                    new IntentIntegrator(LeerQr.this).initiateScan();
                    break;
            }
            switch (v.getId()) {
                case R.id.btn_recoleccion_mdc:
                    new IntentIntegrator(LeerQr.this).initiateScan();
                    break;
            }
            switch (v.getId()) {
                case R.id.btn_recoleccion_valija:
                    new IntentIntegrator(LeerQr.this).initiateScan();
                    break;
            }
            switch (v.getId()) {
                case R.id.btn_recoleccion_entregado:
                    new IntentIntegrator(LeerQr.this).initiateScan();
                    break;
            }
        }

    };


}


