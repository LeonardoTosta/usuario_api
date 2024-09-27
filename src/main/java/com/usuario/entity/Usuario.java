package com.usuario.entity;

import com.usuario.role.Role;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TB_USUARIO")
public class Usuario implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Role role;

    public Usuario() {
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    @Id
    @Column(name="ID", unique=true, nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
