package br.com.guiabolso.service;

import br.com.guiabolso.form.TransacaoForm;
import br.com.guiabolso.form.UsuarioForm;
import br.com.guiabolso.modelo.Transacao;
import br.com.guiabolso.modelo.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioService {
    ResponseEntity<Usuario> create(UsuarioForm form);
    ResponseEntity<Transacao> createTransaction(Integer userId, TransacaoForm form);
    ResponseEntity<List<Usuario>> listAll();
    ResponseEntity<List<Transacao>> listTransactions(Integer userId);
}
