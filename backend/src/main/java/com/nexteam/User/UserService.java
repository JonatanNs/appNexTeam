package com.nexteam.User;

import com.nexteam.exception.AlreadyExistException;
import com.nexteam.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Classe 'UserService' en charge de
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

    public User getUser(UUID publicId) {
        return dao.getByPublicId(publicId).orElseThrow( ()-> new NotFoundException("Élément non trouvé."));
    }

    public User getUserByEmail(String email) {
        return dao.getByEmail(email).orElseThrow( () -> new NotFoundException("Élément non trouvé.")) ;
    }

    public User updateUser(UUID publicId, User user) {
        User existingUser = dao.getByPublicId(publicId).orElseThrow(() -> new NotFoundException("Élément non trouvé."));

        user.setId(existingUser.getId());
        user.setVersion(existingUser.getVersion());
        return dao.save(user);
    }

    public User createUser(User user) {
        dao.getByEmail(user.getEmail()).ifPresent(existingUser -> {
            throw new AlreadyExistException("L'email est déjà associé à un compte.");
        });
        return dao.save(user);
    }

    @Transactional
    public void deleteUser(UUID publicId){
        dao.getByPublicId(publicId).orElseThrow( () -> new NotFoundException("Élément non trouvé.") );
        dao.deleteById(publicId);
    }
}
