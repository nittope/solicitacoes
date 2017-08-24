/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.persistencia;

import br.com.hmv.servicos.entidade.Servico;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author vinim
 */
public interface  RepositorioServico extends CrudRepository<Servico, Long> {
    
    public Servico findByNome(String nome);
    public Servico findById(Long id);
    
    @Query("select s from Servico s where s.nome like '%nomeServico%'")
    public List<Servico> buscarServicos(@Param("nomeServico")String nomeServico);
    
}
