package com.appescritorio.costcatcher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.appescritorio.costcatcher.repo.TareaRepository;
import com.appescritorio.costcatcher.tarea.Tarea;

@CrossOrigin
@RestController
@RequestMapping("/tareas")
public class TareaController {
	
	@Autowired
	private TareaRepository tareaRepository;
	
	@GetMapping("")
	List<Tarea> index(){
		return tareaRepository.findAll();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	Tarea create(@RequestBody Tarea tarea) {
		return tareaRepository.save(tarea);
	}
	
	
	@PutMapping("{id}")
	Tarea update(@PathVariable String id,@RequestBody Tarea tarea){
		Tarea tareaFromDb = tareaRepository
				.findById(id)
				.orElseThrow(RuntimeException::new);
		
		tareaFromDb.setNombre(tarea.getNombre());
		tareaFromDb.setCompletado(tarea.isCompletado());
		
		return tareaRepository.save(tareaFromDb);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}") 
	void delete(@PathVariable String id) {
		Tarea tarea = tareaRepository
				.findById(id)
				.orElseThrow(RuntimeException::new);
		tareaRepository.delete(tarea);
	}
}

	
	
	
	
	
	

