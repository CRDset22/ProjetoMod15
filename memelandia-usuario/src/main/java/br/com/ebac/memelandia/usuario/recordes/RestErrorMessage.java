package br.com.ebac.memelandia.usuario.recordes;

import org.springframework.http.HttpStatus;

public record RestErrorMessage<E>(HttpStatus httpStatus, E body) {}
