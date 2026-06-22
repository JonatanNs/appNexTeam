package com.nexteam.user;

import com.nexteam.exception.AlreadyExistException;
import com.nexteam.exception.NotFoundException;
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
public class UserService {

    private final IUserDAO dao;

    public Page<User> getUsers(Pageable pageable) {
        return dao.getAll(pageable);
    }

    /**
     * Récupère un utilisateur par son identifiant unique.
     * @param publicId
     * @return l'utilisateur trouvé
     */
    public User getUser(UUID publicId) {
        return dao.getByPublicId(publicId).orElseThrow( ()-> new NotFoundException("Élément non trouvé."));
    }

    /**
     * Récupère un utilisateur par son email.
     * @param email
     * @return l'utilisateur trouvé
     */
    public User getUserByEmail(String email) {
        return dao.getByEmail(email).orElseThrow( () -> new NotFoundException("Élément non trouvé.")) ;
    }

    /**
     * Met à jour un utilisateur existant.
     * Vérifie si l'utilisateur existe avant de procéder à la mise à jour.
     * @param publicId
     * @param user
     * @return l'utilisateur mis à jour
     */
    public User updateUser(UUID publicId, User user) {
        User existingUser = dao.getByPublicId(publicId).orElseThrow(() -> new NotFoundException("Élément non trouvé."));

        user.setId(existingUser.getId());
        user.setVersion(existingUser.getVersion());
        return dao.save(user);
    }

    /**
     * Crée un nouvel utilisateur.
     * Vérifie si l'email est déjà associé à un compte existant.
     * @param user
     * @return l'utilisateur créé
     */
    public User createUser(User user) {
        dao.getByEmail(user.getEmail()).ifPresent(existingUser -> {
            throw new AlreadyExistException("L'email est déjà associé à un compte.");
        });
        return dao.save(user);
    }

    /**
     * Supprime un utilisateur par son identifiant unique.
     * @param publicId
     */
    @Transactional
    public void deleteUser(UUID publicId){
        dao.getByPublicId(publicId).orElseThrow( () -> new NotFoundException("Élément non trouvé.") );
        dao.deleteById(publicId);
    }
}
