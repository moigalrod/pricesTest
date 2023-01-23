package com.inditex.test.infrastracture.controller;

import com.inditex.test.aplication.PricesService;
import com.inditex.test.infrastracture.dto.PricesApplyRequestDTO;
import com.inditex.test.infrastracture.dto.PricesApplyResponseDTO;
import com.inditex.test.infrastracture.dto.PricesDTO;
import com.inditex.test.infrastracture.mapper.PricesApplyRequestDTOMapperService;
import com.inditex.test.infrastracture.mapper.PricesApplyResponseDTOMapperService;
import com.inditex.test.infrastracture.mapper.PricesDTOMapperService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "prices")
public class PricesController {

    private PricesService pricesService;
    private PricesDTOMapperService pricesDTOMapperService;
    private PricesApplyRequestDTOMapperService pricesApplyRequestDTOMapperService;
    private PricesApplyResponseDTOMapperService pricesApplyResponseDTOMapperService;

    @GetMapping
    public ResponseEntity<List<PricesDTO>> getAllPrices() {
        var res = pricesDTOMapperService.toListDTO(pricesService.findAll());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PricesDTO> getPriceById(@PathVariable("id") Long id) {
        var res = pricesDTOMapperService.toDTO(pricesService.findById(id));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PricesDTO> createPrice(@RequestBody PricesDTO price) {
        var res = pricesService.create(pricesDTOMapperService.toModel(price));
        return new ResponseEntity<>(pricesDTOMapperService.toDTO(res), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PricesDTO> updatePrice(@RequestBody PricesDTO price) {
        var res = pricesService.update(pricesDTOMapperService.toModel(price));
        return new ResponseEntity<>(pricesDTOMapperService.toDTO(res), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePriceById(@PathVariable("id") Long id) {
        pricesService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Caso de uso específico del test
    @PostMapping("/apply")
    public ResponseEntity<PricesApplyResponseDTO> applyPrice( @Valid @RequestBody PricesApplyRequestDTO request) {
        var res = pricesService.applyPrice(pricesApplyRequestDTOMapperService.toModel(request));
        return new ResponseEntity<>(pricesApplyResponseDTOMapperService.toDTO(res), HttpStatus.OK);
    }
}
