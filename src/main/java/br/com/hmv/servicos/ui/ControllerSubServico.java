/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.ui;

import br.com.hmv.servicos.entidade.SubServico;
import br.com.hmv.servicos.exception.ServicoInexistenteException;
import br.com.hmv.servicos.exception.SubServicoExistenteException;
import br.com.hmv.servicos.exception.SubServicoInexistenteException;
import br.com.hmv.servicos.listar.ServicoListar;
import br.com.hmv.servicos.listar.SubServicoListar;
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
@RequestMapping("/subservico")
public class ControllerSubServico {
    
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ControllerSubServico.class);
    
    @Autowired
    private FachadaServico fachada;
    
    @RequestMapping(value = "/listar", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<SubServicoListar> listarTodos(){
         return fachada.listarTodosSubServico();
    }
    
        
    @RequestMapping(value = "/consultarPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<SubServicoListar> consultarPorId(Long id){
        try{
            return fachada.ConsultarSubServicoPorID(id);
        } catch (SubServicoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/cadastrar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> adicionarSubServico(SubServico subServico, Long idServico) {
        try {
            fachada.cadastrarSubServico(subServico, idServico);
            return new ResponseEntity<String>(HttpStatus.OK);
        }  catch (ServicoInexistenteException ex) {
            return new ResponseEntity<ServicoInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }catch (SubServicoExistenteException ex1) {
            return new ResponseEntity<SubServicoExistenteException>(ex1, HttpStatus.BAD_REQUEST);
        } catch (SubServicoInexistenteException ex2) {
            return new ResponseEntity<SubServicoInexistenteException>(ex2, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/atualizar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> atualizarSubServico(SubServico subServico, Long idServico) {
        try {
            fachada.atualizarSubServico(subServico, idServico);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (SubServicoInexistenteException ex) {
            return new ResponseEntity<SubServicoInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }catch (ServicoInexistenteException ex1) {
            return new ResponseEntity<ServicoInexistenteException>(ex1, HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @RequestMapping(value = "/deletar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> deletarSubServico(SubServico subServico) {
        try {
            fachada.removerSubServico(subServico);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (SubServicoInexistenteException ex) {
            return new ResponseEntity<SubServicoInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }    
    
    
    @RequestMapping(value = "/consultarServicoPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<ServicoListar> consultarServicoPorId(Long id){
        try{
            return fachada.ConsultarServicoPorID(id);
        } catch (ServicoInexistenteException ex) {
            return null;
        }
    }
    
     //---------------------------------------------------------------------
}