package com.adegadopaibackend.adegadopaibackend.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class StockHistoryResponse {

    private Long id;

    private Integer change;

    private String reason;

    private LocalDateTime createdAt;
}
