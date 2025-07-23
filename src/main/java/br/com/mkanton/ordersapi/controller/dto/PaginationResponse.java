package br.com.mkanton.ordersapi.controller.dto;

import org.springframework.data.domain.Page;

/**
 * Represents pagination information for a paginated API response.
 *
 * @param page Current page number.
 * @param pageSize Page size.
 * @param totalElements Total number of elements found.
 * @param totalPages Total number of pages.
 */
public record PaginationResponse(Integer page, Integer pageSize, Long totalElements, Integer totalPages) {

    /**
     * Builds a {@link PaginationResponse} from a Spring {@link Page}.
     *
     * @param page Spring Data Page.
     * @return DTO with pagination data.
     */
    public static PaginationResponse fromPage(Page<?> page){
        return new PaginationResponse(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }
}
