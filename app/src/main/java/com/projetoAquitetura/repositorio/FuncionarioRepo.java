package com.projetoAquitetura.repositorio;

import java.util.ArrayList;

import com.projetoAquitetura.model.Funcionario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface FuncionarioRepo {
    @POST("funcionario")
    Call<Funcionario> cadastrarFuncionario(@Body Funcionario funcionario
    );
    @GET("funcionario")
    Call<ArrayList<Funcionario>> listaFuncionarios();
    @GET("funcionario/{x}/{nome}")
    Call<ArrayList<Funcionario>> buscarFuncionario(@Path("x") Integer x,@Path("nome") String nome
    );
    @PUT("funcionario/{id}")
    Call<Funcionario> atualizarFuncionario(@Path("id") Long id, @Body Funcionario funcionario);
    @PUT("funcionario/{id}")
    Call<Funcionario> desativa(@Path("id") Long id, @Body String stsAtivo);
}
