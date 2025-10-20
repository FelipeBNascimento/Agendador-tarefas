package com.javanauta.agendadortarefa.infraesctruture.entity;



import com.javanauta.agendadortarefa.infraesctruture.enums.TarefasEnums;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Document("tarefas")
public class TarefasEntity {

    @Id
    private String id;
    private String nomeTarefa;
    private String descricao;
    private String emailUsuario;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataEvento;
    private LocalDateTime dataAlteracao;

    private TarefasEnums status;




}
