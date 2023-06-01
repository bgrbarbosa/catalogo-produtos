package br.com.produtos.envio.publisher;

import br.com.produtos.envio.dto.ProdutoEventDto;
import br.com.produtos.envio.publisher.enums.ActionType;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProdutoPublisher {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value(value = "${produtos.broker.exchange.EventProdutos}")
    private String exchangeEvent;

    public void publisheProdutoEvent(ProdutoEventDto dto, ActionType actionType){
        dto.setActionType(actionType.toString());
        rabbitTemplate.convertAndSend(exchangeEvent, "", dto);
    }
}
