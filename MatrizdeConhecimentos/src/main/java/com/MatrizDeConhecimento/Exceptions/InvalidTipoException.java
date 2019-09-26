package com.MatrizDeConhecimento.Exceptions;

public class InvalidTipoException extends RuntimeException{

private static final long  serialVersionUID = -2380167736614554050L;
	
	public InvalidTipoException(String mensagem) {
		super(mensagem);
	}
	
	public InvalidTipoException( ) {
		super();
	}
}
