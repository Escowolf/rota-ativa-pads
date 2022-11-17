package com.rotativa.usersapi.service.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rotativa.usersapi.entidades.Administrador;
import com.rotativa.usersapi.service.AdministradorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/administrador")
public class AdministradorREST {
    @Autowired
    AdministradorService administradorService;

    @GetMapping
    public List<Administrador> listar(){
        return administradorService.listar();
    }

    @PostMapping("/cadastrar")
    public void salvar(@RequestBody Administrador administrador){
        administradorService.salvar(administrador);
    }

    @PutMapping
    public void alterar(@RequestBody Administrador administrador){
        administradorService.alterar(administrador);
    }

    @DeleteMapping
    public void excluir(@RequestBody Administrador administrador) {
        administradorService.excluir(administrador);
    }
    @GetMapping("/buscar")
    public List<Administrador> buscarAdm(@RequestParam("email") String email,@RequestParam("senha") int senha) {
        System.out.println("email = " +email+" senha: "+ senha);
        List<Administrador> administrador = administradorService.buscaAdm(email, senha);
        if (administrador.isEmpty()) {
            System.out.println("sim");
           
        } else { 
            System.out.println("não");
        }
        return administrador;
    }

}
