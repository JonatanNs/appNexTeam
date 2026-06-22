package com.nexteam.exception;

/**
 * Classe 'NotFoundException' en charge de
 *
 * @author jnsualu2026
 * @since 2026-06-19
 */

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
