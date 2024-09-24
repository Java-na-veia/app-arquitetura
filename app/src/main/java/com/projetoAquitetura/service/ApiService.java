package com.projetoAquitetura.service;

import com.projetoAquitetura.model.Projeto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

// Interface para a API
public interface ApiService {
    @GET("projeto/{id}")
    Call<Projeto> getProjeto(@Path("id") long projetoId);
}
