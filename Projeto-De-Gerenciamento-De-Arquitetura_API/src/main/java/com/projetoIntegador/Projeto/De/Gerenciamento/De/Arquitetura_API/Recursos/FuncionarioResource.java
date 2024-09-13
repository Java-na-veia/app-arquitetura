package com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Recursos;

import com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Model.Funcionario;
import com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Servicos.FuncionariosServicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioResource {

    @Autowired
    public FuncionariosServicos funcionariosServico;
    Funcionario obj = new Funcionario();

    @GetMapping
    public ResponseEntity<Funcionario> listaDeFuncionarios() {
        Funcionario funcionario2 = new Funcionario(null, "Gabriel", "Email", "0000000000", "Login", "senha123", "1");
        return ResponseEntity.ok().body(funcionario2);
    }
    @PostMapping
    public void cadastrarFuncionario(@RequestBody Funcionario funcionario){
        System.out.println(funcionario.toString());
        this.funcionariosServico.cadastrarFuncionario(funcionario);
    }
    /*@DeleteMapping()
    public void ResponseEntity<Funcionario> deletar (@RequestBody ){
        funcionariosServico.deletar();
    }
    @PutMapping
    public ResponseEntity<Funcionario> atualizarFuncionario(Funcionario funcionario){
    this.funcionario.update(funcionario)
    }






    */



}
