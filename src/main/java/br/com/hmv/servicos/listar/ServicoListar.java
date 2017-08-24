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
public class ServicoListar {
    
    private Long id;
    private String nome;
    private boolean ativo;
    private List<Long> subservicos;
    private List<Long> solicitacao;

    public ServicoListar(Long id, String nome, boolean ativo, List<Long> subservicos, List<Long> solicitacao) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
        this.subservicos = subservicos;
        this.solicitacao = solicitacao;
    }

    public ServicoListar() {
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

    public List<Long> getSubservicos() {
        return subservicos;
    }

    public void setSubservicos(List<Long> subservicos) {
        this.subservicos = subservicos;
    }

    public List<Long> getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(List<Long> solicitacao) {
        this.solicitacao = solicitacao;
    }
    
    
}
