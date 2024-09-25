package com.projetoAquitetura;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class FormLogin extends AppCompatActivity {

    private EditText editLogin, editSenha;
    private Button btnEntrar, btnConsultaProjeto;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        // Inicializando os elementos da interface
        editLogin = findViewById(R.id.edit_login);
        editSenha = findViewById(R.id.edit_senha);
        btnEntrar = findViewById(R.id.bt_entrar);
        btnConsultaProjeto = findViewById(R.id.btnConsultaProjeto);
        progressBar = findViewById(R.id.progressbar);

        // Ação do botão de login
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                realizarLogin();
            }
        });

        btnConsultaProjeto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormLogin.this, ConsultaProjetoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void realizarLogin() {
        // Captura o texto inserido nos campos de login e senha
        String login = editLogin.getText().toString();
        String senha = editSenha.getText().toString();

        // Inicializa Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.2:8181/") // Apenas a base da URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Cria a requisição de login no formato JSON
        Map<String, String> loginData = new HashMap<>();
        loginData.put("deslogin", login);
        loginData.put("dessenha", senha);

        // Faz a requisição com Retrofit diretamente dentro da FormLogin
        Call<ResponseBody> call = retrofit.create(LoginApi.class).login(loginData);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                progressBar.setVisibility(View.INVISIBLE);
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        // Processa a resposta JSON
                        String responseBody = response.body().string();
                        JSONObject jsonObject = new JSONObject(responseBody);

                        // Verifica se o login foi bem-sucedido
                        if (jsonObject.has("idefuncionario")) {
                            Toast.makeText(FormLogin.this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(FormLogin.this, MainActivity.class); // Navega para a tela principal
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(FormLogin.this, "Falha no login: Login ou senha incorretos.", Toast.LENGTH_LONG).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(FormLogin.this, "Erro ao processar a resposta.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    // Erro no login
                    Toast.makeText(FormLogin.this, "Erro no login: " + response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                // Erro de comunicação
                Log.e("LoginError", "Erro: " + t.getMessage());
                Toast.makeText(FormLogin.this, "Erro ao tentar logar: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    // Interface API para o Retrofit
    interface LoginApi {
        @POST("api/login") // O caminho correto da API
        Call<ResponseBody> login(@Body Map<String, String> loginData);
    }
}
