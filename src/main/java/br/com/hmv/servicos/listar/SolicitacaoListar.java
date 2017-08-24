/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.listar;

import java.util.Date;

/**
 *
 * @author vinim
 */
public class SolicitacaoListar {
    
    private Long id;
    private Long servico;
    private String servicoNome;
    private Long subservico;
    private String subservicoNome;
    private String setorDe;
    private String setorPara;
    private String motivo;
    private Date dataSol;
    private Date horaSol;
    private Date dataFechamento;
    private Date horaFechamento;
    private Long usuario;
    private String usuarioNome;
    private String solicitacaoAtendida;
    private String snUrgente;

    public SolicitacaoListar(Long id, Long servico, String servicoNome, Long subservico, String subservicoNome, String setorDe, String setorPara, String motivo, Date dataSol, Date horaSol, Date dataFechamento, Date horaFechamento, Long usuario, String usuarioNome, String solicitacaoAtendida, String snUrgente) {
        this.id = id;
        this.servico = servico;
        this.servicoNome = servicoNome;
        this.subservico = subservico;
        this.subservicoNome = subservicoNome;
        this.setorDe = setorDe;
        this.setorPara = setorPara;
        this.motivo = motivo;
        this.dataSol = dataSol;
        this.horaSol = horaSol;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
        this.usuario = usuario;
        this.usuarioNome = usuarioNome;
        this.solicitacaoAtendida = solicitacaoAtendida;
        this.snUrgente = snUrgente;
    }

    public SolicitacaoListar() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getSubservico() {
        return subservico;
    }

    public void setSubservico(Long subservico) {
        this.subservico = subservico;
    }

    public String getSubservicoNome() {
        return subservicoNome;
    }

    public void setSubservicoNome(String subservicoNome) {
        this.subservicoNome = subservicoNome;
    }

    public String getSetorDe() {
        return setorDe;
    }

    public void setSetorDe(String setorDe) {
        this.setorDe = setorDe;
    }

    public String getSetorPara() {
        return setorPara;
    }

    public void setSetorPara(String setorPara) {
        this.setorPara = setorPara;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getDataSol() {
        return dataSol;
    }

    public void setDataSol(Date dataSol) {
        this.dataSol = dataSol;
    }

    public Date getHoraSol() {
        return horaSol;
    }

    public void setHoraSol(Date horaSol) {
        this.horaSol = horaSol;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Date getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(Date horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
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
    
    
    
    
    
}
