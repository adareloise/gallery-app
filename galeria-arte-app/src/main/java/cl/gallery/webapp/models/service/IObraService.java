package cl.gallery.webapp.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cl.gallery.webapp.models.entity.Obra;

public interface IObraService {
	
	public List<Obra> findAll();

	public Page<Obra> acuarelas(Pageable peageble);
	
	public Page<Obra> oleos(Pageable peageble);
	
	public Page<Obra> findAll(Pageable peageble);

	public void save(Obra obra);
	
	public Obra findOne(Long id);
	
	public void delete(Long id);
	
}
