package com.MatrizDeConhecimento.Exceptions;

public class InvalidEmailException extends RuntimeException{

private static final long  serialVersionUID = -2380167736614554050L;
	
	public InvalidEmailException(String mensagem) {
		super(mensagem);
	}
	
	public InvalidEmailException( ) {
		super();
	}
}
