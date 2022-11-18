package com.rotativa.usersapi.service.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rotativa.usersapi.entidades.*;
import com.rotativa.usersapi.service.TelefoneService;
// possui as operações operações básicas para manipular o usuário no bd
@CrossOrigin(origins = "http://localhost:3000") //Permite que o back envie e receba dados de uma origem diferente
@RestController
@RequestMapping("/telefone")
public class TelefoneREST {
    @Autowired //o spring cria o objeto, injeta no atributo repositório
	TelefoneService telefoneService;

    @GetMapping
    public List<Telefone> listar(){
        return telefoneService.listar();
    }

    @PostMapping
    public void salvar(@RequestBody Telefone telefone){
        telefoneService.salvar(telefone);
    }

    @PutMapping
    public void alterar(@RequestBody Telefone telefone){
        telefoneService.alterar(telefone);
    }

    @DeleteMapping
    public void excluir(@RequestBody Telefone telefone){
        telefoneService.excluir(telefone);
    }

}