package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaBoasVindasActivity extends AppCompatActivity {

    Thread thread;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_boas_vindas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        handler = new Handler();
        thread = new Thread(this::run);
        thread.start();
    }

    public void run() {
        try {
            // Pausa de 2 segundos
            Thread.sleep(2000);

            // Após o tempo inicia a MainActivity
            Intent intent = new Intent(TelaBoasVindasActivity.this, MainActivity.class);
            startActivity(intent);
            finish();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}