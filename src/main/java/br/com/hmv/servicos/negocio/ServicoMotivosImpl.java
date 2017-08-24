/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.negocio;

import br.com.hmv.servicos.entidade.Motivos;
import br.com.hmv.servicos.exception.MotivosExistenteException;
import br.com.hmv.servicos.exception.MotivosInexistenteException;
import br.com.hmv.servicos.listar.MotivosListar;
import br.com.hmv.servicos.persistencia.RepositorioMotivos;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinim
 */
@Service
public class ServicoMotivosImpl implements ServicoMotivos {
    
    @Autowired
    private RepositorioMotivos repositorioMotivos;

    @Override
    public void cadastrar(Motivos motivos) throws MotivosExistenteException, MotivosInexistenteException {
        
        motivos.setAtivo(motivos.isAtivo());
        motivos.setNome(motivos.getNome());                
        repositorioMotivos.save(motivos); 
    }

    @Override
    public void atualizar(Motivos motivos) throws MotivosInexistenteException {
        Motivos motivosAtualizar = repositorioMotivos.findById(motivos.getId());        
        if(motivosAtualizar==null)
            throw new MotivosInexistenteException();
        motivosAtualizar.setNome(motivos.getNome());        
        motivosAtualizar.setAtivo(motivos.isAtivo());          
        repositorioMotivos.save(motivosAtualizar); 
    }

    @Override
    public void remover(Motivos motivos) throws MotivosInexistenteException {
        
    }

    @Override
    public List<MotivosListar> listarTodos() {
       
        List<MotivosListar> retorno = new ArrayList<MotivosListar>();
        List<Motivos> pesquisa = (List<Motivos>) repositorioMotivos.findAll();
        for(int i = 0;i < pesquisa.size(); i++){
            
                MotivosListar ul = new MotivosListar();
                ul.setId(pesquisa.get(i).getId());
                ul.setNome(pesquisa.get(i).getNome());                
                ul.setAtivo(pesquisa.get(i).isAtivo());                               
                if(pesquisa.get(i).getSolicitacao()!=null){
                    List<Long> solicitacoes = new ArrayList<Long>();
                    for(int j = 0; j < pesquisa.get(i).getSolicitacao().size(); j++){
                        Long solicitacao = pesquisa.get(i).getSolicitacao().get(j).getId();
                        solicitacoes.add(solicitacao);
                    }
                    ul.setSolicitacoes(solicitacoes);
                }
                retorno.add(ul);
            
            
        }
        return retorno;  
    }

    @Override
    public List<MotivosListar> ConsultarPorID(Long id) throws MotivosInexistenteException {
       List<MotivosListar> retorno = new ArrayList<MotivosListar>();
        Motivos pesquisa = repositorioMotivos.findById(id);
        if(pesquisa==null)
            throw new MotivosInexistenteException();
        
        MotivosListar ul = new MotivosListar();
        ul.setId(pesquisa.getId());
        ul.setNome(pesquisa.getNome());        
        ul.setAtivo(pesquisa.isAtivo());                
        if(pesquisa.getSolicitacao()!=null){
                    List<Long> setores = new ArrayList<Long>();
                    for(int j = 0; j < pesquisa.getSolicitacao().size(); j++){
                        Long nomeeee = pesquisa.getSolicitacao().get(j).getId();
                        setores.add(nomeeee);
                    }
                    ul.setSolicitacoes(setores);
                }
        
        retorno.add(ul);
        return retorno; 
    }

    @Override
    public Motivos ConsultarPorIdU(Long id) throws MotivosInexistenteException {
        Motivos motivosAtualizar = repositorioMotivos.findById(id);
        if(motivosAtualizar==null || !motivosAtualizar.isAtivo())
            throw new MotivosInexistenteException();
        return motivosAtualizar; 
    }
 }
    
    
