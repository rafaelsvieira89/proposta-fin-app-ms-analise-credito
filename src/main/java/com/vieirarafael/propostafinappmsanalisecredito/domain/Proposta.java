package com.vieirarafael.propostafinappmsanalisecredito.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class Proposta {

    private Long id;

    private Double valorSolicitado;
    private int prazoPagamento;
    private Boolean aprovada;
    private boolean integrada;
    private String observacao;

    private Usuario usuario;
}
