package com.adegadopaibackend.adegadopaibackend.mapper;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreatePaymentMethodRequest;
import com.adegadopaibackend.adegadopaibackend.dto.request.UpdatePaymentMethodRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.PaymentMethodResponse;
import com.adegadopaibackend.adegadopaibackend.entity.PaymentMethod;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {

    PaymentMethodResponse toResponse(PaymentMethod paymentMethod);

    List<PaymentMethodResponse> toResponseList(List<PaymentMethod> paymentMethods);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "payments", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    PaymentMethod toEntity(CreatePaymentMethodRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "payments", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(UpdatePaymentMethodRequest request, @MappingTarget PaymentMethod paymentMethod);
}
