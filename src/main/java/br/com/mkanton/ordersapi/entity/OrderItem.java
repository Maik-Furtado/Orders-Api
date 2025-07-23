package br.com.mkanton.ordersapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;

/**
 * Represents an individual item within an order.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    private String product;

    private Integer quantity;

    /** Unit price of the product. */
    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal price;

}
