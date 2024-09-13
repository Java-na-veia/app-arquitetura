package com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API;

import com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Model.Funcionario;
import com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Repositorio.FuncionarioRepo;
import com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Servicos.FuncionariosServicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoDeGerenciamentoDeArquiteturaApiApplication implements  CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(ProjetoDeGerenciamentoDeArquiteturaApiApplication.class, args);

	}
	@Autowired
	FuncionariosServicos funcionariosServicos;
	@Override
	public void run(String... args) throws Exception {
		Funcionario obj = new Funcionario(null, "Gabriel", "Email", "0000000000", "Login", "senha123", "1");
		funcionariosServicos.cadastrarFuncionario(obj);
	}
}
