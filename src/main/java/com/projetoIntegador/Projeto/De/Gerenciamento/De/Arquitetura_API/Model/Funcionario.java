package com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "funcionario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idefuncionario;
    private String nomfuncionario;
    private String desemail;
    private String nrotelefone;
    private String deslogin;
    private String dessenha;
    private String stscargo;
    private String stsativo;

    public Funcionario() {

    }

    public Funcionario(Long idefuncionario, String nomfuncionario, String desemail, String nrotelefone, String deslogin, String dessenha, String stscargo, String stsativo) {
        this.idefuncionario = idefuncionario;
        this.nomfuncionario = nomfuncionario;
        this.desemail = desemail;
        this.nrotelefone = nrotelefone;
        this.deslogin = deslogin;
        this.dessenha = dessenha;
        this.stscargo = stscargo;
        this.stsativo = stsativo;
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

    public String getStsativo() {
        return stsativo;
    }

    public void setStsativo(String stsativo) {
        this.stsativo = stsativo;
    }
}
