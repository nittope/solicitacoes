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
public class SubServicoListar {
    
    private Long id;
    private String nome;
    private boolean ativo;
    private Long servico;
    private String servicoNome;
    private List<Long> solicitacao;

    public SubServicoListar(Long id, String nome, boolean ativo, Long servico, String servicoNome, List<Long> solicitacao) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
        this.servico = servico;
        this.servicoNome = servicoNome;
        this.solicitacao = solicitacao;
    }

    public SubServicoListar() {
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

    public Long getServico() {
        return servico;
    }

    public void setServico(Long servico) {
        this.servico = servico;
    }

    public String getServicoNome() {
        return servicoNome;
    }

    public void setServicoNome(String servicoNome) {
        this.servicoNome = servicoNome;
    }

    public List<Long> getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(List<Long> solicitacao) {
        this.solicitacao = solicitacao;
    }
    
    
    
}
