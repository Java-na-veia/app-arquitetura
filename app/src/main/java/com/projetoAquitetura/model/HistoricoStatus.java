package com.projetoAquitetura.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoricoStatus {
    private Long id;  // Novo campo adicionado
    private String etapa;
    private String funcionario;  // Novo campo adicionado
    private Date data; // Altere para Date

    public HistoricoStatus(Long id, String etapa, String funcionario, Date data) {
        this.id = id;
        this.etapa = etapa;
        this.funcionario = funcionario;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getEtapa() {
        return etapa;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public String getData() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // Formato brasileiro
        return formatter.format(data); // Retorna a data formatada
    }
}
