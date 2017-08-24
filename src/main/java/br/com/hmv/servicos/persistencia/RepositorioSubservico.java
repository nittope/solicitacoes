/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.persistencia;

import br.com.hmv.servicos.entidade.SubServico;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author vinim
 */
public interface RepositorioSubservico extends CrudRepository<SubServico, Long>{
    
    public SubServico findByNome(String nome);
    public SubServico findById(Long id);
    
    @Query("select s from SubServico s where s.nome like '%nomeSubServico%'")
    public List<SubServico> buscarSubServicos(@Param("nomeSubServico")String nomeSubServico);
    
}
