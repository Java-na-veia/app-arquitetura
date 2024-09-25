package com.projetoAquitetura;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                URL url = new URL("http://192.168.1.2:8181/projetos/consulta?codigoRastreio=" + codigoProjeto);
                                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                                connection.setRequestMethod("GET");

                                int responseCode = connection.getResponseCode();
                                if (responseCode == HttpURLConnection.HTTP_OK) {
                                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                                    String inputLine;
                                    StringBuilder response = new StringBuilder();

                                    while ((inputLine = in.readLine()) != null) {
                                        response.append(inputLine);
                                    }
                                    in.close();

                                    // Parse the response (assuming it's an integer)
                                    int ideProjeto = Integer.parseInt(response.toString());

                                    // Envie o ID para a próxima tela
                                    Intent intent = new Intent(ConsultaProjetoActivity.this, TelaProjetoActivity.class);
                                    intent.putExtra("ideProjeto", ideProjeto);
                                    startActivity(intent);
                                } else {
                                    // Handle error response
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                } else {
                    editTextCodigoProjeto.setError("Por favor, insira o código do projeto.");
                }
            }
        });
    }
}
