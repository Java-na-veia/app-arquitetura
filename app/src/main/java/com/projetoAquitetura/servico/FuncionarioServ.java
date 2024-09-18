package com.projetoAquitetura.servico;

import com.projetoAquitetura.ConexaoAPI;

import java.util.ArrayList;
import java.util.List;

import com.projetoAquitetura.model.Funcionario;
import com.projetoAquitetura.repositorio.FuncionarioRepo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FuncionarioServ {
    FuncionarioRepo api;
    ArrayList<Funcionario> funcionarios = new ArrayList<>();
    ArrayList<Funcionario> objtt = new ArrayList<>();
    public void cadastrarFuncionario(Funcionario funcionario) {
        this.api = ConexaoAPI.getRetrofit().create(FuncionarioRepo.class);

        api.cadastrarFuncionario(funcionario).enqueue(new Callback<Funcionario>() {
            @Override
            public void onResponse(Call<Funcionario> call, Response<Funcionario> response) {
                if (response.isSuccessful()) {

                }
            }

            @Override
            public void onFailure(Call<Funcionario> call, Throwable throwable) {

            }
        });
    }
    public ArrayList<Funcionario> buscarFuncionario(final Runnable onCompletion) {
        this.api = ConexaoAPI.getRetrofit().create(FuncionarioRepo.class);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        api.BuscarTodosFuncionarios().enqueue(new Callback<ArrayList<Funcionario>>() {

            @Override
            public void onResponse(Call<ArrayList<Funcionario>> call, Response<ArrayList<Funcionario>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Funcionario> objs = response.body();
                    if (objs != null && !objs.isEmpty()) {
                        for (Funcionario funcionario : objs) {
                            Long id = funcionario.getIdefuncionario();
                            String nome = funcionario.getNomfuncionario();
                            String login = funcionario.getDeslogin();
                            String email = funcionario.getDesemail();
                            String senha = funcionario.getDessenha();
                            String telefone = funcionario.getNrotelefone();
                            String stsAtivo = funcionario.getSativo();
                            Funcionario obj = new Funcionario(id, nome, email, telefone, login, senha, null,stsAtivo );
                            funcionarios.add(obj);
                        }
                    }
                }
                onCompletion.run();
            }

            @Override
            public void onFailure(Call<ArrayList<Funcionario>> call, Throwable throwable) {
                onCompletion.run();
            }
        });

        return funcionarios;
    }

}
