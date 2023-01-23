package com.inditex.test;

import com.inditex.test.infrastracture.controller.PricesController;
import com.inditex.test.infrastracture.dto.PricesApplyRequestDTO;
import com.inditex.test.infrastracture.exceptions.PricesNoResultException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class TestApplicationTests {
    @Autowired
    private PricesController pricesController;

    @Test
    @DisplayName("petición a las 10:00 del día 14 del producto 35455  para la brand 1 (ZARA)")
    public void test1() throws Exception {
        var request = PricesApplyRequestDTO.builder()
                .brandId(1L)
                .productId(35455L)
                .applyDate(LocalDateTime.of(2020, 6, 14, 10, 0, 0))
                .build();

        var response = pricesController.applyPrice(request);
        var pricesApplyResponse = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(request.getBrandId(), pricesApplyResponse.getBrandId());
        assertEquals(request.getProductId(), pricesApplyResponse.getProductId());
        assertEquals(LocalDateTime.of(2020, 6, 14, 0, 0, 0), pricesApplyResponse.getStartDate());
        assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59, 59), pricesApplyResponse.getEndDate());
        assertEquals(1L, pricesApplyResponse.getPriceList());
        assertEquals(new BigDecimal("35.50"), pricesApplyResponse.getPrice());
    }

    @Test
    @DisplayName("petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    public void test2() {
        var request = PricesApplyRequestDTO.builder()
                .brandId(1L)
                .productId(35455L)
                .applyDate(LocalDateTime.of(2020, 6, 14, 16, 0, 0))
                .build();

        var response = pricesController.applyPrice(request);
        var pricesApplyResponse = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(request.getBrandId(), pricesApplyResponse.getBrandId());
        assertEquals(request.getProductId(), pricesApplyResponse.getProductId());
        assertEquals(LocalDateTime.of(2020, 6, 14, 15, 0, 0), pricesApplyResponse.getStartDate());
        assertEquals(LocalDateTime.of(2020, 6, 14, 18, 30, 00), pricesApplyResponse.getEndDate());
        assertEquals(2L, pricesApplyResponse.getPriceList());
        assertEquals(new BigDecimal("25.45"), pricesApplyResponse.getPrice());
    }

    @Test
    @DisplayName("petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    public void test3() {
        var request = PricesApplyRequestDTO.builder()
                .brandId(1L)
                .productId(35455L)
                .applyDate(LocalDateTime.of(2020, 6, 14, 21, 0, 0))
                .build();

        var response = pricesController.applyPrice(request);
        var pricesApplyResponse = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(request.getBrandId(), pricesApplyResponse.getBrandId());
        assertEquals(request.getProductId(), pricesApplyResponse.getProductId());
        assertEquals(LocalDateTime.of(2020, 6, 14, 00, 0, 0), pricesApplyResponse.getStartDate());
        assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59, 59), pricesApplyResponse.getEndDate());
        assertEquals(1L, pricesApplyResponse.getPriceList());
        assertEquals(new BigDecimal("35.50"), pricesApplyResponse.getPrice());
    }

    @Test
    @DisplayName("petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)")
    public void test4() {
        var request = PricesApplyRequestDTO.builder()
                .brandId(1L)
                .productId(35455L)
                .applyDate(LocalDateTime.of(2020, 6, 15, 10, 0, 0))
                .build();

        var response = pricesController.applyPrice(request);
        var pricesApplyResponse = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(request.getBrandId(), pricesApplyResponse.getBrandId());
        assertEquals(request.getProductId(), pricesApplyResponse.getProductId());
        assertEquals(LocalDateTime.of(2020, 6, 15, 00, 0, 0), pricesApplyResponse.getStartDate());
        assertEquals(LocalDateTime.of(2020, 6, 15, 11, 00, 00), pricesApplyResponse.getEndDate());
        assertEquals(3L, pricesApplyResponse.getPriceList());
        assertEquals(new BigDecimal("30.50"), pricesApplyResponse.getPrice());
    }

    @Test
    @DisplayName("petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)")
    public void test5() {
        var request = PricesApplyRequestDTO.builder()
                .brandId(1L)
                .productId(35455L)
                .applyDate(LocalDateTime.of(2020, 6, 16, 21, 0, 0))
                .build();

        var response = pricesController.applyPrice(request);
        var pricesApplyResponse = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(request.getBrandId(), pricesApplyResponse.getBrandId());
        assertEquals(request.getProductId(), pricesApplyResponse.getProductId());
        assertEquals(LocalDateTime.of(2020, 6, 15, 16, 0, 0), pricesApplyResponse.getStartDate());
        assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59, 59), pricesApplyResponse.getEndDate());
        assertEquals(4L, pricesApplyResponse.getPriceList());
        assertEquals(new BigDecimal("38.95"), pricesApplyResponse.getPrice());
    }

    @Test
    @DisplayName("petición a las 21:00 del día 10 del producto 35455   para la brand 1 (ZARA)")
    public void test6() {
        var request = PricesApplyRequestDTO.builder()
                .brandId(1L)
                .productId(35455L)
                .applyDate(LocalDateTime.of(2020, 6, 10, 21, 0, 0))
                .build();
        assertThrows(PricesNoResultException.class, () -> pricesController.applyPrice(request));
    }
}
