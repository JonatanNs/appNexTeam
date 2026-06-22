package com.nexteam.User.sql;

import com.nexteam.User.IUserDAO;
import com.nexteam.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Classe 'UserDAO' en charge de
 *
 * @author jnsualu2026
 * @since 2026-06-19
 */
@RequiredArgsConstructor
@Service
public class UserDAO implements IUserDAO {

    private final UserRepository repository;

    @Override
    public Page<User> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<User> getByPublicId(UUID publicId) {
        return repository.findByPublicId(publicId);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public void deleteById(UUID publicId) {
        repository.deleteByPublicId(publicId);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }
}
