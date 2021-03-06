package cl.gallery.webapp.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "perfiles")
public class Perfil implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String descripcion1;
	@Lob
	private String descripcion2;
	@Lob
	private String descripcion3;
	@Lob
	private String descripcion4;
	
	private String  idioma;
	
	public Perfil() {
	}

	public Perfil(Long id, String descripcion1, String descripcion2, String descripcion3,
			String descripcion4, String  idioma) {
		super();
		this.id = id;
		this.descripcion1 = descripcion1;
		this.descripcion2 = descripcion2;
		this.descripcion3 = descripcion3;
		this.descripcion4 = descripcion4;
		this.idioma = idioma;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion1() {
		return descripcion1;
	}

	public void setDescripcion1(String descripcion1) {
		this.descripcion1 = descripcion1;
	}

	public String getDescripcion2() {
		return descripcion2;
	}

	public void setDescripcion2(String descripcion2) {
		this.descripcion2 = descripcion2;
	}

	public String getDescripcion3() {
		return descripcion3;
	}

	public void setDescripcion3(String descripcion3) {
		this.descripcion3 = descripcion3;
	}

	public String getDescripcion4() {
		return descripcion4;
	}

	public void setDescripcion4(String descripcion4) {
		this.descripcion4 = descripcion4;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
}