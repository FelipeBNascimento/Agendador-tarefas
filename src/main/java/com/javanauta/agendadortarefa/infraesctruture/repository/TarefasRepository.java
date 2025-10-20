package com.javanauta.agendadortarefa.infraesctruture.repository;

import com.javanauta.agendadortarefa.infraesctruture.entity.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TarefasRepository extends MongoRepository<TarefasEntity, String> {

    List<TarefasEntity> findByEmailUsuario(String email);

    List<TarefasEntity> findByDataEventoBetween(LocalDateTime datainicial, LocalDateTime datafinal);

    //Optional deleteByEmail(String email);
}
