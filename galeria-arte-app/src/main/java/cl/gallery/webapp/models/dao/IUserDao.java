 package cl.gallery.webapp.models.dao;

import org.springframework.data.repository.CrudRepository;

import cl.gallery.webapp.models.entity.User;

public interface IUserDao extends CrudRepository <User, Long>{

}
