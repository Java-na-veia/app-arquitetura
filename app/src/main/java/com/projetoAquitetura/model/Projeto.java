package com.projetoAquitetura.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Projeto {
    private Long ideprojeto;  // ID do projeto
    private String nomcliente; // Nome do cliente
    private String destipo;    // Tipo de projeto
    private String desitens;   // Descrição dos itens
    private Long idestatus;     // ID do status
    private String stsativo;    // Status ativo (1 ou 0)
    private String dtcinicio;  // Data de início como String
    private String codrastreio; // Código de rastreio

    // Construtor
    public Projeto(Long ideprojeto, String nomcliente, String destipo, String desitens,
                   Long idestatus, String stsativo, String dtcinicio, String codrastreio) {
        this.ideprojeto = ideprojeto;
        this.nomcliente = nomcliente;
        this.destipo = destipo;
        this.desitens = desitens;
        this.idestatus = idestatus;
        this.stsativo = stsativo;
        this.dtcinicio = dtcinicio;
        this.codrastreio = codrastreio;
    }

    // Getters e Setters
    public Long getIdeprojeto() {
        return ideprojeto;
    }

    public void setIdeprojeto(Long ideprojeto) {
        this.ideprojeto = ideprojeto;
    }

    public String getNomcliente() {
        return nomcliente;
    }

    public void setNomcliente(String nomcliente) {
        this.nomcliente = nomcliente;
    }

    public String getDestipo() {
        return destipo;
    }

    public void setDestipo(String destipo) {
        this.destipo = destipo;
    }

    public String getDesitens() {
        return desitens;
    }

    public void setDesitens(String desitens) {
        this.desitens = desitens;
    }

    public Long getIdestatus() {
        return idestatus;
    }

    public void setIdestatus(Long idestatus) {
        this.idestatus = idestatus;
    }

    public String getStsativo() {
        return stsativo;
    }

    public void setStsativo(String stsativo) {
        this.stsativo = stsativo;
    }

    public String getDtcinicio() {
        return dtcinicio; // Retorna a data como String
    }

    public void setDtcinicio(String dtcinicio) {
        this.dtcinicio = dtcinicio;
    }

    public String getCodrastreio() {
        return codrastreio;
    }

    public void setCodrastreio(String codrastreio) {
        this.codrastreio = codrastreio;
    }

    // Método para obter a data de início formatada
    public String getDtcinicioFormatada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Formato desejado
        try {
            // Supondo que dtcinicio esteja no formato "yyyy-MM-dd" ou outro formato conhecido
            Date data = new SimpleDateFormat("yyyy-MM-dd").parse(dtcinicio); // Ajuste o formato conforme necessário
            return sdf.format(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return dtcinicio; // Retorna a data original em caso de erro
        }
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "ideprojeto=" + ideprojeto +
                ", nomcliente='" + nomcliente + '\'' +
                ", destipo='" + destipo + '\'' +
                ", desitens='" + desitens + '\'' +
                ", idestatus=" + idestatus +
                ", stsativo='" + stsativo + '\'' +
                ", dtcinicio='" + dtcinicio + '\'' + // Alterado para String
                ", codrastreio='" + codrastreio + '\'' +
                '}';
    }
}
