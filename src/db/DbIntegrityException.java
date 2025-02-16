package db;

// Classe para verificar a integridade referencial (Não pode excluir um departamento que tem um seller como referencia)
public class DbIntegrityException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	// Força construtor passar superclasse
	public DbIntegrityException(String msg) {
		super(msg);
	}
}
