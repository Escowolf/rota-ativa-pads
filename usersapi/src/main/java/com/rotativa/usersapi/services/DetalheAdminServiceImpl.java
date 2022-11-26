package com.rotativa.usersapi.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.rotativa.usersapi.data.DetalheAdministradorData;
import com.rotativa.usersapi.model.AdministradorModel;
import com.rotativa.usersapi.repository.AdministradorRepository;

import java.util.Optional;

@Component
public class DetalheAdminServiceImpl implements UserDetailsService {

    private final AdministradorRepository repository;

    public DetalheAdminServiceImpl(AdministradorRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AdministradorModel> administrador = repository.findByLogin(username);
        if (administrador.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
        }

        return new DetalheAdministradorData(administrador);
    }

}
