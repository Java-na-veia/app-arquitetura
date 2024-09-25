package com.projetoAquitetura;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.projetoAquitetura.model.Funcionario;
import com.projetoAquitetura.servico.FuncionarioServ;

public class CadastrarFuncionario extends AppCompatActivity {
    private TextView id;
    private EditText nome;
    private EditText email;
    private EditText telefone;
    private EditText login;
    private EditText senha;
    private EditText funcao;
    private Button btnCadastrar,btnDesativar;

    FuncionarioServ funcionarioServ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.cadastrar_funcionario);
        inicializarLayout();

        funcionarioServ = new FuncionarioServ();
        Funcionario funcionario = (Funcionario) getIntent().getSerializableExtra("funcionario");
        if (funcionario != null) {
            preencherDadosFuncionario(funcionario);
            if (funcionario.getSativo().equals("1")){
                btnCadastrar.setText("Atualizar");
                desativarCampo(true);
                btnCadastrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (funcionario != null) {
                            atualizarFuncionario(funcionario);
                        } else {
                            cadastrarFuncionario();
                        }
                    }
                });
            } else if (funcionario.getSativo().equals("0")) {
                desativarCampo(true);
                btnCadastrar.setEnabled(false);
                btnDesativar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(funcionario.getSativo().equals("0")) {
                            btnDesativar.setText("Ativar funcionario");
                            desativarCampo(true);
                            funcionarioServ.stsFuncionario(funcionario, "1");
                            btnCadastrar.setEnabled(false);
                        } else if (funcionario.getSativo().equals("0")) {
                            btnDesativar.setText("Desativar funcionario");
                            desativarCampo(true);
                            funcionarioServ.stsFuncionario(funcionario,"0");
                            btnCadastrar.setEnabled(false);
                        }
                    }
                });
            }

        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void inicializarLayout(){
        id = findViewById(R.id.txtIdFuncionario);
        nome = findViewById(R.id.edtxtNome);
        email = findViewById(R.id.edtxtEmail);
        telefone = findViewById(R.id.edtxtTelefone);
        login = findViewById(R.id.edtxtLogin);
        senha = findViewById(R.id.edtxtSenha);
        funcao = findViewById(R.id.edtxtFuncao);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnDesativar = findViewById(R.id.btnStsAtivo);
    }

    private void preencherDadosFuncionario(Funcionario funcionario) {
        id.setText("ID: " + funcionario.getIdefuncionario());  // Exibe o ID, mas não permite edição
        id.setVisibility(View.VISIBLE);  // Torna o ID visível
        nome.setText(funcionario.getNomfuncionario());
        email.setText(funcionario.getDesemail());
        telefone.setText(funcionario.getNrotelefone());
        login.setText(funcionario.getDeslogin());

    }

    private void limparCampos() {
        nome.setText("");
        email.setText("");
        telefone.setText("");
        login.setText("");
        senha.setText("");
        funcao.setText("");
    }

    private void cadastrarFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNomfuncionario(nome.getText().toString());
        funcionario.setDesemail(email.getText().toString());
        funcionario.setDeslogin(login.getText().toString());
        funcionario.setNrotelefone(telefone.getText().toString());
        funcionario.setDessenha(senha.getText().toString());
        funcionario.setStscargo(funcao.getText().toString());
        funcionario.setStsativo("1");
        funcionarioServ.cadastrarFuncionario(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
        limparCampos();
    }

    private void atualizarFuncionario(Funcionario funcionario) {
        funcionario.setNomfuncionario(nome.getText().toString());
        funcionario.setDesemail(email.getText().toString());
        funcionario.setDeslogin(login.getText().toString());
        funcionario.setNrotelefone(telefone.getText().toString());
        funcionario.setDessenha(senha.getText().toString());
        funcionarioServ.atualizarFuncionario(funcionario);

    }
    public void desativarCampo(Boolean resp){
        if(resp == true){
        nome.setEnabled(false);
        login.setEnabled(false);
        email.setEnabled(false);
        telefone.setEnabled(false);
        senha.setEnabled(false);
        }else {
            nome.setEnabled(true);
            login.setEnabled(true);
            email.setEnabled(true);
            telefone.setEnabled(true);
            senha.setEnabled(true);
        }
    }

}
