package com.nexteam.user.service;

import com.nexteam.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Classe 'IUserService' en charge de la gestion des utilisateurs.
 *
 * @author jnsualu2026
 * @since 2026-06-23
 */
public interface IUserService {
    /**
     * Récupère une page d'utilisateurs.
     *
     * @param pageable
     * @return une page d'utilisateurs
     */
    Page<User> getUsers(Pageable pageable);

    /**
     * Récupère un utilisateur par son identifiant unique.
     *
     * @param publicId
     * @return l'utilisateur trouvé
     */
    User getUser(UUID publicId);

    /**
     * Récupère un utilisateur par son email.
     *
     * @param email
     * @return l'utilisateur trouvé
     */
    User getUserByEmail(String email);

    /**
     * Met à jour un utilisateur existant.
     * @param publicId
     * @param user
     * @return l'utilisateur mis à jour
     */
    User updateUser(UUID publicId, User user);

    /**
     * Crée un nouvel utilisateur.
     * @param user
     * @return l'utilisateur créé
     */
    User createUser(User user);

    /**
     * Supprime un utilisateur.
     * @param publicId
     * @return l'utilisateur supprimé
     */
    @Transactional
    void deleteUser(UUID publicId);
}
