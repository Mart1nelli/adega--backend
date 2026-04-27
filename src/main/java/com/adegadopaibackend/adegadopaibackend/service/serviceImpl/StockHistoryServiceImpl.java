package com.adegadopaibackend.adegadopaibackend.service.serviceImpl;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateStockHistoryRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.StockHistoryResponse;
import com.adegadopaibackend.adegadopaibackend.entity.Product;
import com.adegadopaibackend.adegadopaibackend.entity.StockHistory;
import com.adegadopaibackend.adegadopaibackend.mapper.StockHistoryMapper;
import com.adegadopaibackend.adegadopaibackend.repository.ProductRepository;
import com.adegadopaibackend.adegadopaibackend.repository.StockHistoryRepository;
import com.adegadopaibackend.adegadopaibackend.service.StockHistoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockHistoryServiceImpl implements StockHistoryService {

    private final StockHistoryRepository stockHistoryRepository;
    private final ProductRepository productRepository;
    private final StockHistoryMapper stockHistoryMapper;

    @Override
    @Transactional
    public StockHistoryResponse create(Long productId, CreateStockHistoryRequest req) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product with ID: " + productId + " not found"));

        StockHistory stockHistory = stockHistoryMapper.toEntity(req);
        stockHistory.setProduct(product);

        int newStock = product.getStock() + req.getChange();
        if (newStock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        product.setStock(newStock);
        productRepository.save(product);

        StockHistory saved = stockHistoryRepository.save(stockHistory);
        return stockHistoryMapper.toResponse(saved);
    }

    @Override
    public List<StockHistoryResponse> findByProductId(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new EntityNotFoundException("Product with ID: " + productId + " not found");
        }
        return stockHistoryMapper.toResponseList(stockHistoryRepository.findByProductIdOrderByCreatedAtDesc(productId));
    }
}
