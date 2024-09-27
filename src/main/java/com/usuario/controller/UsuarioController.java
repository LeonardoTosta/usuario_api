package com.usuario.controller;


import com.usuario.controller.request.vo.RequestFiltroUsuario;
import com.usuario.entity.Usuario;
import com.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api")
public class UsuarioController {

    @Autowired private UsuarioService usuarioService;

    @GetMapping("login")
    public String login() {
        return "usuário autenticado.";
    }

    @PostMapping(path = "cadastro")
    public void cadatraUsuario (@RequestBody RequestFiltroUsuario requestFiltroUsuario) {
        usuarioService.cadastraUsuario(requestFiltroUsuario);
    }

    @PostMapping(path = "edita/{id}")
    public void editaUsuario (@PathVariable(value = "id") Long id, @RequestBody RequestFiltroUsuario requestFiltroUsuario) {
        usuarioService.editaUsuario(id, requestFiltroUsuario);
    }

    @GetMapping(path = "consulta/{inicio}/{max}")
    public ResponseEntity consultaUsuario (@PathVariable(value = "inicio") Integer inicio, @PathVariable(value = "max") Integer max, @RequestBody RequestFiltroUsuario requestFiltroUsuario){
        List<Usuario> listaUsuario = usuarioService.consultaUsuario(requestFiltroUsuario);
        return new ResponseEntity(listaUsuario, HttpStatus.OK);
    }
}

