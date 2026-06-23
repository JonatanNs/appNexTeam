package com.nexteam.user.service;

import com.nexteam.exception.NotFoundException;
import com.nexteam.user.User;
import com.nexteam.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository repository;

    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {

        user1 = User.builder()
                .firstname("Jean")
                .lastname("Dupont")
                .email("jean.dupont@example.com")
                .password("MotDePasse123!")
                .active(true)
                .build();

        user1.setPublicId(UUID.fromString("143191e1-7d4d-4c7d-b9bb-380c2e5b6548"));

        user2 = User.builder()
                .firstname("John")
                .lastname("Doe")
                .email("john.doe@example.com")
                .password("MotDePasse123!")
                .active(true)
                .build();

        user2.setPublicId(UUID.fromString("e6d1585c-7d03-47c6-9e11-b5a7a6281e60"));

    }

    @Test
    void getUsers() {
        when(repository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(Collections.singletonList(user1), Pageable.ofSize(1), 2));

        Page<User> users = service.getUsers(Pageable.ofSize(1));
        assertAll(
                () -> assertEquals(2, users.getTotalElements()),
                () -> assertEquals(2, users.getTotalPages()),
                () -> assertEquals(user1, users.getContent().getFirst()),
                () -> assertNotEquals(0, users.getTotalElements())
        );

        verify(repository).findAll(any(Pageable.class));
    }

    @Test
    void getUser_found() {
        when(repository.findByPublicId(user1.getPublicId())).thenReturn(Optional.of(user1));

        assertEquals(user1, service.getUser(user1.getPublicId()));

        verify(repository).findByPublicId(user1.getPublicId());
    }

    @Test
    void getUser_notFound() {
        UUID unknownId = UUID.fromString("143191e1-7d4d-4c7d-b9bb-380c2e5b6548");
        when(repository.findByPublicId(unknownId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> service.getUser(unknownId));

        verify(repository).findByPublicId(unknownId);
    }

    @Test
    void getUserByEmail_found() {
        String email = "john.doe@example.com";
        when(repository.findByEmail(email)).thenReturn(Optional.of(user2));

        assertEquals(user2, service.getUserByEmail(email));

        verify(repository).findByEmail(email);

    }

    @Test
    void getUserByEmail_notfound() {
        String email = "loulou.doe@example.com";
        when(repository.findByEmail(email)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> service.getUserByEmail(email));

        verify(repository).findByEmail(email);
    }

    @Test
    void updateUser() {

        user1.setFirstname("Paul");

        when(repository.findByPublicId(user1.getPublicId()))
                .thenReturn(Optional.of(user1));

        when(repository.save(any(User.class)))
                .thenReturn(user1);

        User result = service.updateUser(
                user1.getPublicId(),
                user1
        );

        assertEquals("Paul", result.getFirstname());

        verify(repository).findByPublicId(user1.getPublicId());
        verify(repository).save(user1);
    }

    @Test
    void updateUse_emailExisting() {
    }

    @Test
    void updateUser_idNotfound() {
    }

    @Test
    void createUser() {
    }

    @Test
    void deleteUser_found() {
    }

    @Test
    void deleteUser_notfound() {
    }
}

