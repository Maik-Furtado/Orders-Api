package br.com.mkanton.ordersapi.dto;

import java.util.List;

/**
 * DTO representing order data used in asynchronous events (e.g., RabbitMQ).
 */
public record OrderEvent(Long orderId, Long customerId, List<OrderItemEvent> items) {
}
