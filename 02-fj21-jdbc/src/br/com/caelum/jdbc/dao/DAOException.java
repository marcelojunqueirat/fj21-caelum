package br.com.caelum.jdbc.dao;

public class DAOException extends RuntimeException {

	public DAOException() {
		super();
	}
    
    public DAOException(Throwable e) {
        super(e);
    }
    
    public DAOException(String mensagem, Throwable e) {
        super(mensagem, e);
    }
}
