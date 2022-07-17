package cl.gallery.webapp.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cl.gallery.webapp.models.entity.Noticia;

public interface INewService {

	public List<Noticia> findAll();
	
	public Page<Noticia> findAll(Pageable peageble);
	
	public void save(Noticia n);
	
	public Noticia findOne(Long id);
	
	public void delete(Long id);
}
