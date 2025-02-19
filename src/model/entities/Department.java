package model.entities;

import java.io.Serializable;
import java.util.Objects;

// Implements Serializable para q os dados trafeguem em rede ou em arquivos etc.
public class Department implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	// Construtor padrão
	public Department() {		
	}
	
	// Construtor com argumentos
	public Department(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	// Métodos Getters/Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	// Métodos hasCode e equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(id, other.id);
	}
	
	// Método toString
	@Override
	public String toString() {
		return "Departamento [Id = " + id + ", Nome = " + nome + "]";
	}	
}
