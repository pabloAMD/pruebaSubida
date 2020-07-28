package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;


import ec.edu.ups.ejb.AutorFacade;
import ec.edu.ups.modelo.Autor;



@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped

public class AutorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private AutorFacade ejbAutor;
	
	private List<Autor> list;
	private String nombre;
	private String nacionalidad;

	public AutorBean() {
		
	}
	
	@PostConstruct
	public void init() {
		ejbAutor.create(new Autor("Gabriel Garcia", "Colombiano"));
		ejbAutor.create(new Autor("Pablo Neruda", "Colombiano"));
		list = ejbAutor.findAll();
	}

	public Autor[] getList() {
		return list.toArray(new Autor[0]);
	}
	
	public AutorFacade getEjbAutor() {
		return ejbAutor;
	}

	public void setEjbAutor(AutorFacade ejbAutor) {
		this.ejbAutor = ejbAutor;
	}


	public void setList(List<Autor> list) {
		this.list = list;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	
	public String add() {
		ejbAutor.create(new Autor(this.nombre,this.nacionalidad));
		list = ejbAutor.findAll();
		return null;
	}

	public String delete(Autor c) {
		ejbAutor.remove(c);
		list = ejbAutor.findAll();
		return null;
	}

	public String edit(Autor c) {
		c.setEditable(true);
		return null;
	}

	public String save(Autor c) {
		ejbAutor.edit(c);
		c.setEditable(false);
		return null;
	}
	
	
	
   
}

