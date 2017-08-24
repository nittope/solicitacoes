/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.persistencia;

import br.com.hmv.servicos.entidade.Motivos;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author vinim
 */
public interface RepositorioMotivos extends CrudRepository<Motivos, Long> {
    
    public Motivos findByNome(String nome);
    public Motivos findById(Long id);
    
    @Query("select m from Motivos m where m.nome like '%nomeMotivo%'")
    public List<Motivos> buscarMotivos(@Param("nomeMotivo")String nomeMotivo);
}
