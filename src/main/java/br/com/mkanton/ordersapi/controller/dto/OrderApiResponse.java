package br.com.mkanton.ordersapi.controller.dto;

import java.util.List;

/**
 * Standard API response structure containing data and pagination.
 *
 * @param items List of returned items.
 * @param pagination Pagination data.
 */
public record OrderApiResponse<T>(List<T> items, PaginationResponse pagination) {
}
