package db;

public class DbException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	// Construtor. Recebe uma msg e transmite para a superclasse RuntimeException
	public DbException(String msg) {
		super(msg);
	}

}
