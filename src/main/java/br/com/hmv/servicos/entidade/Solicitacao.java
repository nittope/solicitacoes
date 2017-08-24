/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author vinim
 */
@Entity
public class Solicitacao implements Serializable {
    
    private Long id;
    private Servico servico;
    private SubServico subservico;
    private Setor setorDe;
    private Setor setorPara;
    private Motivos motivo;
    private Date dataSol;
    private Date horaSol;
    private Date dataFechamento;
    private Date horaFechamento;
    private Usuario usuario;
    private String solicitacaoAtendida;
    private String snUrgente;

    public Solicitacao(Servico servico, SubServico subservico, Setor setorDe, Setor setorPara, Motivos motivo, Date dataSol, Date horaSol, Date dataFechamento, Date horaFechamento, Usuario usuario, String solicitacaoAtendida, String snUrgente) {
        
        this.dataSol = dataSol;
        this.horaSol = horaSol;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;          
        this.solicitacaoAtendida = solicitacaoAtendida;
        this.snUrgente = snUrgente;
    }

    public Solicitacao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public SubServico getSubservico() {
        return subservico;
    }

    public void setSubservico(SubServico subservico) {
        this.subservico = subservico;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Setor getSetorDe() {
        return setorDe;
    }

    public void setSetorDe(Setor setorDe) {
        this.setorDe = setorDe;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Setor getSetorPara() {
        return setorPara;
    }

    public void setSetorPara(Setor setorPara) {
        this.setorPara = setorPara;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Motivos getMotivo() {
        return motivo;
    }

    public void setMotivo(Motivos motivo) {
        this.motivo = motivo;
    }

    @Temporal(TemporalType.DATE)
    public Date getDataSol() {
        return dataSol;
    }

    public void setDataSol(Date dataSol) {
        this.dataSol = dataSol;
    }
    @Temporal(TemporalType.DATE)
    public Date getHoraSol() {
        return horaSol;
    }

    public void setHoraSol(Date horaSol) {
        this.horaSol = horaSol;
    }

    @Temporal(TemporalType.DATE)
    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }
    
    @Temporal(TemporalType.DATE)
    public Date getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(Date horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getSolicitacaoAtendida() {
        return solicitacaoAtendida;
    }

    public void setSolicitacaoAtendida(String solicitacaoAtendida) {
        this.solicitacaoAtendida = solicitacaoAtendida;
    }

    public String getSnUrgente() {
        return snUrgente;
    }

    public void setSnUrgente(String snUrgente) {
        this.snUrgente = snUrgente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.servico);
        hash = 11 * hash + Objects.hashCode(this.subservico);
        hash = 11 * hash + Objects.hashCode(this.setorDe);
        hash = 11 * hash + Objects.hashCode(this.setorPara);
        hash = 11 * hash + Objects.hashCode(this.motivo);
        hash = 11 * hash + Objects.hashCode(this.dataSol);
        hash = 11 * hash + Objects.hashCode(this.horaSol);
        hash = 11 * hash + Objects.hashCode(this.dataFechamento);
        hash = 11 * hash + Objects.hashCode(this.horaFechamento);
        hash = 11 * hash + Objects.hashCode(this.usuario);
        hash = 11 * hash + Objects.hashCode(this.solicitacaoAtendida);
        hash = 11 * hash + Objects.hashCode(this.snUrgente);
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
        final Solicitacao other = (Solicitacao) obj;
        if (!Objects.equals(this.solicitacaoAtendida, other.solicitacaoAtendida)) {
            return false;
        }
        if (!Objects.equals(this.snUrgente, other.snUrgente)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.servico, other.servico)) {
            return false;
        }
        if (!Objects.equals(this.subservico, other.subservico)) {
            return false;
        }
        if (!Objects.equals(this.setorDe, other.setorDe)) {
            return false;
        }
        if (!Objects.equals(this.setorPara, other.setorPara)) {
            return false;
        }
        if (!Objects.equals(this.motivo, other.motivo)) {
            return false;
        }
        if (!Objects.equals(this.dataSol, other.dataSol)) {
            return false;
        }
        if (!Objects.equals(this.horaSol, other.horaSol)) {
            return false;
        }
        if (!Objects.equals(this.dataFechamento, other.dataFechamento)) {
            return false;
        }
        if (!Objects.equals(this.horaFechamento, other.horaFechamento)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    
    
}
