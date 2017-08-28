/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.negocio;

import br.com.hmv.servicos.entidade.Motivos;
import br.com.hmv.servicos.entidade.Servico;
import br.com.hmv.servicos.exception.MotivosInexistenteException;
import br.com.hmv.servicos.exception.ServicoExistenteException;
import br.com.hmv.servicos.exception.ServicoInexistenteException;
import br.com.hmv.servicos.listar.ServicoListar;
import br.com.hmv.servicos.persistencia.RepositorioServico;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinim
 */
@Service
public class ServicoServicoImpl implements ServicoServico {
    
    @Autowired
    private RepositorioServico repositorioServico;

    @Override
    public void cadastrar(Servico servico) throws ServicoExistenteException, ServicoInexistenteException {
        servico.setAtivo(servico.isAtivo());
        servico.setNome(servico.getNome());                
        repositorioServico.save(servico); 
    }

    @Override
    public void atualizar(Servico servico) throws ServicoInexistenteException {
        Servico servicoAtualizar = repositorioServico.findById(servico.getId());        
        if(servicoAtualizar==null)
            throw new ServicoInexistenteException();
        servicoAtualizar.setNome(servico.getNome());        
        servicoAtualizar.setAtivo(servico.isAtivo());          
        repositorioServico.save(servicoAtualizar); 
    }

    @Override
    public void remover(Servico servico) throws ServicoInexistenteException {
        
    }

    @Override
    public List<ServicoListar> listarTodos() {
        List<ServicoListar> retorno = new ArrayList<ServicoListar>();
        List<Servico> pesquisa = (List<Servico>) repositorioServico.findAll();
        for(int i = 0;i < pesquisa.size(); i++){
            
                ServicoListar ul = new ServicoListar();
                
                ul.setId(pesquisa.get(i).getId());
               
                ul.setNome(pesquisa.get(i).getNome());    
                /*
                ul.setAtivo(pesquisa.get(i).isAtivo());   
                
                if(pesquisa.get(i).getSolicitacao()!=null){
                    List<Long> solicitacoes = new ArrayList<Long>();
                    for(int j = 0; j < pesquisa.get(i).getSolicitacao().size(); j++){
                        Long solicitacao = pesquisa.get(i).getSolicitacao().get(j).getId();
                        solicitacoes.add(solicitacao);
                    }
                    ul.setSolicitacao(solicitacoes);
                }
                
                if(pesquisa.get(i).getSubservicos()!=null){
                    List<Long> subservicos = new ArrayList<Long>();
                    for(int k = 0; k < pesquisa.get(i).getSubservicos().size(); k++){
                        Long subservico = pesquisa.get(i).getSubservicos().get(k).getId();
                        subservicos.add(subservico);
                    }
                    ul.setSubservicos(subservicos);
                }
                */
                retorno.add(ul);
            
            
        }
        return retorno;  
    }

    @Override
    public List<ServicoListar> ConsultarPorID(Long id) throws ServicoInexistenteException {
        List<ServicoListar> retorno = new ArrayList<ServicoListar>();
        Servico pesquisa = repositorioServico.findById(id);
        if(pesquisa==null)
            throw new ServicoInexistenteException();
        
        ServicoListar ul = new ServicoListar();        
        ul.setId(pesquisa.getId());       
        ul.setNome(pesquisa.getNome());   
        /*
        ul.setAtivo(pesquisa.isAtivo());   
        */
        
        /*
        if(pesquisa.getSolicitacao()!=null){
                    List<Long> servicos = new ArrayList<Long>();
                    for(int j = 0; j < pesquisa.getSolicitacao().size(); j++){
                        Long nomeeee = pesquisa.getSolicitacao().get(j).getId();
                        servicos.add(nomeeee);
                    }
                    ul.setSolicitacao(servicos);
                }
        
        if(pesquisa.getSubservicos()!=null){
                    List<Long> subservicos = new ArrayList<Long>();
                    for(int j = 0; j < pesquisa.getSubservicos().size(); j++){
                        Long nomeeeee = pesquisa.getSubservicos().get(j).getId();
                        subservicos.add(nomeeeee);
                    }
                    ul.setSubservicos(subservicos);
                }
         */     
                
        
        retorno.add(ul);
        return retorno; 
    }

    @Override
    public Servico ConsultarPorIdU(Long id) throws ServicoInexistenteException {
        Servico servicoAtualizar = repositorioServico.findById(id);
        if(servicoAtualizar==null || !servicoAtualizar.isAtivo())
            throw new ServicoInexistenteException();
        return servicoAtualizar; 
    }
 }
    
    
    
