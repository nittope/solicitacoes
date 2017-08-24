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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinim
 */

@Service
public class FachadaServicoImpl implements FachadaServico {
    
    @Autowired
    private ServicoMotivos servicoMotivos;
    
    @Autowired
    private ServicoServico servicoServico;
    
    @Autowired
    private ServicoSetor servicoSetor;
    
    @Autowired
    private ServicoSolicitacao servicoSolicitacao;
    
    @Autowired
    private ServicoSubServico servicoSubServico;
    
    @Autowired
    private ServicoUsuario servicoUsuario;

    @Override
    public void cadastrarMotivos(Motivos motivos) throws MotivosExistenteException, MotivosInexistenteException {
        servicoMotivos.cadastrar(motivos);
    }

    @Override
    public void atualizarMotivos(Motivos motivos) throws MotivosInexistenteException {
        servicoMotivos.atualizar(motivos);
    }

    @Override
    public void removerMotivos(Motivos motivos) throws MotivosInexistenteException {
        servicoMotivos.remover(motivos);
    }

    @Override
    public List<MotivosListar> listarTodosMotivos() {
        return servicoMotivos.listarTodos();
    }

    @Override
    public Motivos ConsultarMotivosPorIdU(Long id) throws MotivosInexistenteException {
        return servicoMotivos.ConsultarPorIdU(id);
    }

    @Override
    public List<MotivosListar> ConsultarMotivosPorID(Long id) throws MotivosInexistenteException {
        return servicoMotivos.ConsultarPorID(id);
    }

    @Override
    public void cadastrarServico(Servico servico) throws ServicoExistenteException, ServicoInexistenteException {
        servicoServico.cadastrar(servico);
    }

    @Override
    public void atualizarServico(Servico servico) throws ServicoInexistenteException {
        servicoServico.atualizar(servico);
    }

    @Override
    public void removerServico(Servico servico) throws ServicoInexistenteException {
        servicoServico.remover(servico);
    }

    @Override
    public List<ServicoListar> listarTodosServico() {
        return servicoServico.listarTodos();
    }

    @Override
    public Servico ConsultarServicoPorIdU(Long id) throws ServicoInexistenteException {
        return servicoServico.ConsultarPorIdU(id);
    }

    @Override
    public List<ServicoListar> ConsultarServicoPorID(Long id) throws ServicoInexistenteException {
        return servicoServico.ConsultarPorID(id);
    }

    @Override
    public void cadastrarSetor(Setor setor) throws SetorExistenteException, SetorInexistenteException {
        servicoSetor.cadastrar(setor);
    }

    @Override
    public void atualizarSetor(Setor setor) throws SetorInexistenteException {
        servicoSetor.atualizar(setor);
    }

    @Override
    public void removerSetor(Setor setor) throws SetorInexistenteException {
        servicoSetor.remover(setor);
    }

    @Override
    public List<SetorListar> listarTodosSetor() {
        return servicoSetor.listarTodos();
    }

    @Override
    public Setor ConsultarSetorPorIdU(Long id) throws SetorInexistenteException {
        return servicoSetor.ConsultarPorIdU(id);
    }

    @Override
    public Setor ConsultarSetorPorIdUPara(Long id) throws SetorInexistenteException {
        return servicoSetor.ConsultarPorIdUPara(id);
    }

    @Override
    public List<SetorListar> ConsultarSetorPorID(Long id) throws SetorInexistenteException {
        return servicoSetor.ConsultarPorID(id);
    }

    @Override
    public void cadastrarSolicitacao(Solicitacao solicitacao, Long idSubServico, Long idServico, Long idMotivo, Long idSetorDe, Long idSetorPara, Long idUsuario) throws SolicitacaoExistenteException, SolicitacaoInexistenteException, SubServicoInexistenteException, ServicoInexistenteException, UsuarioInexistenteException, SetorInexistenteException, MotivosInexistenteException {
        servicoSolicitacao.cadastrar(solicitacao, idSubServico, idServico, idMotivo, idSetorDe, idSetorPara, idUsuario);
    }

    @Override
    public void atualizarSolicitacao(Solicitacao solicitacao, Long idSubServico, Long idServico, Long idMotivo, Long idSetorDe, Long idSetorPara, Long idUsuario) throws SolicitacaoInexistenteException, SubServicoInexistenteException, ServicoInexistenteException, UsuarioInexistenteException, SetorInexistenteException, MotivosInexistenteException {
        servicoSolicitacao.atualizar(solicitacao, idSubServico, idServico, idMotivo, idSetorDe, idSetorPara, idUsuario);
    }

    @Override
    public void removerSolicitacao(Solicitacao solicitacao) throws SolicitacaoInexistenteException {
        servicoSolicitacao.remover(solicitacao);
    }

    @Override
    public List<SolicitacaoListar> listarTodosSolicitacao() {
       return servicoSolicitacao.listarTodos();
    }

    @Override
    public List<SolicitacaoListar> ConsultarSolicitacaoPorID(Long id) throws SolicitacaoInexistenteException {
        return servicoSolicitacao.ConsultarPorID(id);
    }

    @Override
    public void cadastrarSubServico(SubServico subServico, Long idServico) throws SubServicoExistenteException, SubServicoInexistenteException, ServicoInexistenteException {
        servicoSubServico.cadastrar(subServico, idServico);
    }

    @Override
    public void atualizarSubServico(SubServico subServico, Long idServico) throws SubServicoInexistenteException, ServicoInexistenteException {
        servicoSubServico.atualizar(subServico, idServico);
    }

    @Override
    public void removerSubServico(SubServico subServico) throws SubServicoInexistenteException {
        servicoSubServico.remover(subServico);
    }

    @Override
    public List<SubServicoListar> listarTodosSubServico() {
        return servicoSubServico.listarTodos();
    }

    @Override
    public SubServico ConsultarSubServicoPorIdU(Long id) throws SubServicoInexistenteException {
        return servicoSubServico.ConsultarPorIdU(id);
    }

    @Override
    public List<SubServicoListar> ConsultarSubServicoPorID(Long id) throws SubServicoInexistenteException {
        return servicoSubServico.ConsultarPorID(id);
    }

    @Override
    public void cadastrarUsuario(Usuario usuario) throws UsuarioExistenteException, UsuarioInexistenteException {
       servicoUsuario.cadastrar(usuario);
    }

    @Override
    public void atualizarUsuario(Usuario usuario) throws UsuarioInexistenteException {
        servicoUsuario.atualizar(usuario);
    }

    @Override
    public void removerUsuario(Usuario usuario) throws UsuarioInexistenteException {
        servicoUsuario.remover(usuario);
    }

    @Override
    public List<UsuarioListar> listarTodosUsuario() {
        return servicoUsuario.listarTodos();
    }

    @Override
    public Usuario ConsultarUsuarioPorIdU(Long id) throws UsuarioInexistenteException {
        return servicoUsuario.ConsultarPorIdU(id);
    }

    @Override
    public List<UsuarioListar> ConsultarUsuarioPorID(Long id) throws UsuarioInexistenteException {
        return servicoUsuario.ConsultarPorID(id);
    }

    
   
    
}
