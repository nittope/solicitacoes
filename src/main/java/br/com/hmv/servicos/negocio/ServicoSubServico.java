/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.negocio;

import br.com.hmv.servicos.exception.SubServicoExistenteException;
import br.com.hmv.servicos.exception.SubServicoInexistenteException;
import br.com.hmv.servicos.entidade.SubServico;
import br.com.hmv.servicos.exception.ServicoInexistenteException;
import br.com.hmv.servicos.listar.SubServicoListar;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinim
 */
public interface ServicoSubServico extends Serializable {
    
    public void cadastrar(SubServico subServico, Long idServico) throws SubServicoExistenteException, SubServicoInexistenteException, ServicoInexistenteException;
    public void atualizar(SubServico subServico, Long idServico) throws SubServicoInexistenteException, ServicoInexistenteException;
    public void remover(SubServico subServico) throws SubServicoInexistenteException;
    public List<SubServicoListar> listarTodos();    
    public SubServico ConsultarPorIdU(Long id) throws SubServicoInexistenteException;    
    public List<SubServicoListar> ConsultarPorID(Long id) throws SubServicoInexistenteException;
    
}
