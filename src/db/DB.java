package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// CLASSE RESPONSAVEL PELA CONEXÃO E DESCONEXÃO COM O BD
public class DB {
	
	// Cria o objto do tipo Connection. (Connection do javasql)
	private static Connection conn = null;          // Inicia com valor nulo
	
	// Método para conectar com o Banco de Dados.
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Properties props = loadProperties();            // Pega as propriedades do db.properties
				String url = props.getProperty("dburl");        // Pega os dados da dburl do db.properties
				conn = DriverManager.getConnection(url, props); // Para obter uma conexão com o BD
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());				
			}
		}
		return conn;                                            // Se falhar retorna a conexão já existente
	}
	
	// Método para fechar a conexão
	public static void closeConnection() {
		if(conn != null) {                   // Se a conexão estiver aberta
			try {
				conn.close();                // Fecha a conexão
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	// Método para CARREGAR os dados do arquivo db.properties
	private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")){   // Abre o arquivo db.properties.
				Properties props = new Properties(); // Instancia Properties
				props.load(fs);                      // load faz a leitura do obj properties e guarda no props                  
				return props;                        // Retorna o props
		}
		catch(IOException e) {
			throw new DbException(e.getMessage());   // Caso ocorra erro lança exceção na exceção criada (DbException).
		}	
	}
	
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
