package br.com.guiabolso.service.impl;

import br.com.guiabolso.exceptions.ErrosExceptions;
import br.com.guiabolso.form.TransacaoForm;
import br.com.guiabolso.form.UsuarioForm;
import br.com.guiabolso.modelo.Transacao;
import br.com.guiabolso.modelo.Usuario;
import br.com.guiabolso.repository.UsuarioRepository;
import br.com.guiabolso.service.UsuarioService;
import br.com.guiabolso.utils.DateUtils;
import br.com.guiabolso.utils.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private UsuarioRepository repository;

    public UsuarioServiceImpl() {
        repository = new UsuarioRepository();
    }

    @Override
    public ResponseEntity<List<Transacao>> listTransactions(Integer userId) {
        Optional<Usuario> op = repository.getUsuario(userId);
        if(op.isPresent())
            return ResponseEntity.ok(op.get().getTransacoes());
        return ErrosExceptions.notFound("Transação do usuário não encontrada","A transação não foi encontrada no banco de dados");
    }

    @Override
    public ResponseEntity<Transacao> createTransaction(Integer userId, TransacaoForm form) {
        Optional<Usuario> op = repository.getUsuario(userId);
        if(!op.isPresent())
            return ErrosExceptions.notFound("Usuário não encontrado", "Usuário não foi encontrado no banco de dados");

        String descricao = new StringUtils().getDescricao();

        Transacao transacao = new Transacao();
        try {
            transacao.setValor(convertToDouble(form.getValor()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(repository.existTransacaoByName(userId, descricao))
            transacao.setDuplicated(true);
        else
            transacao.setDuplicated(false);

        transacao.setData(DateUtils.timestamp());

        op.get().getTransacoes().add(transacao);

        return ResponseEntity.ok(transacao);
    }

    @Override
    public ResponseEntity<Usuario> create(UsuarioForm form) {
        Usuario usuario = new ModelMapper().map(form, Usuario.class);
        return ResponseEntity.ok(repository.save(usuario));
    }

    @Override
    public ResponseEntity<List<Usuario>> listAll() {
        return ResponseEntity.ok(repository.getUsuarios());
    }

    private Double convertToDouble(Integer valor) throws ParseException {
        String sValor = String.valueOf(valor);
        String cents = "";
        if(sValor.length() == 1)
            cents.concat("0.0").concat(sValor);
        else if(sValor.length() == 2) {
            cents.concat("0.0").concat(sValor.substring((sValor.length() - 2), cents.length()));
        }else {
            cents.concat(sValor.substring(0, sValor.length()-2)).concat(sValor.substring((sValor.length() - 2), cents.length()));
        }
        return DecimalFormat.getNumberInstance().parse(cents).doubleValue();
    }
}
