package com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Repositorio;

import com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepo extends JpaRepository<Funcionario,Long>{

}
