package cl.gallery.webapp.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.gallery.webapp.models.entity.Noticia;

public interface INewDao extends PagingAndSortingRepository<Noticia, Long>{

}
