package com.adegadopaibackend.adegadopaibackend.mapper;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateNotificationRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.NotificationResponse;
import com.adegadopaibackend.adegadopaibackend.entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationResponse toResponse(Notification notification);

    List<NotificationResponse> toResponseList(List<Notification> notifications);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isRead", constant = "false")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "user", ignore = true)
    Notification toEntity(CreateNotificationRequest request);
}
