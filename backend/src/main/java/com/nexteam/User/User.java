package com.nexteam.User;

import com.nexteam.core.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * La classe User représente un utilisateur de l’application.
 *
 * @author JonatanNs
 * @version 1.0
 * @since 26/05/2026 23:41
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class User extends BaseEntity {

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Ce champ ne peux pas être vide.")
    private String firstname, lastname;

    @Email
    @Column(unique = true, nullable = false)
    @NotBlank(message = "Le champ email ne peux pas être vide.")
    private String email;

    @Column(nullable = false)
    //TODO : Mettre un paterne pour le mot de passe
    @NotBlank(message = "Ce champ ne peux pas être vide.")
    private String password;

    private boolean active = true;
}



