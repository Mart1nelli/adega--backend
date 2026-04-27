package com.adegadopaibackend.adegadopaibackend.mapper;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateStockHistoryRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.StockHistoryResponse;
import com.adegadopaibackend.adegadopaibackend.entity.StockHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StockHistoryMapper {

    StockHistoryResponse toResponse(StockHistory history);

    List<StockHistoryResponse> toResponseList(List<StockHistory> histories);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "product", ignore = true)
    StockHistory toEntity(CreateStockHistoryRequest request);
}