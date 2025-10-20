package com.javanauta.agendadortarefa.business.converter;

import com.javanauta.agendadortarefa.business.dto.TarefasDto;
import com.javanauta.agendadortarefa.infraesctruture.entity.TarefasEntity;

import java.util.List;


@org.mapstruct.Mapper(componentModel = "spring")

public interface Mapper {

    TarefasEntity paraEntity(TarefasDto dto);

    TarefasDto paraDto(TarefasEntity entity);

    List<TarefasEntity> paraListaEntity(List<TarefasDto> listaDtos);

    List<TarefasDto> paraListaDto (List<TarefasEntity> listaEntities);


}
