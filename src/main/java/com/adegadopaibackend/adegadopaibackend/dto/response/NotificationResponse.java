package com.adegadopaibackend.adegadopaibackend.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationResponse {

    private Long id;

    private String title;

    private String message;

    private Boolean isRead;
}
