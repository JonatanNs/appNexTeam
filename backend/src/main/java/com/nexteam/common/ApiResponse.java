package com.nexteam.common;

import java.time.Instant;

/**
 * Classe 'ApiResponse' en charge de
 *
 * @author jnsualu2026
 * @version 1.0
 * @since 19/06/2026 14:15
 */
public record ApiResponse<T>(int code, Instant timestamp , String message, T data) {

    public static <T> ApiResponse<T> of(int code, String message, T data) {
        return new ApiResponse<>(code, Instant.now(), message, data);
    }

}
