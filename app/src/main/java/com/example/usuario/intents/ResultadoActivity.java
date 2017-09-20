package com.example.usuario.intents;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class ResultadoActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_resultado);

        TextView textView=(TextView)findViewById(R.id.saludo);

        Button button=(Button)findViewById(R.id.destino);
        button.setOnClickListener(this);

        Intent intent=getIntent();

        if(intent!=null){
            if(intent.hasExtra("saludo")){
                String str=intent.getStringExtra("saludo");
                textView.setText(str);
            }
        }
    }
    @Override
    public void onClick(View v) {

       Intent intent=new Intent();


        intent.putExtra("respuesta","he respondido");
        this.setResult(RESULT_OK,intent);
        this.finish();
    }
}
