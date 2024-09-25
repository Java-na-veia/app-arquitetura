package com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Servicos;

import com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Model.Funcionario;
import com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Repositorio.FuncionarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class FuncionariosServicos {
    @Autowired
    FuncionarioRepo funcionarioRepo ;

    public List<Funcionario> listaDeFuncionarios(){
        return funcionarioRepo.findAll();
}
    @Transactional
    public void cadastrarFuncionario(Funcionario obj){
        funcionarioRepo.cadastrarFuncionario(
                obj.getNomfuncionario(),
                obj.getDesemail(),
                obj.getNrotelefone(),
                obj.getDeslogin(),
                obj.getDessenha());
    }

    public void deletarFuncionario(Long id,String x) {
        funcionarioRepo.deletar(id,x);
    }
    @Transactional
    public List<Funcionario> buscarFuncionario(String x, String nome){
     return  funcionarioRepo.buscarFuncionario(x,nome);
}
    @Transactional
    public Funcionario atualizarFuncionario(Long id, Funcionario obj) {
        Funcionario funcionarioExistente = funcionarioRepo.getOne(id);

        funcionarioRepo.atualizarFuncionario(
                obj.getIdefuncionario(),
                obj.getNomfuncionario(),
                obj.getDesemail(),
                obj.getNrotelefone(),
                obj.getDeslogin(),
                obj.getDessenha()
        );

        return funcionarioExistente;
    }
    }

