package com.vieirarafael.propostafinappmsanalisecredito.validacao;

import com.vieirarafael.propostafinappmsanalisecredito.domain.Proposta;


public interface RegraValidacao {
    int validar(Proposta proposta);
}
