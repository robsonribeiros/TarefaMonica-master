package br.com.compasso.matrizdeconhecimento.exceptions.handle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.compasso.matrizdeconhecimento.exceptions.ColaboradorInexistenteException;
import br.com.compasso.matrizdeconhecimento.exceptions.InvalidCpfException;
import br.com.compasso.matrizdeconhecimento.exceptions.InvalidEmailException;
import br.com.compasso.matrizdeconhecimento.exceptions.InvalidTipoException;

@RestControllerAdvice
public class Exceptionhandle {

	@ExceptionHandler(ColaboradorInexistenteException.class)
	public ResponseEntity<Object>handleCPFDontExistentsException(ColaboradorInexistenteException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidCpfException.class)
	public ResponseEntity<Object>handleInvalidCpfException(InvalidCpfException c){
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(c.getMessage());
	}
	
	@ExceptionHandler(InvalidTipoException.class)
	public ResponseEntity<Object>handle(InvalidTipoException c){
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(c.getMessage());
	}
	
	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<Object>handleInvalidEmailException(InvalidEmailException c){
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(c.getMessage());
	}
	
}
