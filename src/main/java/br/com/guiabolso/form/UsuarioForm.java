package br.com.guiabolso.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioForm {
    @Positive
    @Size(min = 1000, max = 1000000000)
    private Integer id;

    @NotEmpty
    private LocalDate dtNascimento;
}
