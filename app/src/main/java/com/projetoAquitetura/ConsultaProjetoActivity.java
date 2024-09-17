package com.projetoAquitetura;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ConsultaProjetoActivity extends AppCompatActivity {

    private EditText editTextCodigoProjeto;
    private Button buttonConsultar;
    private Toolbar toolbar;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta_projeto);

        // Vinculando os elementos da Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);  // Configura a Toolbar como a ActionBar da atividade

        // Configurando o botão de voltar na Toolbar
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finaliza a atividade e volta para a tela anterior
                finish();
            }
        });

        // Vinculando os elementos do layout (input e botão)
        editTextCodigoProjeto = findViewById(R.id.editTextCodigoProjeto);
        buttonConsultar = findViewById(R.id.buttonConsultar);

        // Configurando o clique do botão "Consultar"
        buttonConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigoProjeto = editTextCodigoProjeto.getText().toString().trim();

                if (!codigoProjeto.isEmpty()) {
                    // Lógica para consultar o código do projeto (caso seja necessário)
                    // Aqui você pode inserir a lógica da consulta ou mostrar uma mensagem de confirmação
                } else {
                    // Exibe uma mensagem de erro caso o campo esteja vazio
                    editTextCodigoProjeto.setError("Por favor, insira o código do projeto.");
                }
            }
        });
    }
}
