/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hmv.servicos.ui;

import br.com.hmv.servicos.entidade.Solicitacao;
import br.com.hmv.servicos.exception.MotivosInexistenteException;
import br.com.hmv.servicos.exception.ServicoInexistenteException;
import br.com.hmv.servicos.exception.SetorInexistenteException;
import br.com.hmv.servicos.exception.SolicitacaoExistenteException;
import br.com.hmv.servicos.exception.SolicitacaoInexistenteException;
import br.com.hmv.servicos.exception.SubServicoInexistenteException;
import br.com.hmv.servicos.exception.UsuarioInexistenteException;
import br.com.hmv.servicos.listar.MotivosListar;
import br.com.hmv.servicos.listar.ServicoListar;
import br.com.hmv.servicos.listar.SetorListar;
import br.com.hmv.servicos.listar.SolicitacaoListar;
import br.com.hmv.servicos.listar.SubServicoListar;
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
@RequestMapping("/solicitacao")
public class ControllerSolicitacao {
    
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ControllerSolicitacao.class);
    
    @Autowired
    private FachadaServico fachada;
    
    @RequestMapping(value = "/listar", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<SolicitacaoListar> listarTodos(){
         return fachada.listarTodosSolicitacao();
    }
    
    @RequestMapping(value = "/consultarPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<SolicitacaoListar> consultarPorId(Long id){
        try{
            return fachada.ConsultarSolicitacaoPorID(id);
        } catch (SolicitacaoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/cadastrar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> adicionarSolicitacao(Solicitacao solicitacao, Long idSubServico, Long idServico, Long idMotivo, Long idSetorDe, Long idSetorPara, Long idUsuario) {
        try {
            fachada.cadastrarSolicitacao(solicitacao, idSubServico, idServico, idMotivo, idSetorDe, idSetorPara, idUsuario);
            return new ResponseEntity<String>(HttpStatus.OK);
        }  catch (SubServicoInexistenteException ex) {
            return new ResponseEntity<SubServicoInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }  catch (ServicoInexistenteException ex1) {
            return new ResponseEntity<ServicoInexistenteException>(ex1, HttpStatus.BAD_REQUEST);
        }  catch (MotivosInexistenteException ex2) {
            return new ResponseEntity<MotivosInexistenteException>(ex2, HttpStatus.BAD_REQUEST);
        }  catch (SetorInexistenteException ex3) {
            return new ResponseEntity<SetorInexistenteException>(ex3, HttpStatus.BAD_REQUEST);
        }  catch (UsuarioInexistenteException ex4) {
            return new ResponseEntity<UsuarioInexistenteException>(ex4, HttpStatus.BAD_REQUEST);
        }catch (SolicitacaoExistenteException ex5) {
            return new ResponseEntity<SolicitacaoExistenteException>(ex5, HttpStatus.BAD_REQUEST);
        } catch (SolicitacaoInexistenteException ex6) {
            return new ResponseEntity<SolicitacaoInexistenteException>(ex6, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/atualizar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> atualizarSolicitacao(Solicitacao solicitacao, Long idSubServico, Long idServico, Long idMotivo, Long idSetorDe, Long idSetorPara, Long idUsuario) {
        try {
            fachada.atualizarSolicitacao(solicitacao, idSubServico, idServico, idMotivo, idSetorDe, idSetorPara, idUsuario);
            return new ResponseEntity<String>(HttpStatus.OK);
        }  catch (SubServicoInexistenteException ex) {
            return new ResponseEntity<SubServicoInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }  catch (ServicoInexistenteException ex1) {
            return new ResponseEntity<ServicoInexistenteException>(ex1, HttpStatus.BAD_REQUEST);
        }  catch (MotivosInexistenteException ex2) {
            return new ResponseEntity<MotivosInexistenteException>(ex2, HttpStatus.BAD_REQUEST);
        }  catch (SetorInexistenteException ex3) {
            return new ResponseEntity<SetorInexistenteException>(ex3, HttpStatus.BAD_REQUEST);
        }  catch (UsuarioInexistenteException ex4) {
            return new ResponseEntity<UsuarioInexistenteException>(ex4, HttpStatus.BAD_REQUEST);
        }catch (SolicitacaoInexistenteException ex5) {
            return new ResponseEntity<SolicitacaoInexistenteException>(ex5, HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @RequestMapping(value = "/consultarSubServicoPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<SubServicoListar> consultarSubServicoPorId(Long id){
        try{
            return fachada.ConsultarSubServicoPorID(id);
        } catch (SubServicoInexistenteException ex) {
            return null;
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
    
    @RequestMapping(value = "/consultarUsuarioPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<UsuarioListar> consultarUsuarioPorId(Long id){
        try{
            return fachada.ConsultarUsuarioPorID(id);
        } catch (UsuarioInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultarMotivoPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<MotivosListar> consultarMotivoPorId(Long id){
        try{
            return fachada.ConsultarMotivosPorID(id);
        } catch (MotivosInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultarSetorPorId", headers="Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<SetorListar> consultarSetorPorId(Long id){
        try{
            return fachada.ConsultarSetorPorID(id);
        } catch (SetorInexistenteException ex) {
            return null;
        }
    }
}
