package com.javanauta.agendadortarefa.controller;

import com.javanauta.agendadortarefa.business.dto.TarefasDto;
import com.javanauta.agendadortarefa.business.service.TarefasService;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tarefas")
public class TarefasController {

    private final TarefasService service;

    @PostMapping
    public ResponseEntity<TarefasDto> criarTarefas(@RequestBody TarefasDto dto,
                                                   @RequestHeader("Authorization") String token) {

        return ResponseEntity.ok(service.criarTarefas(dto, token));
    }

    @GetMapping
    public ResponseEntity<List<TarefasDto>> buscarPorEmailUsuario(@RequestHeader("Authorization")
                                                                  String token) {

        List<TarefasDto> listaTerefas = service.mostrarTarefas(token);

        return ResponseEntity.ok(listaTerefas);

    }

    @GetMapping("/eventos")

    public ResponseEntity<List<TarefasDto>> buscarPorEventos(@RequestParam @DateTimeFormat
                                                                         (iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
                                                             @RequestParam @DateTimeFormat
                                                                     (iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal) {

        return ResponseEntity.ok(service.buscarPorDatas(dataInicio, dataFinal));
    }


}
