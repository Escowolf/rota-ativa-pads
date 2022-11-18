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
import com.rotativa.usersapi.service.PagamentoService;
// possui as operações operações básicas para manipular o usuário no bd
@CrossOrigin(origins = "http://localhost:3000") //Permite que o back envie e receba dados de uma origem diferente
@RestController
@RequestMapping("/pagamento")
public class PagamentoREST {
    @Autowired //o spring cria o objeto, injeta no atributo repositório
	PagamentoService pagamentoService;

    @GetMapping
    public List<Pagamento> listar(){
        return pagamentoService.listar();
    }

    @PostMapping
    public void salvar(@RequestBody Pagamento pagamento){
        pagamentoService.salvar(pagamento);
    }

    @PutMapping
    public void alterar(@RequestBody Pagamento pagamento){
        pagamentoService.alterar(pagamento);
    }

    @DeleteMapping
    public void excluir(@RequestBody Pagamento pagamento){
        pagamentoService.excluir(pagamento);
    }

}