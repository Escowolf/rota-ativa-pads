package com.rotativa.usersapi.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rotativa.usersapi.entidades.*;


public interface RepositorioUser extends JpaRepository<Usuario, Long> {
 /*    List<Usuario> findByNome(String nome); */
   /*  Usuario buscarPessoaPorNome(String nome); */

    @Query(value = "SELECT * FROM usuario WHERE usuario.nome = :nome",  nativeQuery = true)
    List<Usuario> carregarPorNome(@Param("nome") String nome);

@   Query(value = "select u.nome,u.email ,t.telefone,v.cor, v.placa, v.modelo from usuario u "+ 
    "join usuario_has_veiculo h "+
    "on u.idusuario = h.usuario_idusuario "+
    "join veiculo v "+
    "on v.idveiculo = h.veiculo_idveiculo "+
    "join telefone t "+
    "on u.idusuario = t.usuario_idusuario",  nativeQuery = true)
    List<List<String>> relatorioUsuario();

}


