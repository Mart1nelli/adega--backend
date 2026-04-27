package com.adegadopaibackend.adegadopaibackend.mapper;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateReportRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.ReportResponse;
import com.adegadopaibackend.adegadopaibackend.entity.Report;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    ReportResponse toResponse(Report report);

    List<ReportResponse> toResponseList(List<Report> reports);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "generatedAt", ignore = true)
    Report toEntity(CreateReportRequest request);
}
