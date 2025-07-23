package br.com.mkanton.ordersapi.listener;

import br.com.mkanton.ordersapi.dto.OrderEvent;
import br.com.mkanton.ordersapi.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static br.com.mkanton.ordersapi.config.RabbitMqConfig.ORDER_QUEUE;

@Component
public class OrderListener {

    private static final Logger logger = LoggerFactory.getLogger(OrderListener.class);

    private final OrderService orderService;

    public OrderListener(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = ORDER_QUEUE)
    public void listenOrder(Message<OrderEvent>message) {

        logger.info("Received message: {}",message);

        orderService.saveOrder(message.getPayload());

    }
}
