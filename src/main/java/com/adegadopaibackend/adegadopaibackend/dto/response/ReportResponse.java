package com.adegadopaibackend.adegadopaibackend.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReportResponse {

    private Long id;

    private String title;

    private String type;

    private String data;
}
