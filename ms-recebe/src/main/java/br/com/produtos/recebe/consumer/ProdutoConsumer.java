package br.com.produtos.recebe.consumer;

import br.com.produtos.recebe.consumer.enums.ActionType;
import br.com.produtos.recebe.dto.ProdutoEventDto;
import br.com.produtos.recebe.entity.Produto;
import br.com.produtos.recebe.service.ProdutoService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProdutoConsumer {

    @Autowired
    ProdutoService service;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value =       "${produtos.broker.queue.msRecebeQueue.name}", durable = "true"),
            exchange = @Exchange(value = "${produtos.broker.exchange.EventProdutos}", type = ExchangeTypes.FANOUT)))
    public void ProdutoEvent(@Payload ProdutoEventDto dto){
        var produto = new Produto();
        BeanUtils.copyProperties(dto, produto);
        switch (ActionType.valueOf(dto.getActionType())){
            case CREATE:
                service.insertProduto(produto);
                break;
            case UPDATE:
                service.updateProduto(produto);
                break;
            case DELETE:
                service.deleteProduto(produto.getIdProduto());
                break;
        }
    }
}
