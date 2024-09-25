package com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Repositorio;

import com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Model.Funcionario;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepo extends JpaRepository<Funcionario,Long>{

    @Procedure(procedureName = "spdelfuncionario")
    void deletar(@Param("idfuncionario") Long id,@Param("stsativo") String stsAtivo);

    @Procedure(procedureName = "spinsfuncionario")
    void cadastrarFuncionario(@Param("nomfuncionario")String nomfuncionario,@Param("desemail")String desemail,@Param("pnrotelefone")String nrotelefone,@Param("deslogin")String deslogin,@Param("dessenha")String senha);

    @Procedure(procedureName = "splistarfuncionarios")
    List<Funcionario> buscarFuncionario(@Param("stsativo") String stsativo, @Param("nomfuncionario") String nome);

    @Procedure(procedureName = "spedtfuncionario")
    void atualizarFuncionario(@Param("pidfuncionario")Long id, @Param("nomfuncionario")String nomfuncionario,@Param("desemail")String desemail,@Param("pnrotelefone")String nrotelefone,@Param("deslogin")String deslogin,@Param("dessenha")String senha);


}
