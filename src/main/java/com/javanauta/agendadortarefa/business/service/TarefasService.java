package com.javanauta.agendadortarefa.business.service;


import com.javanauta.agendadortarefa.business.converter.MappearUpdate;
import com.javanauta.agendadortarefa.business.converter.Mapper;
import com.javanauta.agendadortarefa.business.dto.TarefasDto;
import com.javanauta.agendadortarefa.infraesctruture.IdNaoEncontrado;
import com.javanauta.agendadortarefa.infraesctruture.entity.TarefasEntity;
import com.javanauta.agendadortarefa.infraesctruture.enums.TarefasEnums;
import com.javanauta.agendadortarefa.infraesctruture.repository.TarefasRepository;
import com.javanauta.agendadortarefa.infraesctruture.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final JwtUtil jwtUtil;
    private final Mapper mapper;
    private final MappearUpdate atualizar;

    public TarefasDto criarTarefas(TarefasDto dto, String token) {

        String email = jwtUtil.extraiToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setEmailUsuario(email);
        dto.setStatus(TarefasEnums.PENDENTE);
        TarefasEntity tarefasSalvar = mapper.paraEntity(dto);
        TarefasEntity tarefaSalva = tarefasRepository.save(tarefasSalvar);
        return mapper.paraDto(tarefaSalva);
    }

    public List<TarefasDto> mostrarTarefas(String token) {

        String email = jwtUtil.extraiToken(token.substring(7));

        List<TarefasEntity> tarefasEntity = tarefasRepository.findByEmailUsuario(email);

        List<TarefasDto> listasDto = mapper.paraListaDto(tarefasEntity);

        return listasDto;

    }


    public List<TarefasDto> buscarPorDatas(LocalDateTime dataInicial, LocalDateTime dataFinal) {

        List<TarefasEntity> listaEntities = tarefasRepository.findByDataEventoBetween(dataInicial, dataFinal);

        List<TarefasDto> listasDtos = mapper.paraListaDto(listaEntities);

        return listasDtos;
    }


    public void apagarTarefas(String id) {

        try {
            tarefasRepository.deleteById(id);
        } catch (IdNaoEncontrado e) {
            throw new IdNaoEncontrado("Id inexistente " + id, e.getCause());
        }

    }

    public TarefasDto alterarStatus(TarefasEnums status, String id) {


        try {

            TarefasEntity tarefasEntity = tarefasRepository.findById(id).orElseThrow(
                    () -> new IdNaoEncontrado("Id não encontrado" + id)
            );
            tarefasEntity.setStatus(status);
            TarefasEntity tarefaSalva = tarefasRepository.save(tarefasEntity);
            TarefasDto dto = mapper.paraDto(tarefaSalva);
            return dto;

        } catch (IdNaoEncontrado e) {
            throw new IdNaoEncontrado("id inexistente" + id, e.getCause());
        }
    }

    public TarefasDto atualizarTarefas(TarefasDto dto, String id) {

        try {
            TarefasEntity entity = tarefasRepository.findById(id).orElseThrow(
                    () -> new IdNaoEncontrado("Id inexistente" + id)
            );

            atualizar.atualizarDto(dto, entity);
            TarefasEntity tarefaSalva = tarefasRepository.save(entity);

            return mapper.paraDto(tarefaSalva);

        } catch (IdNaoEncontrado e) {
            throw new IdNaoEncontrado("ID inexistente " + id, e.getCause());
        }

    }


}
