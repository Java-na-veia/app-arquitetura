package com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Servicos;

import com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Model.Funcionario;
import com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Repositorio.FuncionarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FuncionariosServicos {
    @Autowired
    FuncionarioRepo funcionarioRepo ;

    public void cadastrarFuncionario(Funcionario obj){
        funcionarioRepo.save(obj);
    }
    public void deletar(Funcionario funcionario) {
     funcionarioRepo.delete(funcionario);
    }
}
