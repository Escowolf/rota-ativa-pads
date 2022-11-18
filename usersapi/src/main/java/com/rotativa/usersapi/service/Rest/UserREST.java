package com.rotativa.usersapi.service.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rotativa.usersapi.entidades.Usuario;
/* import com.rotativa.usersapi.entidades.Consultas.UsuarioConsulta; */
import com.rotativa.usersapi.service.UserService;
// possui as operações operações básicas para manipular o usuário no bd
@CrossOrigin(origins = "http://localhost:3000") //Permite que o back envie e receba dados de uma origem diferente
@RestController
@RequestMapping("/user")
public class UserREST {
    @Autowired //o spring cria o objeto, injeta no atributo repositório
    UserService usersService;

    @GetMapping
    public List<Usuario> listar(){
        return usersService.listar();
    }

    @PostMapping
    public void salvar(@RequestBody Usuario usuario){
        usersService.salvar(usuario);
    }

    @PatchMapping
    public void alterar(@RequestBody Usuario usuario){
        usersService.alterar(usuario);
    }

    @DeleteMapping
    public void excluir(@RequestBody Usuario usuario) {
        usersService.excluir(usuario);
    }

    @GetMapping("/filtro")
    public List<Usuario> filtroUsuario(@RequestParam("nome") String nome) {
        System.out.println("Nome = " + nome);
        List<Usuario> usuarios = usersService.carregarPorNome(nome);
        return usuarios;
    }

    @GetMapping("/relatorio")
    List<List<String>> relatorioUsuario() {
        List<List<String>> filtro = usersService.relatorioUsuario();
        return filtro;
    }



    /* @GetMapping("filtro")
    public List<Usuario> filtroUsuario(String nome) {
        if (nome == null) {
            return usersService.listar();
        } else {
            List<Usuario> usuarios = repositorioUser.carregarPorNome(nome);
            return null;
        }
    } */

}