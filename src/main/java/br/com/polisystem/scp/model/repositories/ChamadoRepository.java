package br.com.polisystem.scp.model.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.polisystem.scp.model.entities.TbAcademia;
import br.com.polisystem.scp.model.entities.TbAnalista;
import br.com.polisystem.scp.model.entities.TbChamados;

public interface ChamadoRepository extends PagingAndSortingRepository<TbChamados, Integer>{
	
	@Query("select distinct C from TbChamados C where C.analista = :analista ORDER BY C.id DESC")
	public Page<TbChamados> consultarChamadosPorAnalista(@Param("analista") TbAnalista analista, Pageable pageable);
	
	@Query("select distinct C from TbChamados C where C.academia = :academia ORDER BY C.id DESC")
	public Page<TbChamados> consultarChamadosPorAcademia(@Param("academia") TbAcademia academia, Pageable pageable);

}
