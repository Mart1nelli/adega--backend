package com.adegadopaibackend.adegadopaibackend.mapper;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateUserRequest;
import com.adegadopaibackend.adegadopaibackend.dto.request.UpdateUserRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.UserResponse;
import com.adegadopaibackend.adegadopaibackend.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    // DTO → Entity
    User toEntity(CreateUserRequest request);

    // Entity → DTO
    UserResponse toResponse(User user);

    // Update parcial
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "password", ignore = true)
    void updateEntity(UpdateUserRequest request, @MappingTarget User user);

    // Listas
    List<UserResponse> toResponseList(List<User> users);
}
