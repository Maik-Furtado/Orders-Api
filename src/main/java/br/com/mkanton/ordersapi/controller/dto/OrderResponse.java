package br.com.mkanton.ordersapi.controller.dto;

import br.com.mkanton.ordersapi.entity.OrderEntity;

import java.math.BigDecimal;

/**
 * DTO used to return order data via API.
 *
 * @param orderId Order ID.
 * @param customerId Customer ID.
 * @param total Total order amount.
 */
public record OrderResponse(Long orderId, Long customerId, BigDecimal total) {

    /**
     * Converts an {@link OrderEntity} entity to {@link OrderResponse}.
     *
     * @param entity Order entity.
     * @return DTO with order data.
     */
    public static OrderResponse fromEntity(OrderEntity entity){
        return new OrderResponse(entity.getOrderId(), entity.getCustomerId(),entity.getTotal());
    }
}
