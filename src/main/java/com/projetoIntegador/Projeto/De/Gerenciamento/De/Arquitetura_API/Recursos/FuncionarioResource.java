package com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Recursos;

import com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Model.Funcionario;
import com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Repositorio.FuncionarioRepo;
import com.projetoIntegador.Projeto.De.Gerenciamento.De.Arquitetura_API.Servicos.FuncionariosServicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static javax.swing.UIManager.get;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioResource {

    @Autowired
    public FuncionariosServicos funcionariosServico;


    @GetMapping
    public ResponseEntity<List<Funcionario>> listaDeFuncionarios() {
    List<Funcionario> funcionarioList = funcionariosServico.listaDeFuncionarios();
        return ResponseEntity.ok().body(funcionarioList);

    }
    @GetMapping("/{x}/{nome}")
    public ResponseEntity<List<Funcionario>> buscarFuncionario(@PathVariable String x,@PathVariable String nome) {
        List<Funcionario> funcionarioList = funcionariosServico.buscarFuncionario(x, nome);
        return ResponseEntity.ok().body(funcionarioList);
    }

    @PostMapping
    public void cadastrarFuncionario(@RequestBody Funcionario funcionario){
        System.out.println(funcionario.toString());
        this.funcionariosServico.cadastrarFuncionario(funcionario);
    }

    @PutMapping("/{id}/{x}")
    public void deletarFuncionario(@PathVariable Long id,@PathVariable String x) {
        funcionariosServico.deletarFuncionario(id,x);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario obj) {
        Funcionario funcionarioAtualizado = funcionariosServico.atualizarFuncionario(id, obj);
        return ResponseEntity.ok(funcionarioAtualizado);
    }
}
