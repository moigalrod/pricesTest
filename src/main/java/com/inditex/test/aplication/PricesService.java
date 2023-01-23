package com.inditex.test.aplication;

import com.inditex.test.domain.Prices;
import com.inditex.test.domain.mapper.PricesApplyResponseMapperService;
import com.inditex.test.domain.mapper.PricesMapperService;
import com.inditex.test.domain.model.PricesApplyRequestModel;
import com.inditex.test.domain.model.PricesApplyResponseModel;
import com.inditex.test.domain.model.PricesModel;
import com.inditex.test.domain.repository.PricesRepository;
import com.inditex.test.infrastracture.exceptions.PricesNoResultException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Service
public class PricesService implements IPricesService {

    private static final String NOT_FOUND_PRICES = "No existe el precio";
    private static final String QUERY_APPLY = "select p from Prices p JOIN p.brand b where b.id = :brandId and p.productId = :productId " +
            "AND :applyDate >= p.startDate and :applyDate <= p.endDate order by p.priority desc";

    private PricesRepository pricesRepository;

    private PricesMapperService pricesMapperService;

    private PricesApplyResponseMapperService pricesApplyResponseMapperService;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PricesModel> findAll() {
        return pricesMapperService.toListModel(pricesRepository.findAll());
    }

    @Override
    public PricesModel findById(Long id) {
        return pricesMapperService.toModel(pricesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND_PRICES)));
    }

    @Override
    public void delete(Long id) {
        var optionalPrices = pricesRepository.findById(id);

        if (!optionalPrices.isPresent())
            throw new EntityNotFoundException(NOT_FOUND_PRICES);

        pricesRepository.deleteById(id);
    }

    @Override
    public PricesModel create(PricesModel price) {
        var pricesEntity = pricesMapperService.toEntity(price);
        validations(pricesEntity);
        return pricesMapperService.toModel(pricesRepository.save(pricesEntity));
    }

    @Override
    public PricesModel update(PricesModel price) {
        var optionalPrices = pricesRepository.findById(price.getId());

        if (!optionalPrices.isPresent())
            throw new EntityNotFoundException(NOT_FOUND_PRICES);

        var pricesEntity = pricesMapperService.toEntity(price);
        validations(pricesEntity);
        return pricesMapperService.toModel(pricesRepository.save(pricesEntity));
    }

    @Override
    public PricesApplyResponseModel applyPrice(PricesApplyRequestModel request) {
        TypedQuery<Prices> query = entityManager.createQuery(QUERY_APPLY, Prices.class);

        query.setParameter("brandId", request.getBrandId());
        query.setParameter("productId", request.getProductId());
        query.setParameter("applyDate", request.getApplyDate());
        query.setMaxResults(1);

        try {
            var resultApply = query.getSingleResult();
            return pricesApplyResponseMapperService.toModel(resultApply);
        } catch (NoResultException e) {
            throw new PricesNoResultException(request);
        }

    }
}
