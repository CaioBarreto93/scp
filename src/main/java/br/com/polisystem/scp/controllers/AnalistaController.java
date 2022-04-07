package br.com.polisystem.scp.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.polisystem.scp.model.entities.TbAnalista;
import br.com.polisystem.scp.model.repositories.AnalistaRepository;

@RestController
@RequestMapping(path = "/analista")
public class AnalistaController {
	
	@Autowired
	private AnalistaRepository analistaRepository;
	
	@GetMapping(path = "/{id}")
	public Optional<TbAnalista> procurarAnalista(@PathVariable int id) {
		return analistaRepository.findById(id);
	}
	
	@GetMapping(path = "/nome/{parteNome}")
	public Iterable<TbAnalista> procurarAnalistaPorNome(@PathVariable String parteNome){
		return analistaRepository.findByNomeContaining(parteNome);
	}
	
	@GetMapping(path = "/pagina/{numeroPagina}")
	public Iterable<TbAnalista> ListaAnalista(@PathVariable int numeroPagina){
		Pageable page = PageRequest.of(numeroPagina, 15);
		return analistaRepository.findAll(page);
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public TbAnalista salvarAnalista(@Valid TbAnalista analista) {
		analistaRepository.save(analista);
		return analista;
	}

}