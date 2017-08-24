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
import br.com.hmv.servicos.exception.MotivosInexistenteException;
import br.com.hmv.servicos.exception.ServicoInexistenteException;
import br.com.hmv.servicos.exception.SetorInexistenteException;
import br.com.hmv.servicos.exception.SolicitacaoExistenteException;
import br.com.hmv.servicos.exception.SolicitacaoInexistenteException;
import br.com.hmv.servicos.exception.SubServicoInexistenteException;
import br.com.hmv.servicos.exception.UsuarioInexistenteException;
import br.com.hmv.servicos.listar.SolicitacaoListar;
import br.com.hmv.servicos.persistencia.RepositorioSolicitacao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinim
 */
@Service
public class ServicoSolicitacaoImpl implements ServicoSolicitacao {
    
    @Autowired
    private RepositorioSolicitacao repositorioSolicitacao;
    
    @Autowired
    private ServicoMotivos servicoMotivos;
    
    @Autowired
    private ServicoServico servicoServico;
    
    @Autowired
    private ServicoSetor servicoSetor;
    
    @Autowired
    private ServicoSubServico servicoSubServico;
    
    @Autowired
    private ServicoUsuario servicoUsuario;

    @Override
    public void cadastrar(Solicitacao solicitacao, Long idSubServico, Long idServico, Long idMotivo, Long idSetorDe, Long idSetorPara, Long idUsuario) throws SolicitacaoExistenteException, SolicitacaoInexistenteException, SubServicoInexistenteException, ServicoInexistenteException, UsuarioInexistenteException, SetorInexistenteException, MotivosInexistenteException {
        
        SubServico subservico = servicoSubServico.ConsultarPorIdU(idSubServico);
        Servico servico = servicoServico.ConsultarPorIdU(idServico);
        Motivos motivo = servicoMotivos.ConsultarPorIdU(idMotivo);
        Usuario usuario = servicoUsuario.ConsultarPorIdU(idUsuario);
        Setor setor = servicoSetor.ConsultarPorIdU(idSetorDe);
        Setor setorPara = servicoSetor.ConsultarPorIdUPara(idSetorPara);
        
        solicitacao.setServico(servico);
        solicitacao.setSubservico(subservico);
        solicitacao.setSetorDe(setor);
        solicitacao.setSetorPara(setorPara);
        solicitacao.setMotivo(motivo);
        solicitacao.setDataSol(solicitacao.getDataSol());
        solicitacao.setHoraSol(solicitacao.getHoraSol());
        solicitacao.setDataFechamento(solicitacao.getDataFechamento());
        solicitacao.setHoraFechamento(solicitacao.getHoraFechamento());
        solicitacao.setUsuario(usuario);
        solicitacao.setSolicitacaoAtendida(solicitacao.getSolicitacaoAtendida());
        solicitacao.setSnUrgente(solicitacao.getSnUrgente());
        
                                
        repositorioSolicitacao.save(solicitacao); 
        
     
    }

    @Override
    public void atualizar(Solicitacao solicitacao, Long idSubServico, Long idServico, Long idMotivo, Long idSetorDe, Long idSetorPara, Long idUsuario) throws SolicitacaoInexistenteException, SubServicoInexistenteException, ServicoInexistenteException, UsuarioInexistenteException, SetorInexistenteException, MotivosInexistenteException {
        
        SubServico subservico = servicoSubServico.ConsultarPorIdU(idSubServico);
        Servico servico = servicoServico.ConsultarPorIdU(idServico);
        Motivos motivo = servicoMotivos.ConsultarPorIdU(idMotivo);
        Usuario usuario = servicoUsuario.ConsultarPorIdU(idUsuario);
        Setor setor = servicoSetor.ConsultarPorIdU(idSetorDe);
        Setor setorPara = servicoSetor.ConsultarPorIdUPara(idSetorPara);
        
        Solicitacao solicitacaoAtualizar = repositorioSolicitacao.findById(solicitacao.getId());     
        if(solicitacaoAtualizar==null)
            throw new SolicitacaoInexistenteException();
        
        
        solicitacaoAtualizar.setServico(servico);        
        solicitacaoAtualizar.setSubservico(subservico);
        solicitacaoAtualizar.setSetorDe(setor);
        solicitacaoAtualizar.setSetorPara(setorPara);
        solicitacaoAtualizar.setMotivo(motivo);
        solicitacaoAtualizar.setDataSol(solicitacao.getDataSol());
        solicitacaoAtualizar.setHoraSol(solicitacao.getHoraSol());
        solicitacaoAtualizar.setDataFechamento(solicitacao.getDataFechamento());
        solicitacaoAtualizar.setHoraFechamento(solicitacao.getHoraFechamento());
        solicitacaoAtualizar.setUsuario(usuario);
        solicitacaoAtualizar.setSolicitacaoAtendida(solicitacao.getSolicitacaoAtendida());
        solicitacaoAtualizar.setSnUrgente(solicitacao.getSnUrgente());
        
        repositorioSolicitacao.save(solicitacaoAtualizar);

    }

