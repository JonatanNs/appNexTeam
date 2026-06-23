package com.nexteam.user.service;

import com.nexteam.exception.AlreadyExistException;
import com.nexteam.exception.NotFoundException;
import com.nexteam.user.User;
import com.nexteam.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Classe 'UserService' en charge de la logique métier pour la gestion des utilisateurs.
 *
 * @author jnsualu2026
 * @since 2026-06-19
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository repository;

    /**
     *
     * Méthode en charge de récupérer tous les utilisateurs avec pagination.
     *
     * @param pageable
     * @return une page d'utilisateurs
     */
    @Override
    public Page<User> getUsers(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Récupère un utilisateur par son identifiant unique.
     *
     * @param publicId
     * @return l'utilisateur trouvé
     */
    @Override
    public User getUser(UUID publicId) {
        return repository.findByPublicId(publicId).orElseThrow(() -> new NotFoundException("Élément non trouvé."));
    }

    /**
     * Récupère un utilisateur par son email.
     *
     * @param email
     * @return l'utilisateur trouvé
     */
    @Override
    public User getUserByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new NotFoundException("Élément non trouvé."));
    }

    /**
     * Met à jour un utilisateur existant.
     * Vérifie si l'utilisateur existe avant de procéder à la mise à jour.
     *
     * @param publicId
     * @param user
     * @return l'utilisateur mis à jour
     */
    @Override
    public User updateUser(UUID publicId, User user) {
        User existingUser = repository.findByPublicId(publicId).orElseThrow(() -> new NotFoundException("Élément non trouvé."));

        repository.findByEmail(user.getEmail()).ifPresent(u -> {
            throw new AlreadyExistException("L'email est déjà associé à un compte.");
        });

        user.setId(existingUser.getId());
        user.setVersion(existingUser.getVersion());
        return repository.save(user);
    }

    /**
     * Crée un nouvel utilisateur.
     * Vérifie si l'email est déjà associé à un compte existant.
     *
     * @param user
     * @return l'utilisateur créé
     */
    @Override
    public User createUser(User user) {
        repository.findByEmail(user.getEmail()).ifPresent(existingUser -> {
            throw new AlreadyExistException("L'email est déjà associé à un compte.");
        });
        return repository.save(user);
    }

    /**
     * Supprime un utilisateur par son identifiant unique.
     *
     * @param publicId
     */
    @Transactional
    @Override
    public void deleteUser(UUID publicId) {
        repository.findByPublicId(publicId).orElseThrow(() -> new NotFoundException("Élément non trouvé."));
        repository.deleteByPublicId(publicId);
    }
}
