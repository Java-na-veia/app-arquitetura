package com.projetoAquitetura;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFuncionarioBinding = ActivityGetFuncionarioBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(getFuncionarioBinding.getRoot());
        listaFuncionario = new ArrayList<>();

        }
    ArrayList<Funcionario> funcionarios = funcionarioServ.buscarFuncionario(new Runnable() {
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
    }
