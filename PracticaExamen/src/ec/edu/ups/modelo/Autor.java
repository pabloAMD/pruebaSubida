package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;




@NamedQuery(name = "getByAutor", query = "SELECT a FROM Autor a WHERE a.nombre =:nombre")
@Entity
public class Autor implements Serializable{
	

	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	private String nombre;
	private String nacionalidad;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "autor")
	private Capitulos capitulo;

	@Transient
	private boolean editable;

	public Autor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Autor( String nombre, String nacionalidad) {
	
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}
	
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	
	

	public Capitulos getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(Capitulos capitulo) {
		this.capitulo = capitulo;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
	
}