    @Override
    public void remover(Solicitacao solicitacao) throws SolicitacaoInexistenteException {
        
    }

    @Override
    public List<SolicitacaoListar> listarTodos() {
        List<SolicitacaoListar> retorno = new ArrayList<SolicitacaoListar>();
        List<Solicitacao> pesquisa = (List<Solicitacao>) repositorioSolicitacao.findAll();
        for(int i = 0;i < pesquisa.size(); i++){
            
                SolicitacaoListar ul = new SolicitacaoListar();
                ul.setId(pesquisa.get(i).getId());                                
                ul.setServico(pesquisa.get(i).getServico().getId());
                ul.setServicoNome(pesquisa.get(i).getServico().getNome());
                ul.setSubservico(pesquisa.get(i).getSubservico().getId());
                ul.setSubservicoNome(pesquisa.get(i).getSubservico().getNome());
                ul.setSetorDe(pesquisa.get(i).getSetorDe().getNome());
                ul.setSetorPara(pesquisa.get(i).getSetorPara().getNome());
                ul.setMotivo(pesquisa.get(i).getMotivo().getNome());
                ul.setDataSol(pesquisa.get(i).getDataSol());
                ul.setHoraSol(pesquisa.get(i).getHoraSol());
                ul.setDataFechamento(pesquisa.get(i).getDataFechamento());
                ul.setHoraFechamento(pesquisa.get(i).getHoraFechamento());
                ul.setUsuario(pesquisa.get(i).getUsuario().getId());
                ul.setUsuarioNome(pesquisa.get(i).getUsuario().getNome());
                ul.setSolicitacaoAtendida(pesquisa.get(i).getSolicitacaoAtendida());
                ul.setSnUrgente(pesquisa.get(i).getSnUrgente());
                
                
                
                retorno.add(ul);
            
            
        }
        return retorno; 
    }

    @Override
    public List<SolicitacaoListar> ConsultarPorID(Long id) throws SolicitacaoInexistenteException {
        
        List<SolicitacaoListar> retorno = new ArrayList<SolicitacaoListar>();
        Solicitacao pesquisa = repositorioSolicitacao.findById(id);
        if(pesquisa==null)
            throw new SolicitacaoInexistenteException();
        
        SolicitacaoListar ul = new SolicitacaoListar();
        ul.setId(pesquisa.getId());                                
        ul.setServico(pesquisa.getServico().getId());
        ul.setServicoNome(pesquisa.getServico().getNome());
        ul.setSubservico(pesquisa.getSubservico().getId());
        ul.setSubservicoNome(pesquisa.getSubservico().getNome());
        ul.setSetorDe(pesquisa.getSetorDe().getNome());
        ul.setSetorPara(pesquisa.getSetorPara().getNome());
        ul.setMotivo(pesquisa.getMotivo().getNome());
        ul.setDataSol(pesquisa.getDataSol());
        ul.setHoraSol(pesquisa.getHoraSol());
        ul.setDataFechamento(pesquisa.getDataFechamento());
        ul.setHoraFechamento(pesquisa.getHoraFechamento());
        ul.setUsuario(pesquisa.getUsuario().getId());
        ul.setUsuarioNome(pesquisa.getUsuario().getNome());
        ul.setSolicitacaoAtendida(pesquisa.getSolicitacaoAtendida());
        ul.setSnUrgente(pesquisa.getSnUrgente());
                
        retorno.add(ul);
        return retorno; 
    }
    
    
    
    
}
