package br.com.mkanton.ordersapi.dto;

import java.math.BigDecimal;

/**
 * DTO representing an order item in asynchronous events.
 */
public record OrderItemEvent(String product, Integer quantity, BigDecimal price) {
}
