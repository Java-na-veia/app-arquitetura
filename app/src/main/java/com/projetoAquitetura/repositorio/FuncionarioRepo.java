package com.projetoAquitetura.repositorio;

import java.util.ArrayList;

import com.projetoAquitetura.model.Funcionario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FuncionarioRepo {
    @POST("funcionario")
    Call<Funcionario> cadastrarFuncionario(@Body Funcionario funcionario);
    @GET("funcionario")
    Call<ArrayList<Funcionario>> BuscarTodosFuncionarios();

}
