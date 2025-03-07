package com.example.todolist;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextText2;
    private ListView listaDeTarefa;
    private ArrayList<String> tarefas;
    private ArrayAdapter<String> adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextText2 = findViewById(R.id.editTextText2);
        listaDeTarefa = findViewById(R.id.listaDeTarefa);
        Button botaoAdicionar = findViewById(R.id.buttonAdicionar);

        tarefas = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tarefas);
        listaDeTarefa.setAdapter(adapter);

        botaoAdicionar.setOnClickListener(view -> adicionarNaListaDeTarefa());

    }

    //Adicionar item na lista de tarefa
    private void adicionarNaListaDeTarefa(){
        String tarefa = editTextText2.getText().toString().trim();

        if (!tarefa.isEmpty()) {
            tarefas.add(tarefa);
            adapter.notifyDataSetChanged();
            editTextText2.setText("");
        }
    }

}