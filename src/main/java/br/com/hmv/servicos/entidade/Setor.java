/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.entidade;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author vinim
 */
@Entity
public class Setor implements Serializable {
    
    private Long id;
    private String nome;
    private boolean ativo;
    private List<Solicitacao> solicitacao;
    private List<Solicitacao> solicitacaopara;

    public Setor(String nome, boolean ativo, List<Solicitacao> solicitacao, List<Solicitacao> solicitacaopara) {
       
        this.nome = nome;
        this.ativo = ativo;
        
    }

    public Setor() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "setorDe")
    public List<Solicitacao> getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(List<Solicitacao> solicitacao) {
        this.solicitacao = solicitacao;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "setorPara")
    public List<Solicitacao> getSolicitacaopara() {
        return solicitacaopara;
    }

    public void setSolicitacaopara(List<Solicitacao> solicitacaopara) {
        this.solicitacaopara = solicitacaopara;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + (this.ativo ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.solicitacao);
        hash = 97 * hash + Objects.hashCode(this.solicitacaopara);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Setor other = (Setor) obj;
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.solicitacao, other.solicitacao)) {
            return false;
        }
        if (!Objects.equals(this.solicitacaopara, other.solicitacaopara)) {
            return false;
        }
        return true;
    }

    
    
    
}
