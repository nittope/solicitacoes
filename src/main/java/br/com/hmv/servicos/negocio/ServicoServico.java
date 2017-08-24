/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.negocio;

import br.com.hmv.servicos.exception.ServicoExistenteException;
import br.com.hmv.servicos.exception.ServicoInexistenteException;
import br.com.hmv.servicos.entidade.Servico;
import br.com.hmv.servicos.listar.ServicoListar;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinim
 */
public interface ServicoServico extends Serializable {
    
    public void cadastrar(Servico servico) throws ServicoExistenteException, ServicoInexistenteException;
    public void atualizar(Servico servico) throws ServicoInexistenteException;
    public void remover(Servico servico) throws ServicoInexistenteException;
    public List<ServicoListar> listarTodos();    
    public Servico ConsultarPorIdU(Long id) throws ServicoInexistenteException;
    public List<ServicoListar> ConsultarPorID(Long id) throws ServicoInexistenteException;
    
}
