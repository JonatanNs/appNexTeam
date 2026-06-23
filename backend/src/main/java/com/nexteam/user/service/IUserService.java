package com.nexteam.user.service;

import com.nexteam.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Classe 'IUserService' en charge de
 *
 * @author jnsualu2026
 * @since 2026-06-23
 */
public interface IUserService {
    Page<User> getUsers(Pageable pageable);

    User getUser(UUID publicId);

    User getUserByEmail(String email);

    User updateUser(UUID publicId, User user);

    User createUser(User user);

    @Transactional
    void deleteUser(UUID publicId);
}
