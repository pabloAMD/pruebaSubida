package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.LibroFacade;
import ec.edu.ups.modelo.Libro;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped

public class LibroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private LibroFacade ejbLibro;
	private List<Libro> list;
	
	private String nombre;
	private String isbn;
	private int numPaginas;

	public LibroBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		list= ejbLibro.findAll();
	}

	public LibroFacade getEjbLibro() {
		return ejbLibro;
	}

	public void setEjbLibro(LibroFacade ejbLibro) {
		this.ejbLibro = ejbLibro;
	}

	public List<Libro> getList() {
		return list;
	}

	public void setList(List<Libro> list) {
		this.list = list;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getNumPag() {
		return numPaginas;
	}

	public void setNumPag(int numPag) {
		this.numPaginas = numPag;
	}
	
	public String add() {
		ejbLibro.create(new Libro(this.nombre, this.isbn, this.numPaginas));
		list = ejbLibro.findAll();
		return null;
	}
	

	public String delete(Libro c) {
		ejbLibro.remove(c);
		list = ejbLibro.findAll();
		return null;
	}

	public String edit(Libro c) {
		c.setEditable(true);
		return null;
	}

	public String save(Libro c) {
		ejbLibro.edit(c);
		c.setEditable(false);
		return null;
	}
	

}
