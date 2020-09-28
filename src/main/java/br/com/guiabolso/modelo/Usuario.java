package br.com.guiabolso.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Usuario {
    private Integer id;
    private LocalDate dtNascimento;
    private List<Transicao> transicoes;
}
