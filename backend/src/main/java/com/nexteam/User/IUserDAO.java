package com.nexteam.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

/**
 * Classe 'IUserDAO' en charge de
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
