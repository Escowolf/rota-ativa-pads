package com.rotativa.usersapi.database;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rotativa.usersapi.entidades.Administrador;

public interface RepositorioAdministrador extends JpaRepository<Administrador, Long> {

    @Query(value = "select * from administrador where email = :email and senha = :senha",  nativeQuery = true)
    List<Administrador> buscarAdm(@Param ("email") String email,@Param ("senha") int senha);
    
}
