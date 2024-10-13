package com.usuario.controller.request.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RequestFiltroUsuario")
public class RequestFiltroUsuario {

    @ApiModelProperty(notes = "id.")
    private Long id;

    @ApiModelProperty(notes = "Nome.")
    private String nome;

    @ApiModelProperty(notes = "E-mail.")
    private String email;

    @ApiModelProperty(notes = "Senha.")
    private String senha;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
