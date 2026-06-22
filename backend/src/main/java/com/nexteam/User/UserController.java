package com.nexteam.User;

import com.nexteam.common.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Classe 'UserController' en charge de
 *
 * @author jnsualu2026
 * @since 2026-06-19
 */
@RequiredArgsConstructor
@RequestMapping("api/v1")
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<ApiResponse<Page<User>>> getUsers(Pageable pageable) {
        return ResponseEntity.ok().body(
                ApiResponse.of(
                        HttpStatus.OK.value(),
                        "Éléments récupérés avec succes.",
                        userService.getUsers(pageable)
                )
        );
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<ApiResponse<User>> getUser(@PathVariable UUID id) {
        return ResponseEntity.ok().body(
                ApiResponse.of(
                        HttpStatus.OK.value(),
                        "Élément récupéré avec succes.",
                        userService.getUser(id)
                )
        );
    }

    @GetMapping("/user/email")
    public ResponseEntity<ApiResponse<User>> getUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(
                ApiResponse.of(
                        HttpStatus.OK.value(),
                        "OK",
                        userService.getUserByEmail(email))
        );
    }

    @PostMapping("/user")
    public ResponseEntity<ApiResponse<User>> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok().body(
                ApiResponse.of(
                        HttpStatus.OK.value(),
                        "Utilisateur crée avec succes.",
                        userService.createUser(user)
                )
        );
    }

    @PutMapping("/user/{publicId}")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable UUID publicId, @Valid @RequestBody User user) {
        return ResponseEntity.ok().body(
                ApiResponse.of(
                        HttpStatus.OK.value(),
                        "Utilisateur modifié avec succes.",
                        userService.updateUser(publicId, user)
                )
        );
    }

    @DeleteMapping("/user/{publicId}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable UUID publicId) {
        userService.deleteUser(publicId);
        return ResponseEntity.ok().body(
                ApiResponse.of(
                        HttpStatus.OK.value(),
                        "Utilisateur supprimé avec succes.",
                        null
                )
        );
    }
}

