package com.fiap.tech.pedidos.application.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// Exceção genérica
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleAllExceptions(Exception ex, WebRequest request) {
		return new ResponseEntity<>("Erro interno do servidor: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// Exceção de recurso não encontrado
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntimeException(RuntimeException ex, WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	// Argumento ilegal
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
		return new ResponseEntity<>("Argumento inválido: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	// Tipo de argumento inválido
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<String> handleTypeMismatchException(MethodArgumentTypeMismatchException ex,
			WebRequest request) {
		return new ResponseEntity<>("Tipo de argumento inválido: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	// Argumentos de método inválidos (ex: validação de formulário)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
			WebRequest request) {
		return new ResponseEntity<>(
				"Requisição inválida: " + ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(),
				HttpStatus.BAD_REQUEST);
	}

	// Outros erros de requisição (400)
	@ExceptionHandler({ IllegalStateException.class })
	public ResponseEntity<String> handleIllegalStateException(IllegalStateException ex, WebRequest request) {
		return new ResponseEntity<>("Estado ilegal detectado: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
