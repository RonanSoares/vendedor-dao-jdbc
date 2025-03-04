package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {
	
	void insert(Seller obj);         // Operação para inserir no BD um obj recebido como argumento
	void update(Seller obj);         // Operação para Att no BD um obj recebido como argumento
	void deleteById(Integer id);     // Operação para deletar no BD um seller, pelo id recebido como argumento
	Seller findById(Integer id);     // OPeração para retornar do BD um seller, pelo id recebido como argumento
	List<Seller> findAll();          // Operação para retornar do BD todos os elementos.
	List<Seller> findByDepartment(Department department);   // Busca por departamentos
}
