package com.rotativa.usersapi.service;
import java.sql.Time;
// interface criada em arquivo separado para manter a privacidade da implementação dos métodos.
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import com.rotativa.usersapi.entidades.Vagas;

@Component
public interface VagaService {

    public List<Time> tempoDeUsoVaga();

    public List<List<String>> enderecoVaga();

    List<List<String>> relatorioFinanceiro();

    List<List<String>> relatorioRank();

    List<List<String>> relatorioFinanceiroPorVaga(@Param("nome") String nome );
 
    public List<Vagas> listar();
    
    public void salvar(Vagas vagas);

    public void alterar(Vagas vagas);

    public void excluir(Vagas vagas);

    List<List<String>> buscarVaga(@Param("nome") String nome);
}