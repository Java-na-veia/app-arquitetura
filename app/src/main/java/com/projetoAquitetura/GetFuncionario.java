package com.projetoAquitetura;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import com.projetoAquitetura.adapter.PostsAdapter;
import com.projetoAquitetura.databinding.ActivityGetFuncionarioBinding;
import com.projetoAquitetura.model.Funcionario;
import com.projetoAquitetura.servico.FuncionarioServ;

public class GetFuncionario extends AppCompatActivity {
    private FuncionarioServ funcionarioServ = new FuncionarioServ();

    private ActivityGetFuncionarioBinding getFuncionarioBinding;
    private PostsAdapter postsAdapter;
    private  ArrayList<Funcionario> listaFuncionario ;
    private ArrayList<Funcionario> objetos = new ArrayList<>();
    private EditText editTextBuscarFuncionario;
    private Button btnBuscarFuncionario;
    private RadioButton radioButtonAtivo,radioButtonDesativado;

    private CardView cViewpostFuncionario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFuncionarioBinding = ActivityGetFuncionarioBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(getFuncionarioBinding.getRoot());
        editTextBuscarFuncionario = findViewById(R.id.edtBuscarFuncionario);
        btnBuscarFuncionario = findViewById(R.id.btnBuscarFuncionario);
        radioButtonAtivo = findViewById(R.id.radioButtonAtivo);
        radioButtonDesativado = findViewById(R.id.radioButtonDesativo);
        cViewpostFuncionario = findViewById(R.id.cViewPostFuncionario);
        radioButtonAtivo.setChecked(true);
        listaFuncionario = new ArrayList<>();
    btnBuscarFuncionario.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buscarFuncionarios();
        }
    });
        }
    ArrayList<Funcionario> funcionarios = funcionarioServ.listaFuncionario(new Runnable() {
        @Override
        public void run() {
            if (!funcionarios.isEmpty()) {
                RecyclerView recyclerViewPosts = getFuncionarioBinding.recycleViewsFuncionarios;
                if (recyclerViewPosts != null) {
                    postsAdapter = new PostsAdapter(listaFuncionario, GetFuncionario.this);
                    recyclerViewPosts.setAdapter(postsAdapter);
                    recyclerViewPosts.setLayoutManager(new LinearLayoutManager(GetFuncionario.this));
                    recyclerViewPosts.setHasFixedSize(true);
                    listaFuncionario.addAll(funcionarios);
                }
                postsAdapter = new PostsAdapter(listaFuncionario, GetFuncionario.this);
                recyclerViewPosts.setAdapter(postsAdapter);
            }
        }
    });


private void buscarFuncionarios() {
    Integer stsAtivo;
    if (radioButtonAtivo.isChecked()) {
        stsAtivo = 1; // Ativo
    } else {
        stsAtivo = 0; // Desativado
    }

    String parametro = editTextBuscarFuncionario.getText().toString();

    funcionarioServ.buscarFuncionario(stsAtivo, parametro, new FuncionarioServ.OnFuncionariosFetchedListener() {
        @Override
        public void onSuccess(ArrayList<Funcionario> funcionarios) {

            if (funcionarios != null && !funcionarios.isEmpty()) {
                listaFuncionario.clear();
                System.out.println(funcionarios.size());
                for (Funcionario x : funcionarios) {
                    Funcionario obj = x;
                    listaFuncionario.add(obj);
                }
                postsAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onError(Throwable throwable) {

            Toast.makeText(GetFuncionario.this, "Erro ao buscar funcionários: " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
        }
    });
}


}
