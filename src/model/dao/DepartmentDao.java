package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {
	
	void insert(Department obj);     // Insere no BD um obj recebido como argumento.
	void update(Department obj);     // Att no BD...
	void deleteById(Integer id);     // Deleta no BD pelo id recebido como argumento
	Department findById(Integer id); // Operação responsável para retornar um obj Department pelo id. Senão retorna nulo
	List<Department> findAll();      // Operação para retornar todos os Departamentos
}
