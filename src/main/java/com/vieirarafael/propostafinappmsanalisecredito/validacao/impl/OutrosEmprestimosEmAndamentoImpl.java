package com.vieirarafael.propostafinappmsanalisecredito.validacao.impl;

import com.vieirarafael.propostafinappmsanalisecredito.domain.Proposta;
import com.vieirarafael.propostafinappmsanalisecredito.validacao.RegraValidacao;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OutrosEmprestimosEmAndamentoImpl implements RegraValidacao {
    @Override
    public int validar(Proposta proposta) {
        return validarOutrosEmprestimosEmAndamento() ? 0 : 100;
    }

    public boolean validarOutrosEmprestimosEmAndamento() {
        return new Random().nextBoolean();
    }
}
