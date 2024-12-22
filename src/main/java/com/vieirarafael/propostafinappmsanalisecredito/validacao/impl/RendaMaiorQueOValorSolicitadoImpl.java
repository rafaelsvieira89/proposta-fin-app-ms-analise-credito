package com.vieirarafael.propostafinappmsanalisecredito.validacao.impl;

import com.vieirarafael.propostafinappmsanalisecredito.domain.Proposta;
import com.vieirarafael.propostafinappmsanalisecredito.validacao.RegraValidacao;
import org.springframework.stereotype.Component;

@Component
public class RendaMaiorQueOValorSolicitadoImpl implements RegraValidacao {
    @Override
    public int validar(Proposta proposta) {
        return validarRendaMaiorQueOValorSolicitado(proposta) ? 100 : 0;
    }

    private boolean validarRendaMaiorQueOValorSolicitado(Proposta proposta) {
        return proposta.getValorSolicitado().compareTo(proposta.getUsuario().getRenda()) < 0;
    }
}
