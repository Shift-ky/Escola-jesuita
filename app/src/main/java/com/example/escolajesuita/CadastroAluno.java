package com.example.escolajesuita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class CadastroAluno extends AppCompatActivity {

    EditText Enome, Enota1, Enota2;
    double media;
    String nome, texto, situacao;
    double nota1, nota2;
    ArrayList<String> lista = new ArrayList<>();

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);
        getSupportActionBar().hide();

        Enome = findViewById(R.id.entradaNome);
        Enota1 = findViewById(R.id.nota1);
        Enota2 = findViewById(R.id.nota2);
    }

    public void calcularMedia(View view) {

        if (TextUtils.isEmpty(Enota1.getText().toString()) || TextUtils.isEmpty(Enota2.getText().toString()) || TextUtils.isEmpty(Enome.getText().toString())) {
            Toast.makeText(CadastroAluno.this, "Campos obrigatórios vazios, Porfavor preencha-os!", Toast.LENGTH_LONG).show();

        } else {
            nome = Enome.getText().toString();
            nota1 = Double.parseDouble(Enota1.getText().toString());
            nota2 = Double.parseDouble(Enota2.getText().toString());
            if (nota1 >= 0 && nota1 <= 10 || nota2 >= 0 && nota2 <= 10) {
                media = (nota1 + nota2) / 2;

                if (media < 7) {
                    situacao = "Reprovado";
                } else {
                    situacao = "Aprovado";

                    texto = "O Aluno: " + nome + "\nFicou com a Média: " + media + "\n Sua situação é: " + situacao;

                    Intent i = new Intent(CadastroAluno.this, MostraNota.class);
                    i.putExtra("nome", texto);
                    i.putExtra("media", media);
                    startActivity(i);

                }


            } else {
                Toast.makeText(CadastroAluno.this, "As notas tem que está em um intervalo de 0 á 10 ", Toast.LENGTH_LONG).show();
            }


        }


    }

    public void cadastraAluno(View view) {
        if (TextUtils.isEmpty(Enota1.getText().toString()) || TextUtils.isEmpty(Enota2.getText().toString()) || TextUtils.isEmpty(Enome.getText().toString())) {
            Toast.makeText(CadastroAluno.this, "Campos obrigatórios vazios, Porfavor preencha-os!", Toast.LENGTH_LONG).show();
        }else {
            if (nota1 >= 0 && nota1 <= 10 || nota2 >= 0 && nota2 <= 10) {
                nome = Enome.getText().toString();

                lista.add(nome);


            }else {
                Toast.makeText(CadastroAluno.this, "As notas tem que está em um intervalo de 0 á 10 ", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void listaAluno(View view){
        Intent i = new Intent(CadastroAluno.this, ListarAluno.class);
        i.putExtra("nome", lista);
        startActivity(i);
    }
}