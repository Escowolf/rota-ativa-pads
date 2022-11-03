package com.rotativa.usersapi.service.Rest;

import java.sql.Date;
import java.sql.Time;
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
import com.rotativa.usersapi.service.UserService;
import com.rotativa.usersapi.service.VagaService;
// possui as operações operações básicas para manipular o usuário no bd
@CrossOrigin(origins = "http://localhost:3000") //Permite que o back envie e receba dados de uma origem diferente
@RestController
@RequestMapping("/vaga")
public class VagaREST {
    @Autowired //o spring cria o objeto, injeta no atributo repositório
	VagaService vagaService;;

    @GetMapping
    public List<Vagas> listar(){
        return vagaService.listar();
    }

    @PostMapping
    public void salvar(@RequestBody Vagas usuario){
        vagaService.salvar(usuario);
    }

    @PutMapping
    public void alterar(@RequestBody Vagas usuario){
        vagaService.alterar(usuario);
    }

    @DeleteMapping
    public void excluir(@RequestBody Vagas usuario) {
        vagaService.excluir(usuario);
    }
    @GetMapping("/tempoUso")
    public List<Time> tempoUso() {
        List<Time> vagas = vagaService.tempoDeUsoVaga();
        return vagas;
    }
    @GetMapping("/endereco")
    public List<List<String>> enderecoVaga() {
        List<List<String>> retorno = vagaService.enderecoVaga();
        return retorno;
    }
    @GetMapping("/relatorio")
    List<List<String>> relatorioFinanceiro() {
        List<List<String>> retorno = vagaService.relatorioFinanceiro();
        return retorno;
    }
    @GetMapping("/relatorioTotal")
    List<List<String>> relatorioFinanceiroTotal() {
        List<List<String>> retorno = vagaService.relatorioFinanceiroTotal();
        return retorno;
    }
    @GetMapping("/relatorioPorVaga")
    List<List<String>> relatorioFinanceiroPorVaga() {
        List<List<String>> retorno = vagaService.relatorioFinanceiroPorVaga();
        return retorno;
    }
}