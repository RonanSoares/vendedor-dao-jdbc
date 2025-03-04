package model.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{
	
	// Obj para conexão com o BD
	public Connection conn;                 
	
	// Construtor - Injeção de dependencia.
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT seller. *, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.id = ? ");
			
			ps.setInt(1, id);          // Interrogação 1 recebe o id que vem no argumento da função.
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Department dep = instantiateDepartment(rs);				
				Seller obj = instantiateSeller(rs, dep);				
				return obj;					
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
			// Conexão não fecha, pois pode ser usada em outras operações. (É fechada no programa principal)
		}
		
	}
	
	// Métodos auxiliares Seller e Department
	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		 Seller obj = new Seller();
			obj.setId(rs.getInt("Id"));
			obj.setNome(rs.getString("Name"));
			obj.setEmail(rs.getString("Email"));
			obj.setBaseSalary(rs.getDouble("BaseSalary"));
			obj.setBirthDate(rs.getDate("BirthDate"));
			obj.setDepartment(dep);
		return obj;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId")); // Pega o Id do Departamento
		dep.setNome(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT seller. *, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE Department.id = ? "
					+ "ORDER BY Name");
			
			ps.setInt(1, department.getId());              // Interrogação 1 recebe o id que vem no argumento da função.
			rs = ps.executeQuery();
			
			List<Seller> list = new ArrayList<>();          // Cria a lista vazia para receber os vendedores
			Map<Integer, Department> map = new HashMap<>(); // Cria o map, controle para não repetir o departamento
			
			while(rs.next()) {
				
				Department dep = map.get(rs.getInt("DepartmentId"));
				
				if(dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);					
				}				
				Seller obj = instantiateSeller(rs, dep);				
				list.add(obj);  // Adiciona os vendedores na lista					
			}
			return list;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
			// Conexão não fecha, pois pode ser usada em outras operações. (É fechada no programa principal)
		}		
	}
}
