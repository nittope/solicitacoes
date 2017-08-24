/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.negocio;

import br.com.hmv.servicos.exception.UsuarioExistenteException;
import br.com.hmv.servicos.exception.UsuarioInexistenteException;
import br.com.hmv.servicos.entidade.Usuario;
import br.com.hmv.servicos.listar.UsuarioListar;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinim
 */
public interface ServicoUsuario extends Serializable {
    
    public void cadastrar(Usuario usuario) throws UsuarioExistenteException, UsuarioInexistenteException;
    public void atualizar(Usuario usuario) throws UsuarioInexistenteException;
    public void remover(Usuario usuario) throws UsuarioInexistenteException;
    public List<UsuarioListar> listarTodos();    
    public Usuario ConsultarPorIdU(Long id) throws UsuarioInexistenteException;    
    public List<UsuarioListar> ConsultarPorID(Long id) throws UsuarioInexistenteException;
    
   
    
}
