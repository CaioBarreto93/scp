package br.com.polisystem.scp.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.polisystem.scp.model.entities.TbAcademia;

public interface AcademiaRepository extends PagingAndSortingRepository<TbAcademia, Integer>{
	
	public Iterable<TbAcademia> findByNomeContaining(String parteNome);

}
