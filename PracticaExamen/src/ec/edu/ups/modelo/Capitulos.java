package ec.edu.ups.modelo;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@NamedQuery(name = "getByLibro", query = "SELECT l FROM Libro l WHERE l.nombre =:nombre")
@Entity
public class Capitulos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	private int numero;
	private String titulo;
	
	@OneToOne
	@JoinColumn
	private Autor autor;
	
	
	@JsonbTransient
	@ManyToOne
	@JoinColumn
	private Libro libro;
	
	
	@Transient
	private boolean editable;


	public Capitulos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Capitulos(int numero, String titulo, Autor autor, Libro libro) {
		super();
		this.numero = numero;
		this.titulo = titulo;
		this.autor = autor;
		this.libro = libro;
	}



	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
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


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	public Libro getLibro() {
		return libro;
	}


	public void setLibro(Libro libro) {
		this.libro = libro;
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
		Capitulos other = (Capitulos) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
	
	

	
	
}
