package com.MatrizDeConhecimento.Exceptions;

public class ColaboradorInexistenteException extends RuntimeException {
	
	private static final long serialVersionUID = -2380167736614554050L;
	
	public ColaboradorInexistenteException(String mensagem) {
		super(mensagem);
	}
	
	public ColaboradorInexistenteException( ) {
		super();
	}
}
