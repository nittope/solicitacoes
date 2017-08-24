/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.negocio;

import br.com.hmv.servicos.entidade.Setor;
import br.com.hmv.servicos.exception.SetorExistenteException;
import br.com.hmv.servicos.exception.SetorInexistenteException;
import br.com.hmv.servicos.listar.SetorListar;
import br.com.hmv.servicos.persistencia.RepositorioSetor;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinim
 */
@Service
public class ServicoSetorImpl implements ServicoSetor{
    
    @Autowired
    private RepositorioSetor repositorioSetor;

    @Override
    public void cadastrar(Setor setor) throws SetorExistenteException, SetorInexistenteException {
        
        setor.setAtivo(setor.isAtivo());
        setor.setNome(setor.getNome());               
        repositorioSetor.save(setor);       
    }

    @Override
    public void atualizar(Setor setor) throws SetorInexistenteException {
        Setor setorAtualizar = repositorioSetor.findById(setor.getId());        
        if(setorAtualizar==null)
            throw new SetorInexistenteException();
        setorAtualizar.setNome(setor.getNome());        
        setorAtualizar.setAtivo(setor.isAtivo());          
        repositorioSetor.save(setorAtualizar);
    }

    @Override
    public void remover(Setor setor) throws SetorInexistenteException {
        
    }

    @Override
    public List<SetorListar> listarTodos() {
        List<SetorListar> retorno = new ArrayList<SetorListar>();
        List<Setor> pesquisa = (List<Setor>) repositorioSetor.findAll();
        for(int i = 0;i < pesquisa.size(); i++){
            
                SetorListar ul = new SetorListar();
                ul.setId(pesquisa.get(i).getId());
                ul.setNome(pesquisa.get(i).getNome());                
                ul.setAtivo(pesquisa.get(i).isAtivo());                               
                
                retorno.add(ul);
            
            
        }
        return retorno;  
    }

    @Override
    public List<SetorListar> ConsultarPorID(Long id) throws SetorInexistenteException {
        
        List<SetorListar> retorno = new ArrayList<SetorListar>();
        Setor pesquisa = repositorioSetor.findById(id);
        if(pesquisa==null)
            throw new SetorInexistenteException();
        
        SetorListar ul = new SetorListar();
        ul.setId(pesquisa.getId());
        ul.setNome(pesquisa.getNome());        
        ul.setAtivo(pesquisa.isAtivo());                
        
        
        retorno.add(ul);
        return retorno; 
    }

    @Override
    public Setor ConsultarPorIdU(Long id) throws SetorInexistenteException {
        Setor setorAtualizar = repositorioSetor.findById(id);
        if(setorAtualizar==null || !setorAtualizar.isAtivo())
            throw new SetorInexistenteException();
        return setorAtualizar; 
    }

    @Override
    public Setor ConsultarPorIdUPara(Long id) throws SetorInexistenteException {
        Setor setorAtualizar = repositorioSetor.findById(id);
        if(setorAtualizar==null || !setorAtualizar.isAtivo())
            throw new SetorInexistenteException();
        return setorAtualizar; 
    }
}
    
    

