package com.projetoAquitetura.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Funcionario implements Serializable {
    @SerializedName("idefuncionario")
    private Long idefuncionario;
    @SerializedName("nomfuncionario")
    private String nomfuncionario;
    @SerializedName("desemail")
    private String desemail;
    @SerializedName("nrotelefone")
    private String nrotelefone;
    @SerializedName("deslogin")
    private String deslogin;
    @SerializedName("dessenha")
    private String dessenha;
    @SerializedName("stscargo")
    private String stscargo;
    @SerializedName("stsativo")
    private String stsativo;
    public Funcionario() {
    }

    public Funcionario(Long idefuncionario, String nomfuncionario, String desemail, String nrotelefone, String deslogin, String dessenha, String stscargo,String stsativo) {
        this.idefuncionario = idefuncionario;
        this.nomfuncionario = nomfuncionario;
        this.desemail = desemail;
        this.nrotelefone = nrotelefone;
        this.deslogin = deslogin;
        this.dessenha = dessenha;
        this.stscargo = stscargo;
        this.stsativo = stsativo;
    }
    public Funcionario(Long idefuncionario, String nomfuncionario, String desemail, String nrotelefone, String deslogin) {
        this.idefuncionario = idefuncionario;
        this.nomfuncionario = nomfuncionario;
        this.desemail = desemail;
        this.nrotelefone = nrotelefone;
        this.deslogin = deslogin;
    }

    public Long getIdefuncionario() {
        return idefuncionario;
    }

    public void setIdefuncionario(Long idefuncionario) {
        this.idefuncionario = idefuncionario;
    }

    public String getNomfuncionario() {
        return nomfuncionario;
    }
    public String getSativo() {
        return stsativo;
    }
    public void setStsativo(String stsativo) {
        this.stsativo = stsativo;
    }
    public void setNomfuncionario(String nomfuncionario) {
        this.nomfuncionario = nomfuncionario;
    }

    public String getDesemail() {
        return desemail;
    }

    public void setDesemail(String desemail) {
        this.desemail = desemail;
    }

    public String getNrotelefone() {
        return nrotelefone;
    }

    public void setNrotelefone(String nrotelefone) {
        this.nrotelefone = nrotelefone;
    }

    public String getDeslogin() {
        return deslogin;
    }

    public void setDeslogin(String deslogin) {
        this.deslogin = deslogin;
    }

    public String getDessenha() {
        return dessenha;
    }

    public void setDessenha(String dessenha) {
        this.dessenha = dessenha;
    }

    public String getStscargo() {
        return stscargo;
    }

    public void setStscargo(String stscargo) {
        this.stscargo = stscargo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "idefuncionario=" + idefuncionario +
                ", nomfuncionario='" + nomfuncionario + '\'' +
                ", desemail='" + desemail + '\'' +
                ", nrotelefone='" + nrotelefone + '\'' +
                ", deslogin='" + deslogin + '\'' +
                ", dessenha='" + dessenha + '\'' +
                ", stscargo='" + stscargo + '\'' +
                ", stsativo='" + stsativo + '\'' +
                '}';
    }
}
