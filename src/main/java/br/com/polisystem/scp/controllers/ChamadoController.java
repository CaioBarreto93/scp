package br.com.polisystem.scp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.polisystem.scp.model.entities.TbAcademia;
import br.com.polisystem.scp.model.entities.TbAnalista;
import br.com.polisystem.scp.model.entities.TbChamados;
import br.com.polisystem.scp.model.repositories.AcademiaRepository;
import br.com.polisystem.scp.model.repositories.AnalistaRepository;
import br.com.polisystem.scp.model.repositories.ChamadoRepository;

@RestController
@RequestMapping(path = "/chamado")
public class ChamadoController {
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private AnalistaRepository analistaRepository;
	@Autowired
	private AcademiaRepository academiaRepository;
	
	
	@GetMapping(path = "/{id}")
	public Optional<TbChamados> procurarChamado(@PathVariable int id) {
		return chamadoRepository.findById(id);
	}
	
	@GetMapping(path = "/analista/{id_analista}/{numeroPagina}")
	public Page<TbChamados> procurarChamadoPorAnalista(@PathVariable int id_analista, @PathVariable int numeroPagina){
		Optional<TbAnalista> analistaOptional = analistaRepository.findById(id_analista);
		Pageable page = PageRequest.of(numeroPagina, 15);
		return chamadoRepository.consultarChamadosPorAnalista(analistaOptional.get(), page);
	}
	
	@GetMapping(path = "/academia/{id_academia}/{numeroPagina}")
	public Page<TbChamados> procurarChamadoPorAcademia(@PathVariable int id_academia, @PathVariable int numeroPagina){
		Optional<TbAcademia> academiaOptional = academiaRepository.findById(id_academia);
		Pageable page = PageRequest.of(numeroPagina, 15);
		return chamadoRepository.consultarChamadosPorAcademia(academiaOptional.get(), page);
	}
	
	@GetMapping(path = "/pagina/{numeroPagina}")
	public Iterable<TbChamados> ListaChamado(@PathVariable int numeroPagina){
		Pageable page = PageRequest.of(numeroPagina, 15);
		return chamadoRepository.findAll(page);
	}
	
	@RequestMapping(method = {RequestMethod.POST})
	public TbChamados salvarChamado(String solicitante, String teamviewer, String problema, String solucao, int id_analista, int id_academia) {
		TbAcademia academia = academiaRepository.findById(id_academia).get();
		TbAnalista analista = analistaRepository.findById(id_analista).get();
		TbChamados chamado = new TbChamados(solicitante, teamviewer, problema,solucao, analista, academia);
		chamadoRepository.save(chamado);
		return chamado;
	}

}