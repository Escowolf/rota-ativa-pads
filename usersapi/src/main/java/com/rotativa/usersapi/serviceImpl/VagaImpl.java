package com.rotativa.usersapi.serviceImpl;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rotativa.usersapi.service.VagaService;

import com.rotativa.usersapi.database.RepositorioVaga;
import com.rotativa.usersapi.entidades.Vagas;

@Service("vagaService")
public class VagaImpl implements VagaService{
	
    RepositorioVaga repositorioVaga;
	
	@Autowired
	public VagaImpl(RepositorioVaga repositorioVaga) {
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

    @Override
    public List<Time> tempoDeUsoVaga() {
        return repositorioVaga.tempoDeUsoVaga();
    }
    
    @Override
    public List<List<String>> enderecoVaga() {
        return repositorioVaga.enderecoVaga();
    }
    @Override
    public List<List<String>> relatorioFinanceiro() {
        return repositorioVaga.relatorioFinanceiro();
    }

    @Override
    public List<List<String>> relatorioRank() {
        return repositorioVaga.relatorioRank();
    }
    @Override
    public List<List<String>> relatorioFinanceiroPorVaga(String nome) {
        return repositorioVaga.relatorioFinanceiroPorVaga(nome);
    }
    @Override
    public List<List<String>> buscarVaga(String nome) {
        return repositorioVaga.buscarVaga(nome);
    }


}

