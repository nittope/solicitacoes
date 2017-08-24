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
public class MotivosListar {
    
    private Long id;
    private String nome;
    private boolean ativo;
    private List<Long> solicitacoes;

    public MotivosListar(Long id, String nome, boolean ativo, List<Long> solicitacoes) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
        this.solicitacoes = solicitacoes;
    }

    public MotivosListar() {
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Long> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(List<Long> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }
    
    
}
