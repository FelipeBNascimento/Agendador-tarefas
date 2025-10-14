package com.javanauta.agendadortarefa.infraesctruture.security;



import com.javanauta.agendadortarefa.business.dto.UsuarioDTO;
import com.javanauta.agendadortarefa.infraesctruture.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl{

    private final UsuarioClient usuarioClient;



    public UserDetails carregarDadosUsuaioPorEmail(String email, String token) {

        UsuarioDTO usuarioDTO = usuarioClient.buscarUsuarioPorEmail(email, token);

        return User
                .withUsername(usuarioDTO.getEmail())
                .password(usuarioDTO.getSenha())
                .build();


    }

}
