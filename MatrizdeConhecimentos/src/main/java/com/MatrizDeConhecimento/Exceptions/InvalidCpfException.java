package com.MatrizDeConhecimento.Exceptions;

public class InvalidCpfException extends RuntimeException{

private static final long  serialVersionUID = -2380167736614554050L;
	
	public InvalidCpfException(String mensagem) {
		super(mensagem);
	}
	
	public InvalidCpfException( ) {
		super();
	}
}
