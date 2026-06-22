package com.nexteam.user.sql;

import com.nexteam.user.IUserDAO;
import com.nexteam.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Classe 'UserDAO' en charge de la gestion des opérations CRUD sur les utilisateurs.
 *
 * @author jnsualu2026
 * @since 2026-06-19
 */
@RequiredArgsConstructor
@Service
public class UserDAO implements IUserDAO {

    private final UserRepository repository;

    /**
     * Récupère tous les utilisateurs.
     * @param pageable
     * @return une page d'utilisateurs
     */
    @Override
    public Page<User> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Récupère un utilisateur par son identifiant unique.
     * @param publicId
     * @return l'utilisateur trouvé
     */
    @Override
    public Optional<User> getByPublicId(UUID publicId) {
        return repository.findByPublicId(publicId);
    }

    /**
     * Récupère un utilisateur par son email.
     * @param email
     * @return l'utilisateur trouvé
     */
    @Override
    public Optional<User> getByEmail(String email) {
        return repository.findByEmail(email);
    }

    /**
     * Supprime un utilisateur par son identifiant unique.
     * @param publicId
     */
    @Override
    public void deleteById(UUID publicId) {
        repository.deleteByPublicId(publicId);
    }

    /**
     * Enregistre un utilisateur.
     * @param user
     * @return l'utilisateur enregistré
     */
    @Override
    public User save(User user) {
        return repository.save(user);
    }
}
