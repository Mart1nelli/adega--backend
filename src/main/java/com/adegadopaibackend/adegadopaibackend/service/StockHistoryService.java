package com.adegadopaibackend.adegadopaibackend.service;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateStockHistoryRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.StockHistoryResponse;

import java.util.List;

public interface StockHistoryService {

    StockHistoryResponse create(Long productId, CreateStockHistoryRequest req);

    List<StockHistoryResponse> findByProductId(Long productId);
}
