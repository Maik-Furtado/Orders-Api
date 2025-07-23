package br.com.mkanton.ordersapi.controller;

import br.com.mkanton.ordersapi.controller.dto.OrderApiResponse;
import br.com.mkanton.ordersapi.controller.dto.OrderResponse;
import br.com.mkanton.ordersapi.controller.dto.PaginationResponse;
import br.com.mkanton.ordersapi.service.OrderService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsible for order-related endpoints.
 */
@RestController
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     *  Retrieves paginated orders for a specific customer.
     *
     * @param customerId Customer ID.
     * @param page Requested page (default 0).
     * @param pageSize Page size (default 10).
     * @return List of orders and pagination information.
     */
    @GetMapping("/customers/{customerId}/orders")
    public ResponseEntity<OrderApiResponse<OrderResponse>>ListOrders(@PathVariable("customerId")Long customerId, @RequestParam(name= "page",defaultValue = "0")Integer page,
                                                                     @RequestParam(name= "pageSize",defaultValue = "10")Integer pageSize){

        var pageResponse = orderService. findAllByCustomerId(customerId, PageRequest.of(page,pageSize));
        return ResponseEntity.ok(new OrderApiResponse<>(
                pageResponse.getContent(),
                PaginationResponse.fromPage(pageResponse)
        ));
    }


}
