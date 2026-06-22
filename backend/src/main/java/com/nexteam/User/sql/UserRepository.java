package com.nexteam.User.sql;

import com.nexteam.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Classe 'UserRepository' en charge de
 *
 * @author jnsualu2026
 * @since 2026-06-19
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByPublicId(UUID publicId);
    void deleteByPublicId(UUID publicId);
}
