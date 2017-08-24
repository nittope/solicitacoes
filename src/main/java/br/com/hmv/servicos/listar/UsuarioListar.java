/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.listar;

import java.util.List;

/**
 *
 * @author vinim
 */
public class UsuarioListar {
    
    private Long id;
    private String nome;
    private String cpf;
    private String senha;
    private boolean ativo;
    private String authority;    
    private List<Long> solicitacoes;

    public UsuarioListar(Long id, String nome, String cpf, String senha, boolean ativo, String authority, List<Long> solicitacoes) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.ativo = ativo;
        this.authority = authority;
        this.solicitacoes = solicitacoes;
    }

    public UsuarioListar() {
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public List<Long> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(List<Long> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }
    
    
}
