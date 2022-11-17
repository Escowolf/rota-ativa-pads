package com.rotativa.usersapi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rotativa.usersapi.database.RepositorioAdministrador;
import com.rotativa.usersapi.entidades.Administrador;
import com.rotativa.usersapi.service.AdministradorService;

@Service("AdministradorService")
public class AdministradorImpl implements AdministradorService {
    RepositorioAdministrador repositorioAdministrador;

    @Autowired
	public AdministradorImpl(RepositorioAdministrador repositorioAdministrador) {
		this.repositorioAdministrador = repositorioAdministrador;
	}
	
	@Override
	public List<Administrador> listar() {
        return repositorioAdministrador.findAll();
    }
    
	@Override
    public void salvar(Administrador administrador) {
    	repositorioAdministrador.save(administrador);
    }

    @Override
    public void alterar(Administrador administrador) {
        if(administrador.getIdadministrador()>0){
            repositorioAdministrador.save(administrador);
        }        
    }

    @Override
    public void excluir(Administrador administrador) {
        repositorioAdministrador.delete(administrador);
    }
    @Override
    public List<Administrador> buscaAdm(String email, int senha) {
        return repositorioAdministrador.buscarAdm(email,senha);
    }
    
}
