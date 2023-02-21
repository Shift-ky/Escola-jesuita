package com.example.escolajesuita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MostraNota extends AppCompatActivity {

    TextView saida;
    Intent i;
    ImageView image;
    double media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_nota);

        image = findViewById(R.id.saidaImage);
        i = getIntent();
        saida = findViewById(R.id.saidaTexto);
        String texto = String.valueOf(i.getSerializableExtra("nome"));
        media = Double.parseDouble(String.valueOf(i.getSerializableExtra("media")));
        saida.setText(texto);

        if(media < 7){
            image.setImageResource(R.drawable.rejeitado);
        }else{
            image.setImageResource(R.drawable.aprovado);
        }
    }
}