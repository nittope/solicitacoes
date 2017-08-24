/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.ui;

import br.com.hmv.servicos.entidade.Servico;
import br.com.hmv.servicos.exception.ServicoExistenteException;
import br.com.hmv.servicos.exception.ServicoInexistenteException;
import br.com.hmv.servicos.listar.ServicoListar;
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
@RequestMapping("/servico")
public class ControllerServico {
    
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ControllerServico.class);
    
    @Autowired
    private FachadaServico fachada;
    
    @RequestMapping(value = "/listar", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<ServicoListar> listarTodos(){
         return fachada.listarTodosServico();
    }
    
    
    @RequestMapping(value = "/consultarPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<ServicoListar> consultarPorId(Long id){
        try{
            return fachada.ConsultarServicoPorID(id);
        } catch (ServicoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/cadastrar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> adicionarServico(Servico servico) {
        try {
            fachada.cadastrarServico(servico);
            return new ResponseEntity<String>(HttpStatus.OK);
        }  catch (ServicoExistenteException ex1) {
            return new ResponseEntity<ServicoExistenteException>(ex1, HttpStatus.BAD_REQUEST);
        } catch (ServicoInexistenteException ex2) {
            return new ResponseEntity<ServicoInexistenteException>(ex2, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/atualizar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> atualizarServico(Servico servico) {
        try {
            fachada.atualizarServico(servico);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (ServicoInexistenteException ex) {
            return new ResponseEntity<ServicoInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @RequestMapping(value = "/deletar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> deletarServico(Servico servico) {
        try {
            fachada.removerServico(servico);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (ServicoInexistenteException ex) {
            return new ResponseEntity<ServicoInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
    
}
