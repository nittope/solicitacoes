/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.persistencia;

import br.com.hmv.servicos.entidade.Solicitacao;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vinim
 */
public interface RepositorioSolicitacao extends CrudRepository<Solicitacao, Long> {
    
    public Solicitacao findBySolicitacaoAtendida(String solicitacaoAtendida);
    public Solicitacao findById(Long id);
    
}
