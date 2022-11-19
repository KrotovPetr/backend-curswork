package com.cursproject.Mapper;

import com.cursproject.DTO.UpdateComponentDTO;
import com.cursproject.Entity.Components;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ComponentMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateComponentFromDto(UpdateComponentDTO dto, @MappingTarget Components entity);
}