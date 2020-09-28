package br.com.guiabolso.controller;

import br.com.guiabolso.form.UsuarioForm;
import br.com.guiabolso.modelo.Transacao;
import br.com.guiabolso.modelo.Usuario;
import br.com.guiabolso.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("usuario")
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("Create usuario")
    public ResponseEntity<Usuario> create(@RequestBody UsuarioForm form){
        return service.create(form);
    }

    @GetMapping
    @ApiOperation("List All Usuarios")
    public ResponseEntity<List<Usuario>> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}/transactions")
    @ApiOperation("List Transaction")
    public ResponseEntity<List<Transacao>> listAllTransactions(@PathVariable Integer id){
        return service.listTransactions(id);
    }
}
