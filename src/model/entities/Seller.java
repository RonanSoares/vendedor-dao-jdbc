package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

// Implements Serializable para trafegar dados em redes, arquivos etc.
public class Seller implements Serializable{
	
	private Integer id;
	private String nome;
	private String email;
	private Date birthDate;
	private Double baseSalary;
	
	// Associação com a classe Department
	private Department department;
	
	// Construtor vazio
	public Seller() {		
	}

	// Construtor com argumentos
	public Seller(Integer id, String nome, String email, Date birthDate, Double baseSalary, Department department) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.birthDate = birthDate;
		this.baseSalary = baseSalary;
		this.department = department;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	// Métodos hasCode/equals
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
		Seller other = (Seller) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Vendedor [Id= " + id + ", Nome= " + nome + ", Email= " + email + ", Data Nasc= " + birthDate + ", Salário base= "
				+ baseSalary + ", Departamento= " + department + "]";
	}	
}
