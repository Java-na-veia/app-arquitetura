package com.projetoAquitetura;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConexaoAPI {
    public static Retrofit getRetrofit  () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.0.87:8080/")
                .addConverterFactory(GsonConverterFactory.create()).build();
    return retrofit;
    }


}