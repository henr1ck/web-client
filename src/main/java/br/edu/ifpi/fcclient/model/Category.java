package br.edu.ifpi.fcclient.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {

    @NotNull @Positive
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    private String name;
}
