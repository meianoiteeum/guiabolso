package br.com.guiabolso.repository;

import br.com.guiabolso.modelo.Transacao;
import br.com.guiabolso.modelo.Usuario;
import br.com.guiabolso.utils.DateUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class UsuarioRepository {
    private List<Usuario> usuarios;
    private static final int MINIMO = 1000;
    private static final int MAXIMO = 1000000000;

    public UsuarioRepository() {
        usuarios = new ArrayList<>();
        addUsers();
    }

    public Usuario save(Usuario usuario){
        usuarios.add(usuario);
        return usuario;
    }

    public List<Usuario> getUsuarios(){
        return usuarios;
    }

    public boolean remove(Usuario usuario){
        return usuarios.remove(usuario);
    }

    public Optional<Usuario> getUsuario(Integer id){
        Usuario user = usuarios.stream().filter(usuario -> usuario.getId().equals(id)).collect(Collectors.toList()).get(0);
        return Optional.of(user);
    }

    public Optional<Usuario> getOne(){
        return Optional.of(usuarios.get(0));
    }

    public boolean removeById(Integer id){
        Usuario user = usuarios.stream().filter(usuario -> usuario.getId().equals(id)).collect(Collectors.toList()).get(0);
        return usuarios.remove(user);
    }

    public boolean existTransacaoByName(Integer userId, String nome){
        List<Transacao> transacoes = getUsuario(userId).get().getTransacoes();
        return transacoes.stream().filter(transacao -> transacao.getNome().equals(nome)).collect(Collectors.toList()).isEmpty();
    }

    private void addUsers(){
        List<Transacao> transicoes1 = new ArrayList<>();
        transicoes1.add(new Transacao("G Transaction",10.0, DateUtils.timestamp(), false));
        transicoes1.add(new Transacao("U Transaction",11.0, DateUtils.timestamp(), false));
        transicoes1.add(new Transacao("I Transaction",13.0, DateUtils.timestamp(), false));

        List<Transacao> transicoes2 = new ArrayList<>();
        transicoes2.add(new Transacao("L Transaction",12.0, DateUtils.timestamp(), false));
        transicoes2.add(new Transacao("H Transaction",16.0, DateUtils.timestamp(), false));
        transicoes2.add(new Transacao("E Transaction",15.0, DateUtils.timestamp(), false));

        List<Transacao> transicoes3 = new ArrayList<>();
        transicoes3.add(new Transacao("R Transaction",9.0, DateUtils.timestamp(), false));
        transicoes3.add(new Transacao("M Transaction",1.0, DateUtils.timestamp(), false));
        transicoes3.add(new Transacao("E Transaction",13.0, DateUtils.timestamp(), false));

        List<Transacao> transicoes4 = new ArrayList<>();
        transicoes4.add(new Transacao("L Transaction",5.0, DateUtils.timestamp(), false));
        transicoes4.add(new Transacao("U Transaction",8.0, DateUtils.timestamp(), false));
        transicoes4.add(new Transacao("C Transaction",18.0, DateUtils.timestamp(), false));

        List<Transacao> transicoes5 = new ArrayList<>();
        transicoes5.add(new Transacao("A Transaction",12.0, DateUtils.timestamp(), false));
        transicoes5.add(new Transacao("S Transaction",20.0, DateUtils.timestamp(), false));
        transicoes5.add(new Transacao("D Transaction",13.0, DateUtils.timestamp(), false));

        Usuario usuario1 = new Usuario(getId(), LocalDate.now(),transicoes1);
        Usuario usuario2 = new Usuario(getId(), LocalDate.now(),transicoes2);
        Usuario usuario3 = new Usuario(getId(), LocalDate.now(),transicoes3);
        Usuario usuario4 = new Usuario(getId(), LocalDate.now(),transicoes4);
        Usuario usuario5 = new Usuario(getId(), LocalDate.now(),transicoes5);

        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);
        usuarios.add(usuario5);
    }

    public int getId() {
        return new Random().nextInt((MAXIMO - MINIMO) + 1) + MINIMO;
    }
}
