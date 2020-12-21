package com.matheus.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.matheus.cursomc.domain.Categoria;
import com.matheus.cursomc.repositories.CategoriaRepository;
import com.matheus.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired // É automaticamente instanciado pelo spring
	private CategoriaRepository repository;
	
	public Categoria buscar( Integer id ) {
		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo"+ Categoria.class.getName()));
	}
	
}
