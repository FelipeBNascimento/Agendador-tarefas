package com.javanauta.agendadortarefa.business.converter;

import com.javanauta.agendadortarefa.business.dto.TarefasDto;
import com.javanauta.agendadortarefa.infraesctruture.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MappearUpdate {

    void atualizarDto(TarefasDto dto, @MappingTarget TarefasEntity entity);
}
