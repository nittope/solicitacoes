/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.ui;

import br.com.hmv.servicos.entidade.Motivos;
import br.com.hmv.servicos.exception.MotivosExistenteException;
import br.com.hmv.servicos.exception.MotivosInexistenteException;
import br.com.hmv.servicos.listar.MotivosListar;
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
@RequestMapping("/motivo")
public class ControllerMotivo {
    
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ControllerMotivo.class);
    
    @Autowired
    private FachadaServico fachada;
    
    @RequestMapping(value = "/listar", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<MotivosListar> listarTodos(){
         return fachada.listarTodosMotivos();
    }
    
    
    @RequestMapping(value = "/consultarPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<MotivosListar> consultarPorId(Long id){
        try{
            return fachada.ConsultarMotivosPorID(id);
        } catch (MotivosInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/cadastrar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> adicionarMotivo(Motivos motivos) {
        try {
            fachada.cadastrarMotivos(motivos);
            return new ResponseEntity<String>(HttpStatus.OK);
        }  catch (MotivosExistenteException ex1) {
            return new ResponseEntity<MotivosExistenteException>(ex1, HttpStatus.BAD_REQUEST);
        } catch (MotivosInexistenteException ex2) {
            return new ResponseEntity<MotivosInexistenteException>(ex2, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/atualizar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> atualizarMotivo(Motivos motivos) {
        try {
            fachada.atualizarMotivos(motivos);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (MotivosInexistenteException ex) {
            return new ResponseEntity<MotivosInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @RequestMapping(value = "/deletar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> deletarMotivo(Motivos motivos) {
        try {
            fachada.removerMotivos(motivos);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (MotivosInexistenteException ex) {
            return new ResponseEntity<MotivosInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
    
}
