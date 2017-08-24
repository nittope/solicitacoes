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
public class SetorListar {
    
    private Long id;
    private String nome;
    private boolean ativo;
    private List<String> solicitacao;
    private List<String> solicitacaopara;

    public SetorListar(Long id, String nome, boolean ativo, List<String> solicitacao, List<String> solicitacaopara) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
        this.solicitacao = solicitacao;
        this.solicitacaopara = solicitacaopara;
    }

    public SetorListar() {
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

    public List<String> getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(List<String> solicitacao) {
        this.solicitacao = solicitacao;
    }

    public List<String> getSolicitacaopara() {
        return solicitacaopara;
    }

    public void setSolicitacaopara(List<String> solicitacaopara) {
        this.solicitacaopara = solicitacaopara;
    }
    
    
    
}
