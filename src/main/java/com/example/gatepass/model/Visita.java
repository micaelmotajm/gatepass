package com.example.gatepass.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "visitas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = "O nome do visitante é obrigatório")
    @Column(nullable = false)
    private String nomeVisitante;

    @NotBlank(message = "O setor visitado é obrigatório")
    @Column(nullable = false)
    private String setorVisitado;

    @NotBlank(message = "O motivo da visita é obrigatório")
    @Column(nullable = false)
    private String motivoVisita;

    @NotNull(message = "A data da visita é obrigatória")
    @PastOrPresent(message = "A data da visita deve ser igual ou anterior à data atual")
    @Column(nullable = false)
    private LocalDate dataVisita;
}
