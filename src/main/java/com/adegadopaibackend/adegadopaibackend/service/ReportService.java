package com.adegadopaibackend.adegadopaibackend.service;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateReportRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.ReportResponse;

import java.util.List;

public interface ReportService {

    ReportResponse create(CreateReportRequest req);

    List<ReportResponse> findAll();

    ReportResponse findById(Long id);

    List<ReportResponse> findByType(String type);
}
