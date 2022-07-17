package cl.arteValparaiso.webapp.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cl.arteValparaiso.webapp.models.entity.Obra;

public interface IObraDao extends PagingAndSortingRepository<Obra, Long>{

	@Query("SELECT o FROM Obra o WHERE o.tecnica = 'Oleo' ")	
	public Page<Obra> oleos(Pageable pageable);
	
	@Query("SELECT o FROM Obra o WHERE o.tecnica = 'Acuarela' ")	
	public Page<Obra> acuarelas(Pageable pageable);
}
