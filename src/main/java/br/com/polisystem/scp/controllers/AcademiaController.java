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

import br.com.polisystem.scp.model.entities.TbAcademia;
import br.com.polisystem.scp.model.repositories.AcademiaRepository;

@RestController
@RequestMapping(path = "/academia")
public class AcademiaController {
	
	@Autowired
	private AcademiaRepository academiaRepository;
	
	@GetMapping(path = "/{id}")
	public Optional<TbAcademia> procurarAcademia(@PathVariable int id) {
		return academiaRepository.findById(id);
	}
	
	@GetMapping(path = "/nome/{parteNome}")
	public Iterable<TbAcademia> procurarAcademiaPorNome(@PathVariable String parteNome){
		return academiaRepository.findByNomeContaining(parteNome);
	}
	
	@GetMapping(path = "/pagina/{numeroPagina}")
	public Iterable<TbAcademia> ListaAcademia(@PathVariable int numeroPagina){
		Pageable page = PageRequest.of(numeroPagina, 15);
		return academiaRepository.findAll(page);
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public TbAcademia novaAcademia(@Valid TbAcademia academia) {
		academiaRepository.save(academia);
		return academia;
	}

}
