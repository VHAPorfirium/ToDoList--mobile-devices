package com.example.todolist;

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

import com.example.todolist.persistencia.TaskDatabaseHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextText2;
    private ListView listaDeTarefa;
    private ArrayList<String> tarefas;
    private ArrayAdapter<String> adapter;
    private TaskDatabaseHelper dbHelper;  // Instância do helper do banco

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ajusta o padding para os insets da tela
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextText2 = findViewById(R.id.editTextText2);
        listaDeTarefa = findViewById(R.id.listaDeTarefa);
        Button botaoAdicionar = findViewById(R.id.buttonAdicionar);

        // Instancia o helper do banco e carrega as tarefas salvas
        dbHelper = new TaskDatabaseHelper(this);
        tarefas = dbHelper.getAllTasks();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tarefas);
        listaDeTarefa.setAdapter(adapter);

        botaoAdicionar.setOnClickListener(view -> adicionarNaListaDeTarefa());

        listaDeTarefa.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                removerItem(position);
                return true;
            }
        });
    }

    // Método para adicionar uma tarefa tanto na lista quanto no banco de dados
    private void adicionarNaListaDeTarefa() {
        String tarefa = editTextText2.getText().toString().trim();

        if (!tarefa.isEmpty()) {
            // Salva no banco de dados
            boolean inseriu = dbHelper.addTask(tarefa);
            if (inseriu) {
                // Se inseriu com sucesso, atualiza a lista e o adapter
                tarefas.add(tarefa);
                adapter.notifyDataSetChanged();
                editTextText2.setText("");
            } else {
                // Trate o erro conforme necessário (ex.: mostrar um Toast)
            }
        }
    }

    // Método para remover a tarefa da lista e do banco de dados
    private void removerItem(int position) {
        String tarefa = tarefas.get(position);
        tarefas.remove(position);
        adapter.notifyDataSetChanged();
        dbHelper.deleteTask(tarefa);
    }
}