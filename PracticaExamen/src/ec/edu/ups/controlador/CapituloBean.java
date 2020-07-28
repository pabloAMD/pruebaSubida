package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.AutorFacade;
import ec.edu.ups.ejb.CapituloFacade;
import ec.edu.ups.ejb.LibroFacade;
import ec.edu.ups.modelo.Autor;
import ec.edu.ups.modelo.Capitulos;
import ec.edu.ups.modelo.Libro;

@Named
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@RequestScoped
public class CapituloBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nombreL;
	private String nombreA;
	
	@EJB
	private CapituloFacade ejbCapitulo;
	private List<Capitulos> list;
	private int numero;
	private String titulo;
	
	@EJB
	private AutorFacade ejbAutor;
	private List<Autor> autorlist;
	
	
	@EJB
	private LibroFacade ejbLibro;
	private List<Libro> librolist;
	
	
	
	@PostConstruct
	public void init() {
		this.list= ejbCapitulo.findAll();
		this.autorlist= ejbAutor.findAll();
		this.librolist= ejbLibro.findAll();
	}

	
	public List<Libro> getLibrolist() {
		return librolist;
	}


	public CapituloBean() {
		// TODO Auto-generated constructor stub
	}


	public CapituloFacade getEjbCapitulo() {
		return ejbCapitulo;
	}


	public void setEjbCapitulo(CapituloFacade ejbCapitulo) {
		this.ejbCapitulo = ejbCapitulo;
	}

	public void setList(List<Capitulos> list) {
		this.list = list;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
	public String getNombreL() {
		return nombreL;
	}

	public void setNombreL(String nombreL) {
		this.nombreL = nombreL;
	}

	public String getNombreA() {
		return nombreA;
	}

	public void setNombreA(String nombreA) {
		this.nombreA = nombreA;
	}

	public AutorFacade getEjbAutor() {
		return ejbAutor;
	}

	public void setEjbAutor(AutorFacade ejbAutor) {
		this.ejbAutor = ejbAutor;
	}

	public List<Autor> getAutorlist() {
		this.autorlist= ejbAutor.findAll();
		
		return autorlist;
	}

	public void setAutorlist(List<Autor> autorlist) {
		this.autorlist = autorlist;
	}

	
	

	public LibroFacade getEjbLibro() {
		return ejbLibro;
	}

	public void setEjbLibro(LibroFacade ejbLibro) {
		this.ejbLibro = ejbLibro;
	}

	public Capitulos[] getList() {
		return list.toArray(new Capitulos[0]);
	}

	public void setLibrolist(List<Libro> librolist) {
		this.librolist = librolist;
	}
	
	

	

	public String add() {
		Autor a= ejbAutor.readAutor(this.nombreA);
		Libro l= ejbLibro.readLibro(this.nombreL);
		ejbCapitulo.create(new Capitulos(this.numero, this.titulo, a, l));
		list = ejbCapitulo.findAll();
		return null;
	}

	public String delete(Capitulos c) {
		ejbCapitulo.remove(c);
		list = ejbCapitulo.findAll();
		return null;
	}

	public String edit(Capitulos c) {
		c.setEditable(true);
		return null;
	}

	public String save(Capitulos c) {
		ejbCapitulo.edit(c);
		c.setEditable(false);
		return null;
	}
	

}
