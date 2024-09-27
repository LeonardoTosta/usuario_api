package com.usuario.service;

import com.usuario.controller.request.vo.RequestFiltroUsuario;
import com.usuario.entity.Usuario;
import com.usuario.filtro.UsuarioFiltro;
import com.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UsuarioService {

    @Autowired UsuarioRepository usuarioRepository;
    @Autowired EmailService emailService;


    public void cadastraUsuario(RequestFiltroUsuario vo){

       try{
           String nome = vo.getNome();
           String email = vo.getEmail();
           String senha = vo.getSenha();

           Usuario usuario = new Usuario();

           usuario.setNome(nome);
           usuario.setEmail(email);
           usuario.setSenha(senha);

           usuarioRepository.saveUsuario(usuario);

           emailService.enviaEmail(usuario, true);

       }catch (Exception e){
           e.printStackTrace();
           e.getMessage();
       }
    }

    public void editaUsuario(Long id, RequestFiltroUsuario vo){

        try{
            String nome = vo.getNome();
            String email = vo.getEmail();
            String senha = vo.getSenha();

            UsuarioFiltro filtro = new UsuarioFiltro();
            filtro.setId(id != null ? id : null);

            List<Usuario> usuarioById = usuarioRepository.findByIdAndNome(filtro, null, null);
            Usuario usuario = usuarioById.get(0);

            if(nome != null && !nome.isEmpty()){
                usuario.setNome(nome);
            }
            if(email != null && !email.isEmpty()){
                usuario.setEmail(email);
            }
            if(senha != null && !senha.isEmpty()){
                usuario.setSenha(senha);
            }

            usuarioRepository.saveUsuario(usuario);

            emailService.enviaEmail(usuario, false);

        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
    }

    public List<Usuario> consultaUsuario(RequestFiltroUsuario vo){

        Long Id = vo.getId();
        String nome = vo.getNome();
        Integer inicio = vo.getInicio();
        Integer max = vo.getMax();

        UsuarioFiltro filtro = new UsuarioFiltro();

        filtro.setId(Id != null ? Id : null);
        filtro.setNome(nome != null ? nome : null);


        List<Usuario> usuarios = usuarioRepository.findByIdAndNome(filtro, inicio, max);

        return usuarios;
    }
}
