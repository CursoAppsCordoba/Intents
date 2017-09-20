package com.example.usuario.intents;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final int OK_RESPUESTA=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.inicio);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent=new Intent(this,ResultadoActivity.class);
        intent.putExtra("saludo","hola mundo");
        //startActivity(intent);
        startActivityForResult(intent,0);

    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("estoy parada");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("he muerto");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


            if (resultCode == OK_RESPUESTA) {

                EditText respuesta = (EditText) findViewById(R.id.resultado);
                if (data.hasExtra("respuesta")) {
                    respuesta.setText(data.getStringExtra("respuesta"));
                }

            }




    }
}
