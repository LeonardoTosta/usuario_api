package com.usuario.service;

import com.usuario.entity.Usuario;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void enviaEmail (Usuario usuario, boolean isCadastro){

        String nome = usuario.getNome();
        String email = usuario.getEmail();

        if(isCadastro){
            System.out.println("Cadastro realizado com sucesso! : " + nome + " , e-mail : " + email);
        }else {
            System.out.println("Cadastro alterado com sucesso! : " + nome + " , e-mail : " + email);
        }
    }
}
