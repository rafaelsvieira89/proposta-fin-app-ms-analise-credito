package com.vieirarafael.propostafinappmsanalisecredito.validacao.impl;

import com.vieirarafael.propostafinappmsanalisecredito.domain.Proposta;
import com.vieirarafael.propostafinappmsanalisecredito.exceptions.StrategyException;
import com.vieirarafael.propostafinappmsanalisecredito.validacao.RegraValidacao;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ValidarNomeNegativadoImpl implements RegraValidacao {
    @Override
    public int validar(Proposta proposta) {
        if (validarNomeNegativado()) throw new StrategyException("Nome negativado no Serasa");
        return 100;
    }

    public boolean validarNomeNegativado() {
        return new Random().nextBoolean();
    }
}
