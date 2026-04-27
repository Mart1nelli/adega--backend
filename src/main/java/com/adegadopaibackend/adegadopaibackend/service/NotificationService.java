package com.adegadopaibackend.adegadopaibackend.service;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateNotificationRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.NotificationResponse;

import java.util.List;

public interface NotificationService {

    NotificationResponse create(Long userId, CreateNotificationRequest req);

    List<NotificationResponse> findByUserId(Long userId);

    NotificationResponse markAsRead(Long id);

    void delete(Long id);
}
