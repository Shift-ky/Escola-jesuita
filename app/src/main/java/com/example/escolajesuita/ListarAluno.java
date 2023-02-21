package com.example.escolajesuita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarAluno extends AppCompatActivity {
    Intent i;
    ListView lista;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_aluno);
        lista = findViewById(R.id.listaAluno);
        i = getIntent();
        ArrayList<String> name = (ArrayList<String>) i.getSerializableExtra("nome");

        adapter = new ArrayAdapter<>(ListarAluno.this, android.R.layout.simple_list_item_1,name);

        lista.setAdapter(adapter);
    }
}