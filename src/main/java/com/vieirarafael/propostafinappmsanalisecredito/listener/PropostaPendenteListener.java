package com.vieirarafael.propostafinappmsanalisecredito.listener;

import com.vieirarafael.propostafinappmsanalisecredito.domain.Proposta;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class PropostaPendenteListener {


    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaPendente(Proposta proposta) {

        log.info(proposta.getObservacao());

    }
}
