package com.rotativa.usersapi.database;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rotativa.usersapi.entidades.*;



public interface RepositorioVaga extends JpaRepository<Vagas, Long> {

    @Query(value = "select v.rua_avenida, v.bairro  from vaga v", nativeQuery = true)
    List<List<String>> enderecoVaga();

    @Query(value = "SELECT TIMEDIFF(v.saida,v.entrada)  FROM vaga v  ", nativeQuery = true)
    List<Time> tempoDeUsoVaga();

    @Query(value = "select v.bairro,u.nome as nome_usuario,v.nome as nome_vaga,p.valor,p.dataCompra from vaga v " +
            "join usuario_has_vaga h " +
            "on v.idvaga = h.vaga_idvaga " +
            "join usuario u " +
            "on u.idusuario = h.usuario_idusuario " +
            "join pagamento p " +
            "on u.idusuario = p.usuario_idusuario "
    /* #where p.dataCompra >= "2022-05-01" and p.dataCompra <= "2022-10-01" */, nativeQuery = true)
    List<List<String>> relatorioFinanceiro();

    @Query(value = "select sum(p.valor) as valor_total from vaga v " +
            "join usuario_has_vaga h " +
            "on v.idvaga = h.vaga_idvaga " +
            "join usuario u " +
            "on u.idusuario = h.usuario_idusuario " +
            "join pagamento p " +
            "on u.idusuario = p.usuario_idusuario", nativeQuery = true)
    List<List<String>> relatorioFinanceiroTotal();

    
    @Query(value = "select v.nome as nome_vaga,sum(p.valor) from vaga v "+
    "join usuario_has_vaga h "+
    "on v.idvaga = h.vaga_idvaga "+
    "join usuario u "+
    "on u.idusuario = h.usuario_idusuario "+
    "join pagamento p "+
    "on u.idusuario = p.usuario_idusuario "+
    /* #where p.dataCompra >= "2022-05-01" and p.dataCompra <= "2022-10-01"  */ 
    "group by v.nome# u.nome "+
    "order by v.nome", nativeQuery = true)
    List<List<String>> relatorioFinanceiroPorVaga();

}


/* */

 