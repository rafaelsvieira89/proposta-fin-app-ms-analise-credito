package com.vieirarafael.propostafinappmsanalisecredito.validacao.impl;

import com.vieirarafael.propostafinappmsanalisecredito.domain.Proposta;
import com.vieirarafael.propostafinappmsanalisecredito.exceptions.StrategyException;
import com.vieirarafael.propostafinappmsanalisecredito.validacao.RegraValidacao;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ValidarScoreSerasaImpl implements RegraValidacao {
    @Override
    public int validar(Proposta proposta) {
        var score = scoreSerasa(proposta);
        if (score < 200) throw new StrategyException("Score abaixo de 200 no Serasa");
        if(score < 400)
            return 150;
        if (score < 600)
            return 180;
        return 220;
    }

    private int scoreSerasa(Proposta proposta) {
        return new Random().nextInt(0, 1000);
    }
}
