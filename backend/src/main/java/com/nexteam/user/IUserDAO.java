package com.nexteam.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

/**
 * Interface 'IUserDAO' en charge de la gestion des opérations CRUD sur les utilisateurs.
 *
 * @author jnsualu2026
 * @since 2026-06-19
 */
public interface IUserDAO {
    Page<User> getAll(Pageable pageable);
    Optional<User> getByEmail(String email);
    Optional<User> getByPublicId(UUID publicId);
    void deleteById(UUID publicId);
    User save(User user);
}
