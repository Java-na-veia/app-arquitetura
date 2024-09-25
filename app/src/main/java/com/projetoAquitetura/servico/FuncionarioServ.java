package com.projetoAquitetura.servico;

import com.projetoAquitetura.ConexaoAPI;

import java.util.ArrayList;

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
    public ArrayList<Funcionario> listaFuncionario(final Runnable onCompletion) {
        this.api = ConexaoAPI.getRetrofit().create(FuncionarioRepo.class);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        api.listaFuncionarios().enqueue(new Callback<ArrayList<Funcionario>>() {

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


    public void buscarFuncionario(Integer stsAtivo, String parametro, final OnFuncionariosFetchedListener listener) {
        this.api = ConexaoAPI.getRetrofit().create(FuncionarioRepo.class);

        api.buscarFuncionario(stsAtivo, parametro).enqueue(new Callback<ArrayList<Funcionario>>() {
            @Override
            public void onResponse(Call<ArrayList<Funcionario>> call, Response<ArrayList<Funcionario>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Funcionario> funcionarios = new ArrayList<>();
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
                            Funcionario obj = new Funcionario(id, nome, email, telefone, login, senha, null, stsAtivo);
                            funcionarios.add(obj);
                        }
                    }
                    listener.onSuccess(funcionarios);
                } else {
                    listener.onError(new Exception("Erro ao buscar funcionários."));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Funcionario>> call, Throwable throwable) {
                listener.onError(throwable);
            }
        });
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        if (funcionario == null || funcionario.getIdefuncionario() == null) {
            System.err.println("Funcionário ou ID do funcionário não pode ser nulo.");
            return;
        }

        this.api = ConexaoAPI.getRetrofit().create(FuncionarioRepo.class);
        api.atualizarFuncionario(funcionario.getIdefuncionario(), funcionario).enqueue(new Callback<Funcionario>() {
            @Override
            public void onResponse(Call<Funcionario> call, Response<Funcionario> response) {
                if (response.isSuccessful()) {

                    System.out.println("Funcionário atualizado com sucesso: " + response.body());
                } else {
                    System.err.println("Erro ao atualizar funcionário: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Funcionario> call, Throwable throwable) {
                System.err.println("Falha na atualização do funcionário: " + throwable.getMessage());
            }
        });
    }

    public void stsFuncionario(Funcionario funcionario, String stsAtivo) {
        if (funcionario == null || funcionario.getIdefuncionario() == null) {
            System.err.println("Funcionário ou ID do funcionário não pode ser nulo.");
            return;
        }

        this.api = ConexaoAPI.getRetrofit().create(FuncionarioRepo.class);
        api.desativa(funcionario.getIdefuncionario(), stsAtivo).enqueue(new Callback<Funcionario>() {
            @Override
            public void onResponse(Call<Funcionario> call, Response<Funcionario> response) {
                if (response.isSuccessful()) {

                    System.out.println("Ação concluida sucesso: " + response.body());
                } else {
                    System.err.println("Erro ao concluir ação: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Funcionario> call, Throwable throwable) {
                System.err.println("ERRO: " + throwable.getMessage());
            }
        });
    }

    public interface OnFuncionariosFetchedListener {
        void onSuccess(ArrayList<Funcionario> funcionarios);
        void onError(Throwable throwable);
    }



}
