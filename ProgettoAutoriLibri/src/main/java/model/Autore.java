package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table (name="autori")
@NamedQuery(
	    name="findAllAuthors",
	    query="SELECT a FROM Autore a"
	    )
public class Autore implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	@Id
	@Column (name= "id_autore")
	private String id;
	
	


	@Column (nullable=false, name="nome")
	private String nome;
	
	@Column (nullable = false, name="cognome")
	private String cognome;
	
	@Column (name="età")
	private Integer eta;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}
	
	
//	@OneToMany (mappedBy="idAutore")
//	private List<Libro>libri;




	
	
	
	
	
	
}