package com.appescritorio.costcatcher.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.appescritorio.costcatcher.tarea.Tarea;

public interface TareaRepository extends MongoRepository <Tarea, String> {

}
