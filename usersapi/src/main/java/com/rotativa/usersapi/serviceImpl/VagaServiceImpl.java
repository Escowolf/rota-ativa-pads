package com.rotativa.usersapi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rotativa.usersapi.service.VagaService;

import com.rotativa.usersapi.database.RepositorioVaga;
import com.rotativa.usersapi.Entidades.Vagas;

@Service("vagaService")
public class VagaServiceImpl implements VagaService{
	
    RepositorioVaga repositorioVaga;
	
	@Autowired
	public VagaServiceImpl(RepositorioVaga repositorioVaga) {
		this.repositorioVaga = repositorioVaga;
	}
	
	@Override
	public List<Vagas> listar() {
        return repositorioVaga.findAll();
    }
    
	@Override
    public void salvar(Vagas vagas) {
    	repositorioVaga.save(vagas);
    }

    @Override
    public void alterar(Vagas vagas) {
        if(vagas.getIdvaga()>0){
            repositorioVaga.save(vagas);
        }        
    }

    @Override
    public void excluir(Vagas usuario) {
        repositorioVaga.delete(usuario);        
    }
}

