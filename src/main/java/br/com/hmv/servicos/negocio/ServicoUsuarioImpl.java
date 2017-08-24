/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.negocio;

import br.com.hmv.servicos.entidade.Usuario;
import br.com.hmv.servicos.exception.UsuarioExistenteException;
import br.com.hmv.servicos.exception.UsuarioInexistenteException;
import br.com.hmv.servicos.listar.UsuarioListar;
import br.com.hmv.servicos.persistencia.RepositorioUsuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinim
 */
@Service
public class ServicoUsuarioImpl implements ServicoUsuario{
    
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Override
    public void cadastrar(Usuario usuario) throws UsuarioExistenteException, UsuarioInexistenteException {
        
        usuario.setAtivo(usuario.isAtivo());
        usuario.setNome(usuario.getNome());
        usuario.setCpf(usuario.getCpf());
        usuario.setSenha(usuario.getSenha());
        usuario.setAuthority(usuario.getAuthority());        
        repositorioUsuario.save(usuario); 
        
    }

    @Override
    public void atualizar(Usuario usuario) throws UsuarioInexistenteException {
        
         
        Usuario usuarioAtualizar = repositorioUsuario.findById(usuario.getId());        
        if(usuarioAtualizar==null)
            throw new UsuarioInexistenteException();
        usuarioAtualizar.setNome(usuario.getNome());        
        usuarioAtualizar.setAtivo(usuario.isAtivo());
        usuarioAtualizar.setCpf(usuario.getCpf());
        usuarioAtualizar.setSenha(usuario.getSenha());
        usuarioAtualizar.setAuthority(usuario.getAuthority());        
        repositorioUsuario.save(usuarioAtualizar); 
        
    }

    @Override
    public void remover(Usuario usuario) throws UsuarioInexistenteException {
        
    }

    @Override
    public List<UsuarioListar> listarTodos() {
        
        List<UsuarioListar> retorno = new ArrayList<UsuarioListar>();
        List<Usuario> pesquisa = (List<Usuario>) repositorioUsuario.findAll();
        for(int i = 0;i < pesquisa.size(); i++){
            
                UsuarioListar ul = new UsuarioListar();
                ul.setId(pesquisa.get(i).getId());
                ul.setNome(pesquisa.get(i).getNome());                
                ul.setAtivo(pesquisa.get(i).isAtivo());
                ul.setCpf(pesquisa.get(i).getCpf());
                ul.setSenha(pesquisa.get(i).getSenha());
                ul.setAuthority(pesquisa.get(i).getAuthority());                
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
    public List<UsuarioListar> ConsultarPorID(Long id) throws UsuarioInexistenteException {
        List<UsuarioListar> retorno = new ArrayList<UsuarioListar>();
        Usuario pesquisa = repositorioUsuario.findById(id);
        if(pesquisa==null)
            throw new UsuarioInexistenteException();
        
        UsuarioListar ul = new UsuarioListar();
        ul.setId(pesquisa.getId());
        ul.setNome(pesquisa.getNome());        
        ul.setAtivo(pesquisa.isAtivo());
        ul.setCpf(pesquisa.getCpf());
        ul.setSenha(pesquisa.getSenha());
        ul.setAuthority(pesquisa.getAuthority());        
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
    public Usuario ConsultarPorIdU(Long id) throws UsuarioInexistenteException {
        Usuario usuarioAtualizar = repositorioUsuario.findById(id);
        if(usuarioAtualizar==null || !usuarioAtualizar.isAtivo())
            throw new UsuarioInexistenteException();
        return usuarioAtualizar; 
    }

       
    
}
