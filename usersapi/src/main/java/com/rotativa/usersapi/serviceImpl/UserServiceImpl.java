package com.rotativa.usersapi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rotativa.usersapi.service.UserService;
import com.rotativa.usersapi.database.RepositorioUser;
import com.rotativa.usersapi.entidades.Usuario;


@Service("userService")
public class UserServiceImpl implements UserService{
	
	RepositorioUser repositorioUser;
	
	@Autowired
	public UserServiceImpl(RepositorioUser repositorioUser) {
		this.repositorioUser = repositorioUser;
	}
	
	@Override
	public List<Usuario> listar() {
        return repositorioUser.findAll();
    }
    
	@Override
    public void salvar(Usuario users) {
    	repositorioUser.save(users);
    }

    @Override
    public void alterar(Usuario usuario) {
        if(usuario.getIdusuario()>0){
            repositorioUser.save(usuario);
        }        
    }

    @Override
    public void excluir(Usuario usuario) {
        repositorioUser.delete(usuario);        
    }

    @Override
    public List<Usuario> carregarPorNome(String nome) {
        System.out.println();
        return repositorioUser.carregarPorNome(nome);
    }
    @Override
    public List<List<String>> relatorioUsuario() {
        return repositorioUser.relatorioUsuario();
    }

  
}

