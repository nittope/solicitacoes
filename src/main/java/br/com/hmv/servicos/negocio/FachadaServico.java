/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.negocio;

import br.com.hmv.servicos.entidade.Motivos;
import br.com.hmv.servicos.entidade.Servico;
import br.com.hmv.servicos.entidade.Setor;
import br.com.hmv.servicos.entidade.Solicitacao;
import br.com.hmv.servicos.entidade.SubServico;
import br.com.hmv.servicos.entidade.Usuario;
import br.com.hmv.servicos.exception.MotivosExistenteException;
import br.com.hmv.servicos.exception.MotivosInexistenteException;
import br.com.hmv.servicos.exception.ServicoExistenteException;
import br.com.hmv.servicos.exception.ServicoInexistenteException;
import br.com.hmv.servicos.exception.SetorExistenteException;
import br.com.hmv.servicos.exception.SetorInexistenteException;
import br.com.hmv.servicos.exception.SolicitacaoExistenteException;
import br.com.hmv.servicos.exception.SolicitacaoInexistenteException;
import br.com.hmv.servicos.exception.SubServicoExistenteException;
import br.com.hmv.servicos.exception.SubServicoInexistenteException;
import br.com.hmv.servicos.exception.UsuarioExistenteException;
import br.com.hmv.servicos.exception.UsuarioInexistenteException;
import br.com.hmv.servicos.listar.MotivosListar;
import br.com.hmv.servicos.listar.ServicoListar;
import br.com.hmv.servicos.listar.SetorListar;
import br.com.hmv.servicos.listar.SolicitacaoListar;
import br.com.hmv.servicos.listar.SubServicoListar;
import br.com.hmv.servicos.listar.UsuarioListar;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinim
 */
public interface FachadaServico extends Serializable {
    
    public void cadastrarMotivos(Motivos motivos) throws MotivosExistenteException, MotivosInexistenteException;
    public void atualizarMotivos(Motivos motivos) throws MotivosInexistenteException;
    public void removerMotivos(Motivos motivos) throws MotivosInexistenteException;
    public List<MotivosListar> listarTodosMotivos();    
    public Motivos ConsultarMotivosPorIdU(Long id) throws MotivosInexistenteException;    
    public List<MotivosListar> ConsultarMotivosPorID(Long id) throws MotivosInexistenteException;
    
    public void cadastrarServico(Servico servico) throws ServicoExistenteException, ServicoInexistenteException;
    public void atualizarServico(Servico servico) throws ServicoInexistenteException;
    public void removerServico(Servico servico) throws ServicoInexistenteException;
    public List<ServicoListar> listarTodosServico();    
    public Servico ConsultarServicoPorIdU(Long id) throws ServicoInexistenteException;
    public List<ServicoListar> ConsultarServicoPorID(Long id) throws ServicoInexistenteException;
    
    public void cadastrarSetor(Setor setor) throws SetorExistenteException, SetorInexistenteException;
    public void atualizarSetor(Setor setor) throws SetorInexistenteException;
    public void removerSetor(Setor setor) throws SetorInexistenteException;
    public List<SetorListar> listarTodosSetor();    
    public Setor ConsultarSetorPorIdU(Long id) throws SetorInexistenteException;
    public Setor ConsultarSetorPorIdUPara(Long id) throws SetorInexistenteException;    
    public List<SetorListar> ConsultarSetorPorID(Long id) throws SetorInexistenteException;
    
    public void cadastrarSolicitacao(Solicitacao solicitacao, Long idSubServico, Long idServico, Long idMotivo, Long idSetorDe, Long idSetorPara, Long idUsuario) throws SolicitacaoExistenteException, SolicitacaoInexistenteException, SubServicoInexistenteException, ServicoInexistenteException, UsuarioInexistenteException, SetorInexistenteException, MotivosInexistenteException;
    public void atualizarSolicitacao(Solicitacao solicitacao, Long idSubServico, Long idServico, Long idMotivo, Long idSetorDe, Long idSetorPara, Long idUsuario) throws SolicitacaoInexistenteException, SubServicoInexistenteException, ServicoInexistenteException, UsuarioInexistenteException, SetorInexistenteException, MotivosInexistenteException;
    public void removerSolicitacao(Solicitacao solicitacao) throws SolicitacaoInexistenteException;
    public List<SolicitacaoListar> listarTodosSolicitacao();    
    public List<SolicitacaoListar> ConsultarSolicitacaoPorID(Long id) throws SolicitacaoInexistenteException;
    
    public void cadastrarSubServico(SubServico subServico, Long idServico) throws SubServicoExistenteException, SubServicoInexistenteException, ServicoInexistenteException;
    public void atualizarSubServico(SubServico subServico, Long idServico) throws SubServicoInexistenteException, ServicoInexistenteException;
    public void removerSubServico(SubServico subServico) throws SubServicoInexistenteException;
    public List<SubServicoListar> listarTodosSubServico();    
    public SubServico ConsultarSubServicoPorIdU(Long id) throws SubServicoInexistenteException;    
    public List<SubServicoListar> ConsultarSubServicoPorID(Long id) throws SubServicoInexistenteException;
    
    public void cadastrarUsuario(Usuario usuario) throws UsuarioExistenteException, UsuarioInexistenteException;
    public void atualizarUsuario(Usuario usuario) throws UsuarioInexistenteException;
    public void removerUsuario(Usuario usuario) throws UsuarioInexistenteException;
    public List<UsuarioListar> listarTodosUsuario();    
    public Usuario ConsultarUsuarioPorIdU(Long id) throws UsuarioInexistenteException;    
    public List<UsuarioListar> ConsultarUsuarioPorID(Long id) throws UsuarioInexistenteException;
    
}
