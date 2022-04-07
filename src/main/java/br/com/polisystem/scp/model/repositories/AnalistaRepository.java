package br.com.polisystem.scp.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.polisystem.scp.model.entities.TbAnalista;

public interface AnalistaRepository extends PagingAndSortingRepository<TbAnalista, Integer>{
	
	public Iterable<TbAnalista> findByNomeContaining(String parteNome);

}
