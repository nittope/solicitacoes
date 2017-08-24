/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.ui;

import br.com.hmv.servicos.entidade.Setor;
import br.com.hmv.servicos.exception.SetorExistenteException;
import br.com.hmv.servicos.exception.SetorInexistenteException;
import br.com.hmv.servicos.listar.SetorListar;
import br.com.hmv.servicos.negocio.FachadaServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author vinim
 */
@Controller
@RequestMapping("/setor")
public class ControllerSetor {
    
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ControllerSetor.class);
    
    @Autowired
    private FachadaServico fachada;
    
    @RequestMapping(value = "/listar", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<SetorListar> listarTodos(){
         return fachada.listarTodosSetor();
    }
    
    
    @RequestMapping(value = "/consultarPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<SetorListar> consultarPorId(Long id){
        try{
            return fachada.ConsultarSetorPorID(id);
        } catch (SetorInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/cadastrar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> adicionarSetor(Setor setor) {
        try {
            fachada.cadastrarSetor(setor);
            return new ResponseEntity<String>(HttpStatus.OK);
        }  catch (SetorExistenteException ex1) {
            return new ResponseEntity<SetorExistenteException>(ex1, HttpStatus.BAD_REQUEST);
        } catch (SetorInexistenteException ex2) {
            return new ResponseEntity<SetorInexistenteException>(ex2, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/atualizar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> atualizarSetor(Setor setor) {
        try {
            fachada.atualizarSetor(setor);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (SetorInexistenteException ex) {
            return new ResponseEntity<SetorInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @RequestMapping(value = "/deletar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> deletarSetor(Setor setor) {
        try {
            fachada.removerSetor(setor);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (SetorInexistenteException ex) {
            return new ResponseEntity<SetorInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
    
}
