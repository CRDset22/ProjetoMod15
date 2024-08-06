package br.com.ebac.memelandia.usuario.exception;

public class UsuarioExistenteException extends RuntimeException {

    public UsuarioExistenteException(String message) {
        super(message);
    }
}