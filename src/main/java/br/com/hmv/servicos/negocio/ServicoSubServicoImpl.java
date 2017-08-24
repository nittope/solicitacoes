/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.negocio;

import br.com.hmv.servicos.exception.SubServicoExistenteException;
import br.com.hmv.servicos.exception.SubServicoInexistenteException;
import br.com.hmv.servicos.entidade.Servico;
import br.com.hmv.servicos.entidade.SubServico;
import br.com.hmv.servicos.exception.ServicoInexistenteException;
import br.com.hmv.servicos.listar.SubServicoListar;
import br.com.hmv.servicos.persistencia.RepositorioSubservico;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinim
 */
@Service
public class ServicoSubServicoImpl implements ServicoSubServico{
    
    @Autowired
    private RepositorioSubservico repositorioSubservico;
    
    @Autowired
    private ServicoServico servicoServico;

    @Override
    public void cadastrar(SubServico subServico, Long idServico) throws SubServicoExistenteException, SubServicoInexistenteException, ServicoInexistenteException {
        
        Servico servico = servicoServico.ConsultarPorIdU(idServico);
        subServico.setAtivo(subServico.isAtivo());
        subServico.setNome(subServico.getNome());
        subServico.setServico(servico);                        
        repositorioSubservico.save(subServico);       
    }

    @Override
    public void atualizar(SubServico subServico, Long idServico) throws SubServicoInexistenteException, ServicoInexistenteException {
        Servico servico = servicoServico.ConsultarPorIdU(idServico); 
        SubServico subServicoAtualizar = repositorioSubservico.findById(subServico.getId());        
        if(subServicoAtualizar==null)
            throw new SubServicoInexistenteException();
        subServicoAtualizar.setNome(subServico.getNome());        
        subServicoAtualizar.setAtivo(subServico.isAtivo());
        subServicoAtualizar.setServico(servico);
        
        repositorioSubservico.save(subServicoAtualizar); 
    }

    @Override
    public void remover(SubServico subServico) throws SubServicoInexistenteException {
        
    }

    @Override
    public List<SubServicoListar> listarTodos() {
        List<SubServicoListar> retorno = new ArrayList<SubServicoListar>();
        List<SubServico> pesquisa = (List<SubServico>) repositorioSubservico.findAll();
        for(int i = 0;i < pesquisa.size(); i++){
            
                SubServicoListar ul = new SubServicoListar();
                ul.setId(pesquisa.get(i).getId());
                ul.setNome(pesquisa.get(i).getNome());                
                ul.setAtivo(pesquisa.get(i).isAtivo());                
                ul.setServico(pesquisa.get(i).getServico().getId());
                ul.setServicoNome(pesquisa.get(i).getServico().getNome());
                if(pesquisa.get(i).getSolicitacao()!=null){
                    List<Long> solicitacoes = new ArrayList<Long>();
                    for(int j = 0; j < pesquisa.get(i).getSolicitacao().size(); j++){
                        Long nome = pesquisa.get(i).getSolicitacao().get(j).getId();
                        solicitacoes.add(nome);
                    }
                    ul.setSolicitacao(solicitacoes);
                }
                retorno.add(ul);
            
            
        }
        return retorno;  
    }

    @Override
    public List<SubServicoListar> ConsultarPorID(Long id) throws SubServicoInexistenteException {
        List<SubServicoListar> retorno = new ArrayList<SubServicoListar>();
        SubServico pesquisa = repositorioSubservico.findById(id);
        if(pesquisa==null)
            throw new SubServicoInexistenteException();
        
        SubServicoListar ul = new SubServicoListar();
        ul.setId(pesquisa.getId());
        ul.setNome(pesquisa.getNome());        
        ul.setAtivo(pesquisa.isAtivo());        
        ul.setServico(pesquisa.getServico().getId());
        ul.setServicoNome(pesquisa.getServico().getNome());
        if(pesquisa.getSolicitacao()!=null){
                    List<Long> solicitacoesid = new ArrayList<Long>();
                    for(int j = 0; j < pesquisa.getSolicitacao().size(); j++){
                        Long nomeeeee = pesquisa.getSolicitacao().get(j).getId();
                        solicitacoesid.add(nomeeeee);
                    }
                    ul.setSolicitacao(solicitacoesid);
                }
        
        retorno.add(ul);
        return retorno; 
    }

    @Override
    public SubServico ConsultarPorIdU(Long id) throws SubServicoInexistenteException {
        SubServico subServicoAtualizar = repositorioSubservico.findById(id);
        if(subServicoAtualizar==null || !subServicoAtualizar.isAtivo())
            throw new SubServicoInexistenteException();
        return subServicoAtualizar; 
    }
    
    
    
}
