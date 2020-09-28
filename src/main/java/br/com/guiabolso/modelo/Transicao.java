package br.com.guiabolso.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Transicao {
    private String nome;
    private Double valor;
    private LocalDate data;
}
