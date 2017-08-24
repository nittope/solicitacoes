/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.negocio;

import br.com.hmv.servicos.exception.MotivosExistenteException;
import br.com.hmv.servicos.exception.MotivosInexistenteException;
import br.com.hmv.servicos.entidade.Motivos;
import br.com.hmv.servicos.listar.MotivosListar;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinim
 */
public interface ServicoMotivos extends Serializable {
    
    public void cadastrar(Motivos motivos) throws MotivosExistenteException, MotivosInexistenteException;
    public void atualizar(Motivos motivos) throws MotivosInexistenteException;
    public void remover(Motivos motivos) throws MotivosInexistenteException;
    public List<MotivosListar> listarTodos();    
    public Motivos ConsultarPorIdU(Long id) throws MotivosInexistenteException;    
    public List<MotivosListar> ConsultarPorID(Long id) throws MotivosInexistenteException;
    
    
}
