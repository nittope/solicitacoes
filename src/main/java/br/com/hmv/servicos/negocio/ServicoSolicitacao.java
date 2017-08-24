/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.negocio;

import br.com.hmv.servicos.exception.SolicitacaoInexistenteException;
import br.com.hmv.servicos.exception.SolicitacaoExistenteException;
import br.com.hmv.servicos.entidade.Solicitacao;
import br.com.hmv.servicos.exception.MotivosInexistenteException;
import br.com.hmv.servicos.exception.ServicoInexistenteException;
import br.com.hmv.servicos.exception.SetorInexistenteException;
import br.com.hmv.servicos.exception.SubServicoInexistenteException;
import br.com.hmv.servicos.exception.UsuarioInexistenteException;
import br.com.hmv.servicos.listar.SolicitacaoListar;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinim
 */
public interface ServicoSolicitacao extends Serializable{
    
    public void cadastrar(Solicitacao solicitacao, Long idSubServico, Long idServico, Long idMotivo, Long idSetorDe, Long idSetorPara, Long idUsuario) throws SolicitacaoExistenteException, SolicitacaoInexistenteException, SubServicoInexistenteException, ServicoInexistenteException, UsuarioInexistenteException, SetorInexistenteException, MotivosInexistenteException;
    public void atualizar(Solicitacao solicitacao, Long idSubServico, Long idServico, Long idMotivo, Long idSetorDe, Long idSetorPara, Long idUsuario) throws SolicitacaoInexistenteException, SubServicoInexistenteException, ServicoInexistenteException, UsuarioInexistenteException, SetorInexistenteException, MotivosInexistenteException;
    public void remover(Solicitacao solicitacao) throws SolicitacaoInexistenteException;
    public List<SolicitacaoListar> listarTodos();    
    public List<SolicitacaoListar> ConsultarPorID(Long id) throws SolicitacaoInexistenteException;
    
}
