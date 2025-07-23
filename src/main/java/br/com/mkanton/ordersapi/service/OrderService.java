package br.com.mkanton.ordersapi.service;

import br.com.mkanton.ordersapi.controller.dto.OrderResponse;
import br.com.mkanton.ordersapi.dto.OrderEvent;
import br.com.mkanton.ordersapi.entity.OrderEntity;
import br.com.mkanton.ordersapi.entity.OrderItem;
import br.com.mkanton.ordersapi.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;

/**
 * Service responsible for order-related operations.
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }


    /**
     * Saves a new order based on the data from the received event.
     *
     * @param event Event with order data.
     */
    public void saveOrder(OrderEvent event){

        var entity = new OrderEntity();
        entity.setOrderId(event.orderId());
        entity.setCustomerId(event.customerId());
        entity.setTotal(getTotal(event));

        entity.setItems(event.items().stream()
                .map(i->new OrderItem(i.product(),i.quantity(),i.price())).toList());

        orderRepository.save(entity);
    }

    /**
     * Calculates the total amount for an order.
     *
     * @param event Event containing the order items.
     * @return Sum of the value of all items.
     */
    private BigDecimal getTotal(OrderEvent event) {
       return event.items().stream().map(i -> i.price().multiply(BigDecimal.valueOf(i.quantity()))).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    /**
     * Returns a page of orders placed by a customer.
     *
     * @param customerId Customer ID.
     * @param pageRequest Object with pagination.
     * @return Page with the customer's orders.
     */
    public Page<OrderResponse> findAllByCustomerId(Long customerId, PageRequest pageRequest){
        var orders = orderRepository.findAllByCustomerId(customerId,pageRequest);
        return orders.map(OrderResponse::fromEntity);
    }

}
