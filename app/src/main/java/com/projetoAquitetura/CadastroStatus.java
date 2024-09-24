package com.projetoAquitetura;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@SuppressWarnings("deprecation")
public class CadastroStatus extends AppCompatActivity {

    private EditText editStatus;
    private Button btnCadastrarStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_status);

        editStatus = findViewById(R.id.edit_senha);
        btnCadastrarStatus = findViewById(R.id.btncadastrastatus);

        btnCadastrarStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status = editStatus.getText().toString();
                if (!status.isEmpty()) {
                    new EnviarStatusTask().execute(status);
                } else {
                    Toast.makeText(CadastroStatus.this, "Por favor, insira um status", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // AsyncTask para enviar o status para o servidor
    private class EnviarStatusTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String status = params[0];
            Log.d("CadastroStatus", "Valor do status: " + status);

            String urlString = "http://192.168.1.2:8080/status"; // URL do backend

            try {
                // Criar a conexão HTTP
                URL url = new URL(urlString);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", "application/json; utf-8");
                urlConnection.setRequestProperty("Accept", "application/json");
                urlConnection.setDoOutput(true);

                // Criar JSON com o status, usando o campo esperado pela API
                JSONObject jsonStatus = new JSONObject();
                jsonStatus.put("nomstatus", status);

                // Enviar o JSON na requisição
                try (OutputStream os = urlConnection.getOutputStream()) {
                    byte[] input = jsonStatus.toString().getBytes("utf-8");
                    os.write(input, 0, input.length);
                }

                // Verificar a resposta do servidor
                int code = urlConnection.getResponseCode();

                // Ler a resposta do servidor
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                if (code == HttpURLConnection.HTTP_CREATED) {
                    return "Status cadastrado com sucesso! " + response.toString();
                } else {
                    return "Erro ao cadastrar status: Código " + code + " - " + response.toString();
                }

            } catch (Exception e) {
                e.printStackTrace();
                return "Erro ao se conectar ao servidor: " + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            // Exibir o resultado da operação (sucesso ou erro)
            Toast.makeText(CadastroStatus.this, result, Toast.LENGTH_SHORT).show();
        }
    }
}
