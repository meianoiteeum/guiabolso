package br.com.guiabolso.controller;

import br.com.guiabolso.form.TransacaoForm;
import br.com.guiabolso.modelo.Transacao;
import br.com.guiabolso.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("transacao")
@RequestMapping("/transacao")
public class TransacaoController {
    @Autowired
    private UsuarioService service;

    @PostMapping
    @ApiOperation("Create Transaction for User")
    public ResponseEntity<Transacao> create(@RequestBody TransacaoForm form, @RequestParam Integer userId){
        return service.createTransaction(userId,form);
    }
}
