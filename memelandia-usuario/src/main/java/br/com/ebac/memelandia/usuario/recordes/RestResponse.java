package br.com.ebac.memelandia.usuario.recordes;

import org.springframework.http.HttpStatus;

public record RestResponse<E> (HttpStatus httpStatus, E body) {}
