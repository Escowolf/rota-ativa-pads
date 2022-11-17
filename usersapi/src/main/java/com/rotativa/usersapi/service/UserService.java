package com.rotativa.usersapi.service;
// interface criada em arquivo separado para manter a privacidade da implementação dos métodos.
import java.util.List;

import org.springframework.stereotype.Component;
import com.rotativa.usersapi.entidades.Usuario;


@Component
public interface UserService {
 
    public List<Usuario> listar();

    public void salvar(Usuario users);

    public void alterar(Usuario usuario);

    public void excluir(Usuario usuario);

    public List<Usuario> carregarPorNome(String nome);

    public List<List<String>> relatorioUsuario();

    
    
}