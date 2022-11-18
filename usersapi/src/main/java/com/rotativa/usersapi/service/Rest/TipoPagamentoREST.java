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
import com.rotativa.usersapi.service.TipoPagamentoService;
// possui as operações operações básicas para manipular o usuário no bd
@CrossOrigin(origins = "http://localhost:3000") //Permite que o back envie e receba dados de uma origem diferente
@RestController
@RequestMapping("/tipopagamento")
public class TipoPagamentoREST {
    @Autowired //o spring cria o objeto, injeta no atributo repositório
	TipoPagamentoService tipoPagamentoService;

    @GetMapping
    public List<TipoPagamento> listar(){
        return tipoPagamentoService.listar();
    }

    @PostMapping
    public void salvar(@RequestBody TipoPagamento usuario){
        tipoPagamentoService.salvar(usuario);
    }

    @PutMapping
    public void alterar(@RequestBody TipoPagamento usuario){
        tipoPagamentoService.alterar(usuario);
    }

    @DeleteMapping
    public void excluir(@RequestBody TipoPagamento usuario){
        tipoPagamentoService.excluir(usuario);
    }

}