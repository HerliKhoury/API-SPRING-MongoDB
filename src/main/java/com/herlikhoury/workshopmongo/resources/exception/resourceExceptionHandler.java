package com.herlikhoury.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.herlikhoury.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice //Indica que a classe irá tratar possíveis erros de requisição
public class resourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)//Necessário pra indicar quando houver esta exceção, fazer o tratamento abaixo
	public ResponseEntity<standardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;//Armazena o erro 404
		
		standardError err = new standardError(
				System.currentTimeMillis(), 
				status.value(), 
				"Herói não encontrado", 
				e.getMessage(), 
				request.getRequestURI()
		);
		
		return ResponseEntity.status(status).body(err);
		
	}

}
