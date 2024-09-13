package com.projetoAquitetura;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import model.Funcionario;

public class MainActivity extends AppCompatActivity {
    private TextView id;
    private EditText nome;
    private EditText email;
    private EditText telefone;
    private EditText login;
    private EditText senha;
    private EditText funcao;
    private Button btnCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        inicializarLayout();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void inicializarLayout(){
        nome = findViewById(R.id.edtxtNome);
        email = findViewById(R.id.edtxtEmail);
        telefone = findViewById(R.id.edtxtTelefone);
        login = findViewById(R.id.edtxtLogin);
        senha = findViewById(R.id.edtxtSenha);
        funcao = findViewById(R.id.edtxtFuncao);
        btnCadastrar = findViewById(R.id.btnCadastrar);
    }
    private void limparCampos() {
        nome.setText("");
       email.setText("");
        telefone.setText("");
       login.setText("");
        senha.setText("");
        funcao.setText("");
    }
    private void cadastrarFuncionario(Funcionario funcionario){

    }
}