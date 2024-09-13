package model;

import java.io.Serializable;

public class Funcionario implements Serializable {
    private Long idefuncionario;
    private String nomfuncionario;
    private String desemail;
    private String nrotelefone;
    private String deslogin;
    private String dessenha;
    private String stscargo;

    public Funcionario() {
    }

    public Funcionario(Long idefuncionario, String nomfuncionario, String desemail, String nrotelefone, String deslogin, String dessenha, String stscargo) {
        this.idefuncionario = idefuncionario;
        this.nomfuncionario = nomfuncionario;
        this.desemail = desemail;
        this.nrotelefone = nrotelefone;
        this.deslogin = deslogin;
        this.dessenha = dessenha;
        this.stscargo = stscargo;
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
}
