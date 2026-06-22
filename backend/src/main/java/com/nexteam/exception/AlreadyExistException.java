package com.nexteam.exception;

/**
 * Classe 'AlreadyExisteException' en charge de
 *
 * @author jnsualu2026
 * @since 2026-06-19
 */
public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String message) {
        super(message);
    }
}
