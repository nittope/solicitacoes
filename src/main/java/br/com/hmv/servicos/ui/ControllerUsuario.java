/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.ui;

import br.com.hmv.servicos.entidade.Usuario;
import br.com.hmv.servicos.exception.UsuarioExistenteException;
import br.com.hmv.servicos.exception.UsuarioInexistenteException;
import br.com.hmv.servicos.listar.UsuarioListar;
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
@RequestMapping("/usuario")
public class ControllerUsuario {
    
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ControllerUsuario.class);
    
    @Autowired
    private FachadaServico fachada;
    
    @RequestMapping(value = "/listar", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<UsuarioListar> listarTodos(){
         return fachada.listarTodosUsuario();
    }
    
    
    @RequestMapping(value = "/consultarPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<UsuarioListar> consultarPorId(Long id){
        try{
            return fachada.ConsultarUsuarioPorID(id);
        } catch (UsuarioInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/cadastrar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> adicionarUsuario(Usuario usuario) {
        try {
            fachada.cadastrarUsuario(usuario);
            return new ResponseEntity<String>(HttpStatus.OK);
        }  catch (UsuarioExistenteException ex1) {
            return new ResponseEntity<UsuarioExistenteException>(ex1, HttpStatus.BAD_REQUEST);
        } catch (UsuarioInexistenteException ex2) {
            return new ResponseEntity<UsuarioInexistenteException>(ex2, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/atualizar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> atualizarUsuario(Usuario usuario) {
        try {
            fachada.atualizarUsuario(usuario);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (UsuarioInexistenteException ex) {
            return new ResponseEntity<UsuarioInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @RequestMapping(value = "/deletar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> deletarUsuario(Usuario usuario) {
        try {
            fachada.removerUsuario(usuario);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (UsuarioInexistenteException ex) {
            return new ResponseEntity<UsuarioInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
   
}
